package com.nq.glb.automation.test.suite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.DriverType;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.module.LoginModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

public class LoginModuleTest {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = SeleniumUtil.getDriver(DriverType.CHROME);
	}

	@Test
	public void test() {

		LoginModuleProcessor processor = new LoginModuleProcessor(driver);
		SiteDetail siteDetail = new SiteDetail("https://glc-beta.newsquantified.com/");
		processor.setSiteDetail(siteDetail);
		processor.navigate();
		processor.process();
	}

	@AfterClass
	public void finish() {
		SeleniumUtil.closeDriver(driver);
	}

}
