package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.web.ManagementReportsDetail;
import com.nq.glb.automation.module.ManagementReportModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * Management Reports module regression functionality.
 * 
 * @author jswati
 *
 */
public class ManagementReportTest extends BaseTestSuite {

	ManagementReportModuleProcessor processor;
	ManagementReportsDetail reportsDetail;

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click on Management Reports link in Reports Module.
	 */

	@Test
	public void contractStatucReport_avaialble_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
	}

	/**
	 * Test case is written to validate if the deal funded report gets successfully loaded
	 * when user navigates to Reports > Management Report > Deal Funded Report.
	 */
	@Test
	public void dealFundedReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getDealFundedReport());
		assertNotNull(reportsDetail.getDealFundedReport().getContent());

	}

	/**
	 * Test case is written to validate if the contract status change report gets successfully
	 * loaded when user navigates to Reports > Management Status Report >
	 * Contract Status Change Report.
	 */
	@Test
	public void contractSttausChangeReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getContractStatusChangeReport());
		assertNotNull(reportsDetail.getContractStatusChangeReport().getContent());

	}

	/**
	 * Test case to validate if the Vendor Payable report gets successfully
	 * loaded when user navigates to Reports > Management Status Report > Vendor
	 * payable Report.
	 */
	@Test
	public void vendorPayableReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getVendorsPayableReport());
		assertNotNull(reportsDetail.getVendorsPayableReport().getContent());

	}

	/**
	 * Test case to validate if the Document Status Summary report gets successfully
	 * loaded when user navigates to Reports > Management Status Report >
	 * Document Status Summary Report
	 */
	@Test
	public void documentStatusSummaryReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getDocumentsStatusSummaryReport());
		assertNotNull(reportsDetail.getDocumentsStatusSummaryReport().getContent());

	}

	/**
	 * Test case is written to validate if  Funding due Report report gets successfully
	 * loaded when user navigates to Reports > Management Status Report >
	 * Funding due Report
	 */
	@Test
	public void fundingDueReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getFundingDueReport());
		assertNotNull(reportsDetail.getFundingDueReport().getContent());

	}

	/**
	 * Test case is written to validate if the Monthly Rental report gets successfully
	 * loaded when user navigates to Reports > Management Status Report >
	 * Monthly Rental Report
	 */
	@Test
	public void monthlyRentalReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getMonthlyRentalReport());
		assertNotNull(reportsDetail.getMonthlyRentalReport().getContent());

	}

	/**
	 * Test case to validate if Gross Margin report gets successfully
	 * loaded when user navigates to Reports > Management Status Report > Gross
	 * Margin Report
	 */
	@Test
	public void grossMarginReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getGrossMarginReport());
		assertNotNull(reportsDetail.getGrossMarginReport().getContent());

	}

	@BeforeMethod
	public void beforeMethod() {
		processor.navigate();
		processor.process();
		if (contract == null) {
			loadTestData();
		}

	}

	@AfterMethod
	public void afterMethod() {
		SeleniumUtil.switchToParentWindow(driver);
	}

	// @BeforeClass
	@BeforeSuite
	public void beforeClass() {
		this.openSite();
		processor = new ManagementReportModuleProcessor(driver);
		reportsDetail = processor.loadReport();
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}
