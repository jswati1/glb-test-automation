package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.web.SalesReportsDetail;
import com.nq.glb.automation.module.SalesReportModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * Sales Reports module regression functionality.
 * 
 * @author jswati
 *
 */
public class SalesReportTest extends BaseTestSuite {

	SalesReportModuleProcessor processor;
	SalesReportsDetail reportsDetail;

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click on Sales Reports link in Reports Module
	 */

	@Test
	public void salesReport_avaialble_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
	}

	/**
	 * Test case to validate if the Rate Quote follow up report gets successfully
	 * loaded when user navigates to Reports > Sales Report > Rate Quote follow
	 * up.
	 */
	@Test
	public void rateQuotefollowUpReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getRateQuoteFollowUpReport());
		assertNotNull(reportsDetail.getRateQuoteFollowUpReport().getContent());

	}

	/**
	 * Test case to validate if the Contracts Pending document report gets successfully
	 * loaded when user navigates to Reports > Sales Report > Contracts Pending
	 * Documents Report
	 */
	@Test
	public void contractsPendingDocumentsReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getContractsPendingDocumentsReport());
		assertNotNull(reportsDetail.getContractsPendingDocumentsReport().getContent());

	}

	/**
	 * Test case to validate if the Last Next Contacts report gets successfully
	 * loaded when user navigates to Reports > Sales Report > Last Next Contacts
	 * Report.
	 */
	@Test
	public void lastNextContactsReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getLastNextContactsReport());
		assertNotNull(reportsDetail.getLastNextContactsReport().getContent());

	}

	/**
	 * Test case to validate if the Rate Quote Given report gets successfully
	 * loaded when user navigates to Reports > Sales Report > Rate Quote Given Report.
	 */
	@Test
	public void rateQuoteGivenReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getRateQuoteGivenReport());
		assertNotNull(reportsDetail.getRateQuoteGivenReport().getContent());

	}

	@BeforeMethod
	public void beforeMethod() {
		processor.navigate();
		processor.process();
	}

	@AfterMethod
	public void afterMethod() {
		SeleniumUtil.switchToParentWindow(driver);
	}

	// @BeforeClass
	@BeforeSuite
	public void beforeClass() {
		this.openSite();
		processor = new SalesReportModuleProcessor(driver);
		reportsDetail = processor.loadReport();
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}
