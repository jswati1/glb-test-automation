package com.nq.glb.automation.test.suite;

import org.openqa.selenium.WebDriver;

import com.nq.glb.automation.model.DriverType;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.module.LoginModuleProcessor;
import com.nq.glb.automation.module.LogoutModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * Login functionality.
 * 
 * @author jswati
 *
 */
public class LoginModuleTest {

	private WebDriver driver;

//	@BeforeClass
	public void setup() {
		driver = SeleniumUtil.getDriver(DriverType.CHROME);
	}

//	@Test
	public void validateLogin() {

		LoginModuleProcessor processor = new LoginModuleProcessor(driver);
		SiteDetail siteDetail = new SiteDetail("https://glc-beta.newsquantified.com/");
		processor.setSiteDetail(siteDetail);
		processor.navigate();
		processor.process();
	}

	//@AfterClass
	public void finish() {
		LogoutModuleProcessor logoutProcessor = new LogoutModuleProcessor(driver);
		logoutProcessor.process();
		SeleniumUtil.closeDriver(driver);
	}

}
