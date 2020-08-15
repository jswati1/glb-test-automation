package com.nq.glb.automation.test.suite;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nq.glb.automation.config.AutomationTestConfig;
import com.nq.glb.automation.config.Configuration;
import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.RateDetail;
import com.nq.glb.automation.module.LoginModuleProcessor;
import com.nq.glb.automation.module.RateModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This base class provides the common logic that is needed to be invoked for
 * all the test suites.
 * 
 * @author jswati
 *
 */
public class BaseTestSuite {

	protected static WebDriver driver;
	protected static Contract contract;
	private static boolean loggedIn = false;

	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest testlogger;

	// @BeforeSuite
	public void setReport() {

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExecutionReports/extent-"
				+ CustomUtility.getCurrentDateTime() + ".html");
		htmlreporter.config().setDocumentTitle("Automation Report"); // Tile of
																		// report
		htmlreporter.config().setReportName("Functional Testing"); // Name of
																	// the
																	// report
		htmlreporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		extent.setSystemInfo("User Location", System.getProperty("user.country"));
		extent.setSystemInfo("OS name", System.getProperty("os.name"));
		extent.setSystemInfo("OS version", System.getProperty("os.version"));
		extent.setSystemInfo("JDK version", System.getProperty("java.version"));
	}

	// @AfterSuite
	public void endReport() {
		extent.flush();
	}

	public void loadTestData() {

		contract = AutomationTestConfig.automationContext().getTestData();
		if (contract == null) {
			RateModuleProcessor rateProcessor = new RateModuleProcessor(driver);
			rateProcessor.navigate();
			String contractId = "22244";
			List<WebElement> contracts = rateProcessor.search(contractId);
			RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
			contract = rateProcessor.getContract(contractDetails);
		}
		// System.out.println("contract:" + contract);

	}

	public static class CustomUtility {

		public static String captureScreenshot(WebDriver driver, String screenshotName) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName
					+ CustomUtility.getCurrentDateTime() + ".png";
			File finalDestinaton = new File(dest);
			try {
				FileHandler.copy(src, finalDestinaton);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return dest;
		}

		public static String getCurrentDateTime() {
			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-h-m-s");
			Date date = new Date();
			return dateFormat.format(date);
		}
	}

	public void openSite() {
		synchronized (BaseTestSuite.class) {
			if (!loggedIn) {
				driver = AutomationTestConfig.automationContext().getDriver();
				System.out.println("*********************Configurations***************");
				System.out.println(AutomationTestConfig.automationContext());
				System.out.println("****************************************************");
				LoginModuleProcessor loginProcessor = new LoginModuleProcessor(driver);
				Configuration config = AutomationTestConfig.automationContext().getAppConfig();
				SiteDetail siteDetail = new SiteDetail(config.getSiteUrl());
				siteDetail.setUser(config.getCredentials().get(0));
				loginProcessor.setSiteDetail(siteDetail);
				loginProcessor.process();
				if (contract == null) {
					loadTestData();
				}
				loggedIn = true;
			}
		}

	}

	public void closeSite() {
		// LogoutModuleProcessor logoutProcessor = new
		// LogoutModuleProcessor(driver);
		// logoutProcessor.process();
		if (driver != null)
			SeleniumUtil.closeDriver(driver);
	}

}
