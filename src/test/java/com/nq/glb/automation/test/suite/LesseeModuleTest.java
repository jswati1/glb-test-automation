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

import com.nq.glb.automation.model.web.LesseeDetail;
import com.nq.glb.automation.module.LesseeModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * LESSEE module regression functionality.
 * 
 * @author jswati
 *
 */
public class LesseeModuleTest extends BaseTestSuite {

	private LesseeModuleProcessor processor;

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to enter the correct Contract id and click on searh button under
	 * lessee module
	 */

	// @Test
	public void testLesseeSearch() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
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

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInfo());
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid lessee number and selects the lessee name from search result,
	 * he should be able to view the lessee details and he should be able to see
	 * details under info section.
	 */
	@Test
	public void lesseeModuleNavigateInfoSection() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInfo());
		assertNotNull(lesseeDetails.getInfo().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Info section availability and user should be able to see
	 * details under Info section of Lessee Module
	 */

	@Test
	public void lesseeModuleValidateInfoSectionStatus() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInfo());
		// assertNotNull(lesseeDetails.getInfo().getContent().getWebElement());
		WebElement infoStatus = lesseeDetails.getInfo().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-1']/div[1]"));
		assertNotNull(infoStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Comment section under Lessee Module
	 */
	@Test
	public void lesseeModuleNavigateCommentsSection() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getComments());
		assertNotNull(lesseeDetails.getComments().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Comments section availability and user should be able to
	 * see details under Comments section of Lessee Module
	 */
	@Test
	public void lesseeModuleValidateCommentsSectionStatus() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getComments());
		assertNotNull(lesseeDetails.getComments().getContent().getWebElement());
		WebElement commentStatus = lesseeDetails.getComments().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-2']/div/div[1]/p"));
		assertNotNull(commentStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Quote section under Lessee Module
	 */

	@Test
	public void lesseeModuleNavigateQuoteSection() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getQuote());
		assertNotNull(lesseeDetails.getQuote().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Quote section availability and user should be able to
	 * see details under Quote section of Lessee Module
	 */

	@Test
	public void lesseeModuleValidateQuoteSectionStatus() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getQuote());
		assertNotNull(lesseeDetails.getQuote().getContent().getWebElement());
		WebElement quoteStatus = lesseeDetails.getQuote().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-3']/div[2]/div[2]/div[1]/div[1]/h5"));
		assertNotNull(quoteStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Contract section under Lessee Module
	 */

	@Test
	public void lesseeModuleNavigateContractsSection() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getContracts());
		assertNotNull(lesseeDetails.getContracts().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Contracts section availability and user should be able
	 * to see details under Contracts section of Lessee Module
	 */

	@Test
	public void lesseeModuleValidateContractsSectionStatus() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getContracts());
		assertNotNull(lesseeDetails.getContracts().getContent().getWebElement());
		WebElement contractsStatus = lesseeDetails.getContracts().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-4']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(contractsStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the vendor section under Lessee Module
	 */

	@Test
	public void lesseeModuleNavigateVendorSection() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getVendor());
		assertNotNull(lesseeDetails.getVendor().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Vendor section availability and user should be able to
	 * see details under Vendor section of Lessee Module
	 */

	@Test
	public void lesseeModuleValidateVendorSectionStatus() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getVendor());
		assertNotNull(lesseeDetails.getVendor().getContent().getWebElement());
		WebElement vendorStatus = lesseeDetails.getVendor().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-7']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(vendorStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the vendor broker section under Lessee Module
	 */

	@Test
	public void lesseeModuleNavigateVendorBrokerSection() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getVendorBroker());
		assertNotNull(lesseeDetails.getVendorBroker().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Vendor-Broker section availability and user should be
	 * able to see details under Vendor-Broker section of Lessee Module
	 */

	@Test
	public void lesseeModuleValidateVendorBrokerSectionStatus() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getVendorBroker());
		assertNotNull(lesseeDetails.getVendorBroker().getContent().getWebElement());
		WebElement vbrokerStatus = lesseeDetails.getVendorBroker().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-7']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(vbrokerStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to click the Investor section under Lessee Module
	 */

	@Test
	public void lesseeModuleNavigateInvestorSection() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInvestor());
		assertNotNull(lesseeDetails.getInvestor().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Investor section availability and user should be able to
	 * see details under Investor section of Lessee Module
	 */

	@Test
	public void lesseeModuleValidateInvestorSectionStatus() {

		String lesseeNbr = StringUtils.isNotBlank(contract.getLesseeNbr()) ? contract.getLesseeNbr() : "13129";
		List<WebElement> searchResult = processor.search(lesseeNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		LesseeDetail lesseeDetails = processor.process(contract, searchResult.get(0));
		System.out.println(lesseeDetails);
		assertNotNull(lesseeDetails);
		processor.loadSection(lesseeDetails.getInvestor());
		assertNotNull(lesseeDetails.getInvestor().getContent().getWebElement());
		WebElement investerStatus = lesseeDetails.getInvestor().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-6']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(investerStatus);
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
		processor = new LesseeModuleProcessor(driver);
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}

}
