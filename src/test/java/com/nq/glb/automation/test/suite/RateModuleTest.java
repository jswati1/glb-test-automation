package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.DriverType;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.RateDetail;
import com.nq.glb.automation.module.LoginModuleProcessor;
import com.nq.glb.automation.module.RateModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * RATE module regression functionality.
 * 
 * @author jswati
 *
 */
public class RateModuleTest {

	private WebDriver driver;

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
	 * able to view the contract section availablility and he should be able to see
	 * details under quote section.
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
	 * Test case= Check the status in the contract Tab -is it in a correct tab
	 * or not
	 */
	@Test
	public void testContractStatus() {

		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getContracts());
		assertNotNull(contractDetails.getContracts().getContent().getWebElement());
		WebElement contractStatus = this.driver.findElement(By.xpath("//*[@id='main-tab']/div[2]/div[1]/div[1]"));
		assertNotNull(contractStatus);
	}

	/**
	 * user is clicking on Comment tab under Rate quote
	 */
	@Test
	public void commentsModule() {

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
	 * Check the status in the Comment tab
	 */
	@Test
	public void commentsStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		System.out.println(contractDetails);
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getComments());
		assertNotNull(contractDetails.getComments().getContent().getWebElement());
		WebElement commentStatus = this.driver.findElement(By.xpath("//*[@id='main-tab']/div/div/div[1]"));
		assertNotNull(commentStatus);
	}

	/**
	 * Click on the Equipment tab
	 */
	@Test
	public void equipmentModule() {
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
	 * Check the status in the Equipment status
	 */
	@Test
	public void equipmentStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getEquipment());
		assertNotNull(contractDetails.getEquipment().getContent().getWebElement());
		WebElement equipmentStatus = this.driver
				.findElement(By.xpath("//*[@id='main-tab']/div[1]/div[2]/div/div[1]/div[1]"));
		assertNotNull(equipmentStatus);
	}

	/**
	 * Click on Document tab
	 */
	@Test
	public void documentsModule() {
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
	 * check the status in the Document tab -is user in the correct tab or not
	 */
	@Test
	public void documentsStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getDocuments());
		assertNotNull(contractDetails.getDocuments().getContent().getWebElement());
		WebElement documentStatus = this.driver.findElement(By.xpath("//*[@id='main-tab']/div[1]/div[2]/div[1]/h5"));
		assertNotNull(documentStatus);

	}

	/**
	 * the test case is written to clicking the Lessee tab
	 */
	@Test
	public void lesseeModule() {
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
	 * check the status in the Lessee tab -is user in the correct tab or not
	 */
	public void LesseeStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getLessee());
		assertNotNull(contractDetails.getLessee().getContent().getWebElement());
		WebElement lesseStatus = this.driver.findElement(By.xpath("//*[@id='main-tab']/div[1]/div[2]/div[1]/h5"));
		assertNotNull(lesseStatus);
	}

	/**
	 * user is clicking to Vendortab under Ratequote
	 */
	@Test
	public void vendorModule() {
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
	 * check the status in the Vendor tab -is user in the correct tab or not
	 */
	@Test
	public void vendorStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getVendor());
		assertNotNull(contractDetails.getVendor().getContent().getWebElement());
		WebElement vendorstatus = this.driver
				.findElement(By.xpath("//*[@id='main-tab']/div/div[2]/div[2]/div[1]/div[1]/h5"));
		assertNotNull(vendorstatus);

	}

	/**
	 * User is clicking on VendorBroker tab
	 */
	@Test
	public void vendorBroker() {
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
	 * check the status in the VendorBroker tab -is user in the correct tab or
	 * not
	 */
	@Test
	public void vendorBrokerStatus() {
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
	 * The test case is written to validate that User is clicking on Investor
	 * tab
	 */
	@Test
	public void investorModule() {
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
	 * validating the status is user in investor status or not
	 * 
	 */

	@Test
	public void investorStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvestor());
		assertNotNull(contractDetails.getInvestor().getContent().getWebElement());
		WebElement investorstatus = this.driver.findElement(By.xpath("//*[@id='main-tab']/div[1]/div[2]/div[1]/h5"));
		assertNotNull(investorstatus);
	}

	/**
	 * The test case is written to validate that User is clicking on
	 * InvestorBroker tab
	 */

	@Test
	public void investorBrokerModule() {
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
	 * validating the status is user in investor brokerstatus or not
	 * 
	 */
	@Test
	public void investorBrokerStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvestorBroker());
		assertNotNull(contractDetails.getInvestorBroker().getContent().getWebElement());
		WebElement investorbrokerstatus = this.driver
				.findElement(By.xpath("//*[@id='main-tab']/div/div[2]/div[2]/div[1]/div[1]/ul/li[1]"));
		assertNotNull(investorbrokerstatus);
	}

	/**
	 * The test case is written to validate that User is clicking on Rec/dis tab
	 */
	@Test
	public void recdisModule() {
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
	 * validating the status is user in Rec/dis status or not
	 * 
	 */
	@Test
	public void recdisStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getRecDis());
		assertNotNull(contractDetails.getRecDis().getContent().getWebElement());
		WebElement recdisstatus = this.driver.findElement(By.xpath("//*[@id='equipmentTable']/thead/tr/th[2]"));
		assertNotNull(recdisstatus);
	}

	/**
	 * The test case is written to validate that User is clicking on state tab
	 */
	@Test
	public void stateModule() {
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
	 * validating the status is user in state status or not
	 * 
	 */
	@Test
	public void stateStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getState());
		assertNotNull(contractDetails.getState().getContent().getWebElement());
		WebElement statestatus = this.driver.findElement(By.xpath("//*[@id='main-tab']/div/div[2]/div[4]/ul/li[1]"));
		assertNotNull(statestatus);
	}

	@Test
	public void invoiceschedulerModule() {
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
	 * validating the status is user in invoice schedule status or not
	 * 
	 */

	@Test
	public void invoicescheduleStatus() {
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		assertNotNull(contracts);
		assertTrue(contracts.size() > 0);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		assertNotNull(contractDetails);
		rateProcessor.loadSection(contractDetails.getInvoiceSchedule());
		assertNotNull(contractDetails.getInvoiceSchedule().getContent().getWebElement());
		WebElement invoiceschestatus = this.driver
				.findElement(By.xpath("//*[@id='tab-11']/div[1]/div[2]/div[1]/ul/li"));
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
		System.out.println("Contract Information: " + contract);
	}

	@BeforeMethod
	public void beforeMethod() {
		rateProcessor.navigate();
	}

	@AfterMethod
	public void afterMethod() {
		SeleniumUtil.switchToParentWindow(driver);
	}

	@BeforeClass
	public void beforeClass() {
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

	@BeforeSuite
	public void beforeSuite() {
		driver = SeleniumUtil.getDriver(DriverType.CHROME);
		LoginModuleProcessor loginProcessor = new LoginModuleProcessor(driver);
		SiteDetail siteDetail = new SiteDetail("https://glc-beta.newsquantified.com/");
		loginProcessor.setSiteDetail(siteDetail);
		loginProcessor.process();
		rateProcessor = new RateModuleProcessor(driver);

	}

	@AfterSuite
	public void afterSuite() {
		SeleniumUtil.closeDriver(driver);
	}

}
