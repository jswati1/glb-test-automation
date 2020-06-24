package com.nq.glb.automation.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author jswati
 *
 */
public class AutomationTestListener implements ITestListener {

	Logger logger = LoggerFactory.getLogger(AutomationTestListener.class);

	String filePath = "SCREENSHOTS";

	ExtentHtmlReporter reporter;

	boolean started = false;

	ExtentReports extent = new ExtentReports();
	ExtentTest test;

	public AutomationTestListener() {
		System.setProperty("org.freemarker.loggerLibrary", "none");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// System.out.println("Starting the execution of" + result.getName());
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		// String methodName = result.getName().toString().trim();
		// ITestContext context = result.getTestContext();
		// WebDriver driver = (WebDriver) context.getAttribute("driver");
		// takeScreenShot(methodName, driver);
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
		test.fail(result.getThrowable());
	}

	public void takeScreenShot(String methodName, WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
			// System.out.println("***Placed screen shot in " + filePath + "
			// ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
		test.skip(result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.log(Status.WARNING, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.YELLOW));
		test.warning(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {

		logger.info("**********************Intializing the testing context**********************");
		if (!started) {
			String basepath = context.getCurrentXmlTest().getParameter("config-file-path");
			if (StringUtils.isBlank(basepath))
				basepath = "";
			AutomationTestConfig configs = AutomationTestConfig.automationContext(basepath);
			logger.info("loading the test configurations from {}", basepath);
			String reportsPath = configs.getTestConfig().getProperty("test.execution.report.path");
			if (StringUtils.isBlank(reportsPath)) {
				reportsPath = (basepath + "/" + "reports");
			}
			Path path = Paths.get(reportsPath);
			if (Files.notExists(path)) {
				try {
					Files.createDirectory(path);
				} catch (IOException e) {
					logger.error(
							"unable to create the required directory for generating test results report. please manually create the following directory structure before executing the test cases {}",
							(reportsPath));
				}
			} else {
				logger.info("report directory already exists {} ", reportsPath);
			}
			path = Paths.get(reportsPath + "/glb_automation.html");
			if (Files.notExists(path)) {
				try {
					path = Paths.get(reportsPath + "/glb_automation.html");
					Files.createFile(path);
				} catch (IOException e) {
					logger.error(
							"unable to create the required file for generating test results report. please manually create the following directory structure before executing the test cases {}",
							(reportsPath + "/glb_automation.html"));
				}
			} else {
				logger.info("report file already exists {} ", path);
			}
			reportsPath=".";
			reporter = new ExtentHtmlReporter(reportsPath + "/reports/glb_automation.html");
			reporter.config().setChartVisibilityOnOpen(true);
			reporter.config().setDocumentTitle("GLB Automation Test Report");
			reporter.config().setReportName("GLB Automation Test Results");
			reporter.config().setTestViewChartLocation(ChartLocation.TOP);
			reporter.config().setTheme(Theme.STANDARD);
			reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			extent.attachReporter(reporter);
			AutomationTestConfig.automationContext().getDriver();
			started = true;
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		logger.info("**********************Test Execution Finished**********************");
	}

}