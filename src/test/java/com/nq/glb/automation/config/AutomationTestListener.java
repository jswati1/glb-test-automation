package com.nq.glb.automation.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AutomationTestListener implements ITestListener {

	WebDriver driver = null;
	String filePath = "D:\\SCREENSHOTS";

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Starting the execution of" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		//takeScreenShot(methodName, driver);
	}

	public void takeScreenShot(String methodName, WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}