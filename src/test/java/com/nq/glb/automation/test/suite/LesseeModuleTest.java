package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.DriverType;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.RateDetail;
import com.nq.glb.automation.model.web.LesseeDetail;
import com.nq.glb.automation.module.LesseeModuleProcessor;
import com.nq.glb.automation.module.LoginModuleProcessor;
import com.nq.glb.automation.module.RateModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * LESSEE module regression functionality.
 * @author jswati
 *
 */
public class LesseeModuleTest {

	private WebDriver driver;

	private LesseeModuleProcessor processor;
	private Contract contract;

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to enter the correct Contract id and click on searh button under
	 * lessee module
	 */

	// @Test
	public void testLesseeSearch() {
		
		String lesseeNbr ="13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);

	}

	/**
	 * Test case: After successful login on the web site, when user clicks on
	 * Lessee Menu option, then he should have the Lessee module search page.
	*/

	// @Test
	public void testLesseeLoading() {
		
	String lesseeNbr ="13129";
	List<WebElement> searchResult = processor.search(lesseeNbr);
	assertNotNull(searchResult);
	assertTrue(searchResult.size() > 0);
	LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
	assertNotNull(lesseeDetails);
	processor.loadSection(lesseeDetails.getInfo());
}


	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid lessee number and selects the lessee name from search result, he
	 * should be able to view the lessee details and he should be able to
	 * see details under info section.
	 */
	@Test
	public void lesseeModuleInfoSection__whenValidLesseeNumber() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInfo());
		assertNotNull(lesseeDetails.getInfo().getContent().getWebElement());
	}

	
	
	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the lessee info details and he should be able to see details
	 * under lessee module.
	 */

	@Test
	public void lesseeModuleInfoSectionStatus() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInfo());
		assertNotNull(lesseeDetails.getInfo().getContent().getWebElement());
		WebElement infoStatus = lesseeDetails.getInfo().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-1']/div[1]"));
		assertNotNull(infoStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click the comment sub module under Lessee Module
	 */
	@Test
	public void lesseeModuleValidateCommentsSection_availability() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getComments());
		assertNotNull(lesseeDetails.getComments().getContent().getWebElement());
	}

	/**
	 * Check the status in the Comment Module tab,user is in correct sub module
	 * or not
	 */
	@Test
	public void lesseeModuleCommentsSectionStatus() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getComments());
		assertNotNull(lesseeDetails.getComments().getContent().getWebElement());
		WebElement commentStatus = lesseeDetails.getComments().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-2']"));
		assertNotNull(commentStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click the quote section under Lessee Module
	 */

	@Test
	public void lesseeModuleQuoteSection()  {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getQuote());
		assertNotNull(lesseeDetails.getQuote().getContent().getWebElement());
	}

	/**
	 * Check the content  in the quote section under lessee Module tab,user is in correct sub module or
	 * not
	 */

	@Test
	public void lesseeModuleQuoteSectionStatus() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getQuote());
		assertNotNull(lesseeDetails.getQuote().getContent().getWebElement());
		WebElement quoteStatus = lesseeDetails.getQuote().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-3']"));
		assertNotNull(quoteStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click the Contract sub module under Lessee Module
	 */

	@Test
	public void lesseeModuleContractsSection() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getContracts());
		assertNotNull(lesseeDetails.getContracts().getContent().getWebElement());
	}

	/**
	 * Check the status in the Contract Module tab,user is in correct module or
	 * not
	 */

	@Test
	public void lesseeModuleContractsSectionStatus() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getContracts());
		assertNotNull(lesseeDetails.getContracts().getContent().getWebElement());
		WebElement contractsStatus = lesseeDetails.getContracts().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-4']"));
		assertNotNull(contractsStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click the vendor sub module under Lessee Module
	 */

	@Test
	public void lesseeModuleVendorSection() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getVendor());
		assertNotNull(lesseeDetails.getVendor().getContent().getWebElement());
	}

	/**
	 * Check the status in the vendor Module tab,user is in correct module or
	 * not
	 */

	@Test
	public void lesseeModuleVendorSectionStatus() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getVendor());
		assertNotNull(lesseeDetails.getVendor().getContent().getWebElement());
		WebElement vendorStatus = lesseeDetails.getVendor().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-7']"));
		assertNotNull(vendorStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click the vendor broker sub module under Lessee Module
	 */

	@Test
	public void lesseeModuleVendorBrokerSection() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getVendorBroker());
		assertNotNull(lesseeDetails.getVendorBroker().getContent().getWebElement());
	}

	/**
	 * Check the status in the vendor broker Module tab,user is in correct
	 * module or not
	 */

	@Test
	public void lesseeModuleVendorBrokerSectionStatus() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getVendorBroker());
		assertNotNull(lesseeDetails.getVendorBroker().getContent().getWebElement());
		WebElement vbrokerStatus = lesseeDetails.getVendorBroker().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-7']"));
		assertNotNull(vbrokerStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click the invester sub module under Lessee Module
	 */

	@Test
	public void lesseeModuleInvestorSection() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInvestor());
		assertNotNull(lesseeDetails.getInvestor().getContent().getWebElement());
	}

	/**
	 * Check the status in the investor Module tab,user is in correct module or
	 * not
	 */

	@Test
	public void lesseeModuleInvestorSectionStatus() {

		String lesseeNbr = "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(this.contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInvestor());
		assertNotNull(lesseeDetails.getInvestor().getContent().getWebElement());
		WebElement investerStatus = lesseeDetails.getInvestor().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-6']"));
		assertNotNull(investerStatus);
	}

	@BeforeMethod
	public void beforeMethod() {
		processor.navigate();
	}

	@AfterMethod
	public void afterMethod() {
		SeleniumUtil.switchToParentWindow(driver);
	}

	@BeforeSuite
	public void beforeSuite() {
		driver = SeleniumUtil.getDriver(DriverType.CHROME);
		LoginModuleProcessor loginProcessor = new LoginModuleProcessor(driver);
		SiteDetail siteDetail = new SiteDetail("https://glc-beta.newsquantified.com/");
		loginProcessor.setSiteDetail(siteDetail);
		loginProcessor.process();
		RateModuleProcessor rateProcessor = new RateModuleProcessor(driver);
		rateProcessor.navigate();
		String contractId = "22244";
		List<WebElement> contracts = rateProcessor.search(contractId);
		RateDetail contractDetails = rateProcessor.process(contractId, contracts.get(0));
		this.contract = rateProcessor.getContract(contractDetails);
		processor = new LesseeModuleProcessor(driver);
	}

	@AfterSuite
	public void afterSuite() {
		SeleniumUtil.closeDriver(driver);
	}
}
