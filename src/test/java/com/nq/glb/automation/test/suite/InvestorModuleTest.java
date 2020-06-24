package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.web.InvestorDetail;
import com.nq.glb.automation.module.InvestorModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * INVESTOR module regression functionality.
 * 
 * @author jswati
 *
 */
public class InvestorModuleTest extends BaseTestSuite {

	private InvestorModuleProcessor processor;

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to enter the correct investor id and click on search button under
	 * Investor module
	 */

	@Test
	public void testInvestorSearch() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);

	}

	/**
	 * Test case: After successful login on the web site, when user clicks on
	 * Investor Menu option, then he should have the Investor module search
	 * page.
	 */

	@Test
	public void testInvestorLoading() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getInfo());
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid Investor number and selects the Investor name from search
	 * result, he should be able to view the Investor details and he should be
	 * able to see details under info section.
	 */
	@Test
	public void investorModuleNavigateInfoSection() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getInfo());
		assertNotNull(investorDetails.getInfo().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Info section availability and user should be able to see
	 * details under Info section of investor Module
	 */

	@Test
	public void investorModuleValidateInfoSectionStatus() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getInfo());
		assertNotNull(investorDetails.getInfo().getContent().getWebElement());
		WebElement infoStatus = investorDetails.getInfo().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-1']/div/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(infoStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Comment section under Investor Module
	 */
	@Test
	public void investorModuleNavigateCommentsSection() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getComments());
		assertNotNull(investorDetails.getComments().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Comments section availability and user should be able to
	 * see details under Comments section of Investor Module
	 */
	@Test
	public void investorModuleValidateCommentsSectionStatus() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getComments());
		assertNotNull(investorDetails.getComments().getContent().getWebElement());
		WebElement commentStatus = investorDetails.getComments().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-2']/div/div[1]/p"));
		assertNotNull(commentStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Quote section under Investor Module
	 */

	@Test
	public void investoreModuleNavigateQuoteSection() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getQuote());
		assertNotNull(investorDetails.getQuote().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Quote section availability and user should be able to
	 * see details under Quote section of Investor Module
	 */

	@Test
	public void investorModuleValidateQuoteSectionStatus() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getQuote());
		assertNotNull(investorDetails.getQuote().getContent().getWebElement());
		WebElement quoteStatus = investorDetails.getQuote().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-3']/div[2]/div[2]/div[1]/div[1]/h5"));
		assertNotNull(quoteStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Contract section under Investor Module
	 */

	@Test
	public void investorModuleNavigateContractsSection() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "13129";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getContracts());
		assertNotNull(investorDetails.getContracts().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Contracts section availability and user should be able
	 * to see details under Contracts section of Investor Module
	 */

	@Test
	public void investorModuleValidateContractsSectionStatus() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getContracts());
		assertNotNull(investorDetails.getContracts().getContent().getWebElement());
		WebElement contractsStatus = investorDetails.getContracts().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-4']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(contractsStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the lessee section under Investor Module
	 */

	@Test
	public void investorModuleNavigateLesseeSection() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getLessee());
		assertNotNull(investorDetails.getLessee().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Vendor-Broker section availability and user should be
	 * able to see details under lessee section of Investor Module
	 */

	@Test
	public void investorModuleValidateLesseeSectionStatus() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getLessee());
		assertNotNull(investorDetails.getLessee().getContent().getWebElement());
		WebElement vlesseeStatus = investorDetails.getLessee().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-3']/div[2]/div[2]/div/div[1]/ul/li[1]/p"));
		assertNotNull(vlesseeStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the vendor section under Investor Module
	 */

	@Test
	public void investorModuleNavigateVendorSection() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getVendor());
		assertNotNull(investorDetails.getVendor().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Vendor section availability and user should be able to
	 * see details under Vendor section of Investor Module
	 */

	@Test
	public void investorModuleValidateVendorSectionStatus() {

		String investorNbr = StringUtils.isNotBlank(contract.getInvestorNbr()) ? contract.getInvestorNbr()
				: "1209";
		List<WebElement> searchResult = processor.search(investorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		InvestorDetail investorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(investorDetails);
		assertNotNull(investorDetails);
		processor.loadSection(investorDetails.getVendor());
		assertNotNull(investorDetails.getVendor().getContent().getWebElement());
		WebElement vendorStatus = investorDetails.getVendor().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-7']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(vendorStatus);
	}

	@BeforeMethod
	public void beforeMethod() {
		processor.navigate();
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
		processor = new InvestorModuleProcessor(driver);
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}
