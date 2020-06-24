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

import com.nq.glb.automation.model.web.InvoicesDetail;
import com.nq.glb.automation.module.InvoicesModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * Invoice module regression functionality(Utilities).
 * 
 * @author jswati
 *
 */
public class InvoicesModuleTest extends BaseTestSuite {

	private InvoicesModuleProcessor invoicesprocessor;
	private InvoicesDetail invoicesDetail;

	/**
	 * Test case to validate if the Invoice Module gets successfully
	 * loaded when user navigates to Utilities > Invoice Status Report
	 */
	@Test
	public void invoices_loading_success() {
		SeleniumUtil.loadElement(invoicesDetail.getHeader(), driver);
		assertNotNull(invoicesDetail.getHeader().getWebElement());
		SeleniumUtil.loadElement(invoicesDetail.getContent(), driver);
		assertNotNull(invoicesDetail.getContent().getWebElement());
	}

	@BeforeMethod
	public void beforeMethod() {
		invoicesprocessor.navigate();
		if (contract == null) {
			loadTestData();
		}
		invoicesprocessor.process();
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
		invoicesprocessor = new InvoicesModuleProcessor(driver);
		invoicesDetail = invoicesprocessor.loadUtilities();
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}