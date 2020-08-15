package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.web.FilterDetail;
import com.nq.glb.automation.module.FilterModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * Filter module regression functionality(Utilities).
 * 
 * @author jswati
 *
 */
public class FilterModuleTest extends BaseTestSuite {

	private FilterModuleProcessor filterprocessor;
	private FilterDetail filterDetail;

	/**
	 * Test case to validate if the Filter Module gets successfully
	 * loaded when user navigates to Utilities > Filter Status 
	 */
	@Test
	public void filter_loading_success() {
		SeleniumUtil.loadElement(filterDetail.getHeader(), driver);
		assertNotNull(filterDetail.getHeader().getWebElement());
		SeleniumUtil.loadElement(filterDetail.getContent(), driver);
		assertNotNull(filterDetail.getContent().getWebElement());
	}

	@BeforeMethod
	public void beforeMethod() {
		filterprocessor.navigate();
		if (contract == null) {
			loadTestData();
		}
		filterprocessor.process();
	}

	@AfterMethod
	public void afterMethod() {
		SeleniumUtil.switchToParentWindow(driver);
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {

	}

	@BeforeClass
	public void beforeClass() {
		this.openSite();
		filterprocessor = new FilterModuleProcessor(driver);
		filterDetail = filterprocessor.loadUtilities();
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}