package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.web.RateDetail;
import com.nq.glb.automation.module.RateModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * RATE module regression functionality.
 * 
 * @author jswati
 *
 */
public class RateModuleTest extends BaseTestSuite {

	private RateModuleProcessor rateProcessor;

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid contract Id and he should get atleast one contract in the
	 * search results.
	 */
	@Test
	public void rateContractSearch_whenValidContractId() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the invalid contract Id, he should not receive any search results to
	 * browse.
	 */
	@Test
	public void rateContractSearch_whenInValidContractId() {
		String contractId = "qqqq";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNull(contracts);
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid contract Id and selects the contract from search result, he
	 * should be able to view the rate contract details.
	 */
	@Test
	public void rateContractDetails_whenValidContractId() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		contractDetails.getSummary().setWebElement(driver.findElement(contractDetails.getSummary().getXpath()));
		assertNotNull(contractDetails.getSummary().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid contract Id and selects the contract from search result, he
	 * should be able to view the rate contract details.
	 */
	@Test
	public void rateContractDetails_success_whenValidContractId() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getQuote());
		assertNotNull(contractDetails.getQuote().getContent().getWebElement());
		WebElement quoteStatus = contractDetails.getQuote().getContent().getWebElement()
				.findElement(By.xpath("div[2]/div[1]/ul/li[1]/span"));
		assertNotNull(quoteStatus);
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid contract Id and selects the contract from search result, he
	 * should be able to view the rate contract details and he should be able to
	 * see quote option.
	 */
	@Test
	public void rateContractQuoteSection_whenValidContractId() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getQuote());
		assertNotNull(contractDetails.getQuote().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid contract Id and selects the contract from search result, he
	 * should be able to view the rate contract details and he should be able to
	 * see details under quote section.
	 */
	@Test
	public void rateContractQuoteSectionDetails_whenValidContractId() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getQuote());
		assertNotNull(contractDetails.getQuote().getContent().getWebElement());
		WebElement quoteStatus = contractDetails.getQuote().getContent().getWebElement()
				.findElement(By.xpath("div[2]/div[1]/ul/li[1]/span"));
		assertNotNull(quoteStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the contract section availability and he should be able to
	 * see details under quote section.
	 */

	@Test
	public void rateContractSectionDetails_whenValidContractId() {

		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getContracts());
		assertNotNull(contractDetails.getContracts().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Contracts section availability and user should be able
	 * to see details under Contracts section of Rate Module
	 */
	@Test
	public void rateModuleValidateContractSectionStatus() {

		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getContracts());
		assertNotNull(contractDetails.getContracts().getContent().getWebElement());
		WebElement contractStatus = driver.findElement(By.xpath("//*[@id='main-tab']/div[2]/div[1]/div[1]"));
		assertNotNull(contractStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Comment section under Rate Module
	 */
	@Test
	public void rateModuleNavigateCommentsSection() {

		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getComments());
		assertNotNull(contractDetails.getComments().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Comment section availability and user should be able to
	 * see details under Comment section of Rate Module
	 */
	@Test
	public void rateModuleValidateCommentsSectioStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getComments());
		assertNotNull(contractDetails.getComments().getContent().getWebElement());
		WebElement commentStatus = driver.findElement(By.xpath("//*[@id='main-tab']/div/div/div[1]"));
		assertNotNull(commentStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Equipment section under Rate Module
	 */
	@Test
	public void rateModuleNavigateEquipmentSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getEquipment());
		assertNotNull(contractDetails.getEquipment().getContent().getWebElement());

	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Equipment section availability and user should be able
	 * to see details under Equipment section of Rate Module
	 */
	@Test
	public void rateModuleValidateEquipmentSectionStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getEquipment());
		assertNotNull(contractDetails.getEquipment().getContent().getWebElement());
		WebElement equipmentStatus = driver
				.findElement(By.xpath("//*[@id='main-tab']/div[1]/div[2]/div/div[1]/div[1]"));
		assertNotNull(equipmentStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Documents section under Rate Module
	 */
	@Test
	public void rateModuleNavigateDocumentsSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getDocuments());
		assertNotNull(contractDetails.getDocuments().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Document section availability and user should be able to
	 * see details under Document section of Rate Module
	 */
	@Test
	public void rateModuleValidateDocumentsSectionStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getDocuments());
		assertNotNull(contractDetails.getDocuments().getContent().getWebElement());
		WebElement documentStatus = driver.findElement(By.xpath("//*[@id='main-tab']/div[1]/div[2]/div[1]/h5"));
		assertNotNull(documentStatus);

	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Lessee section under Rate Module
	 */
	@Test
	public void rateModuleNavigateLesseeSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getLessee());
		assertNotNull(contractDetails.getLessee().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Lessee section availability and user should be able to
	 * see details under Lessee section of Rate Module
	 */
	public void rateModuleValidateLesseeSetionStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getLessee());
		assertNotNull(contractDetails.getLessee().getContent().getWebElement());
		WebElement lesseStatus = driver.findElement(By.xpath("//*[@id='main-tab']/div[1]/div[2]/div[1]/h5"));
		assertNotNull(lesseStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Vendor section under Rate Module
	 */
	@Test
	public void rateModuleNavigateVendorSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getVendor());
		assertNotNull(contractDetails.getVendor().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Vendor section availability and user should be able to
	 * see details under Vendor section of Rate Module
	 */
	@Test
	public void rateModuleValidateVendorSectionStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getVendor());
		assertNotNull(contractDetails.getVendor().getContent().getWebElement());
		WebElement vendorstatus = driver
				.findElement(By.xpath("//*[@id='main-tab']/div/div[2]/div[2]/div[1]/div[1]/h5"));
		assertNotNull(vendorstatus);

	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Vendor-Broker section under Rate Module
	 */
	@Test
	public void rateModuleNavigateVendorBrokerSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getVendorBroker());
		assertNotNull(contractDetails.getVendorBroker().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Vendor-Broker section availability and user should be
	 * able to see details under Vendor-Broker section of Rate Module
	 */
	@Test
	public void rateModuleValidateVendorBrokerSectionStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getVendorBroker());
		assertNotNull(contractDetails.getVendorBroker().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Investor section under Rate Module
	 */
	@Test
	public void rateModuleNavigateInvestorSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvestor());
		assertNotNull(contractDetails.getInvestor().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Investor section availability and user should be able to
	 * see details under Investor section of Rate Module
	 */

	@Test
	public void rateModuleValidateInvestorSectionStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvestor());
		assertNotNull(contractDetails.getInvestor().getContent().getWebElement());
		WebElement investorstatus = driver.findElement(By.xpath("//*[@id='main-tab']/div[1]/div[2]/div[1]/h5"));
		assertNotNull(investorstatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Investor-Broker section under Rate Module
	 */

	@Test
	public void rateModuleNavigateInvestorBrokerSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvestorBroker());
		assertNotNull(contractDetails.getInvestorBroker().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Investor-Broker section availability and user should be
	 * able to see details under Investor=Broker section of Rate Module
	 */
	@Test
	public void rateModuleValidateInvestorBrokerStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvestorBroker());
		assertNotNull(contractDetails.getInvestorBroker().getContent().getWebElement());
		WebElement investorbrokerstatus = driver
				.findElement(By.xpath("//*[@id='main-tab']/div/div[2]/div[2]/div[1]/div[1]/ul/li[1]"));
		assertNotNull(investorbrokerstatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Rec-Dis section under Rate Module
	 */
	@Test
	public void rateModuleNavigateRec_DisSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getRecDis());
		assertNotNull(contractDetails.getRecDis().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Rec-Dis section availability and user should be able to
	 * see details under Rec-Dis section of Rate Module
	 */
	@Test
	public void rateModuleValidateRec_DisSectionStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getRecDis());
		assertNotNull(contractDetails.getRecDis().getContent().getWebElement());
		WebElement recdisstatus = driver.findElement(By.xpath("//*[@id='equipmentTable']/thead/tr/th[2]"));
		assertNotNull(recdisstatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the State section under Rate Module
	 */
	@Test
	public void rateModuleNavigateStateSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getState());
		assertNotNull(contractDetails.getState().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the State section availability and user should be able to
	 * see details under State section of Rate Module
	 */
	@Test
	public void rateModuleValidateStateSectionStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getState());
		assertNotNull(contractDetails.getState().getContent().getWebElement());
		WebElement statestatus = driver.findElement(By.xpath("//*[@id='main-tab']/div/div[2]/div[4]/ul/li[1]"));
		assertNotNull(statestatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Invoice Schedule section under Rate Module
	 */
	@Test
	public void rateModuleNavigateInvoiceScheduleSection() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvoiceSchedule());
		assertNotNull(contractDetails.getInvoiceSchedule().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Invoice Schedule section availability and user should be
	 * able to see details under Invoice Schedule section of Rate Module
	 */

	@Test
	public void rateModuleValidateInvoiceScheduleStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvoiceSchedule());
		assertNotNull(contractDetails.getInvoiceSchedule().getContent().getWebElement());
		WebElement invoiceschestatus = driver.findElement(By.xpath("//*[@id='tab-11']/div[1]/div[2]/div[1]/ul/li"));
		assertNotNull(invoiceschestatus);
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid contract Id and selects the contract from search result, he
	 * should be able to view the rate contract details.
	 */
	@Test
	public void rateContract_success_whenValidContractId() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		Contract contract = rateProcessor.getContract(contractDetails);
		// System.out.println("Contract Information: " + contract);
	}

	@BeforeMethod
	public void beforeMethod() {
		rateProcessor.navigate();
		if (contract == null) {
			loadTestData();
		}
	}

	@AfterMethod
	public void afterMethod() {
		SeleniumUtil.switchToParentWindow(driver);
	}

	@BeforeClass()
	public void beforeClass() {
		this.openSite();
		rateProcessor = new RateModuleProcessor(driver);
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

	@AfterSuite
	public void afterSuite() {
		// LogoutModuleProcessor logoutProcessor = new
		// LogoutModuleProcessor(driver);
		// logoutProcessor.process();
		this.closeSite();
	}

}
