package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.web.ContractStatusReportsDetail;
import com.nq.glb.automation.module.ContractStatusReportModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * Contract Status Reports module regression functionality.
 * 
 * @author jswati
 *
 */
public class ContractStatusReportTest extends BaseTestSuite {

	ContractStatusReportModuleProcessor processor;
	ContractStatusReportsDetail reportsDetail;

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click on Contract Status Reports link in Reports Module
	 */

	/**
	 * Test case to validate if the contract status report is available when the
	 * user navigates to Reports module.
	 */
	@Test
	public void contractStatucReport_avaialble_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
	}

	/**
	 * Test case to validate if the contract Active report gets successfully
	 * loaded when user navigates to Reports > Contract Status Report > Contract
	 * Active Report.
	 */
	@Test
	public void contractActiveReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getContractActiveReport());
		assertNotNull(reportsDetail.getContractActiveReport().getContent());

	}

	/**
	 * Test case to validate if the rqActive report gets successfully loaded
	 * when user navigates to Reports > Contract Status Report > RQ Active
	 * Report.
	 */
	@Test
	public void rqActiveReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getRqActiveReport());
		assertNotNull(reportsDetail.getRqActiveReport().getContent());

	}

	/**
	 * Test case to validate if the DocsComplete report gets successfully loaded
	 * when user navigates to Reports > Contract Status Report > Docs Complete
	 * Report.
	 */
	@Test
	public void docsCompleteReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getDocsCompleteReport());
		assertNotNull(reportsDetail.getDocsCompleteReport().getContent());

	}

	/**
	 * Test case to validate if the DocsComplete report gets successfully loaded
	 * when user navigates to Reports > Contract Status Report > Pending
	 * SInProcess Report.
	 */
	@Test
	public void pendingInProcessReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getPendingInProcessReport());
		assertNotNull(reportsDetail.getPendingInProcessReport().getContent());

	}

	/**
	 * Test case to validate if the DocsComplete report gets successfully loaded
	 * when user navigates to Reports > Contract Status Report > End of Lease
	 * 
	 * Report.
	 */
	@Test
	public void endofLeaseReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getEndOfLeaseReport());
		assertNotNull(reportsDetail.getEndOfLeaseReport().getContent());

	}

	/**
	 * Test case to validate if the DocsComplete report gets successfully loaded
	 * when user navigates to Reports > Contract Status Report > Post Closing
	 * Checklist Report.
	 */
	@Test
	public void postClosingChecklistReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getPostClosingChecklistReport());
		assertNotNull(reportsDetail.getPostClosingChecklistReport().getContent());

	}

	/**
	 * Test case to validate if the DocsComplete report gets successfully loaded
	 * when user navigates to Reports > Contract Status Report > Skipped
	 * Payments Report.
	 */
	@Test
	public void skippedPaymentsReport_loading_success() {
		reportsDetail.getRoot().setWebElement(driver.findElement(reportsDetail.getRoot().getXpath()));
		WebElement reportContainer = reportsDetail.getRoot().getWebElement();
		assertNotNull(reportContainer);
		processor.loadSection(reportsDetail.getSkippedPaymentsReport());
		assertNotNull(reportsDetail.getSkippedPaymentsReport().getContent());

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
		processor = new ContractStatusReportModuleProcessor(driver);
		reportsDetail = processor.loadReport();
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}
