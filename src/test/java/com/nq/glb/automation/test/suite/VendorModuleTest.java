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

import com.nq.glb.automation.model.web.VendorDetail;
import com.nq.glb.automation.module.VendorModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * VENDOR module regression functionality.
 * 
 * @author jswati
 *
 */
public class VendorModuleTest extends BaseTestSuite {

	private VendorModuleProcessor processor;

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to enter the correct Contract id and click on search button under
	 * vendor module
	 */

	@Test
	public void vendorModule_validateSearch() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);

	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid vendor number and selects the vendor name from search result,
	 * he should be able to view the vendor details and he should be able to see
	 * details under vendor info section.
	 */
	@Test
	public void vendorModuleInfoSection__whenValidVendorNumber() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getVendorInfo());
		assertNotNull(vendorDetails.getVendorInfo().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Vendor info Section availability and he should be able
	 * to see details under vendor module.
	 */

	@Test
	public void vendoreModuleValidateInfoSectionStatus() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getVendorInfo());
		assertNotNull(vendorDetails.getVendorInfo().getContent().getWebElement());
		WebElement vinfoStatus = vendorDetails.getVendorInfo().getContent().getWebElement().findElement(
				By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/th"));
		assertNotNull(vinfoStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the comment section under Vendor Module
	 */
	@Test
	public void vendorModuleNavigateCommentsSection() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getComments());
		assertNotNull(vendorDetails.getComments().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Comment section availability and user should be able to
	 * see details under comment section of vendor Module
	 */

	@Test
	public void vendorModuleValidateCommentsSectionStatus() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getComments());
		assertNotNull(vendorDetails.getComments().getContent().getWebElement());
		WebElement vcommentStatus = vendorDetails.getComments().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-2']/div[2]/div[1]/p"));
		assertNotNull(vcommentStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Quote section under Vendor Module
	 */

	@Test
	public void vendorModuleNavigateQuoteSection() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getQuote());
		assertNotNull(vendorDetails.getQuote().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Quote section availability and user should be able to
	 * see details under Quote section of vendor Module
	 */

	@Test
	public void vendorModuleValidateQuoteSectionStatus() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getQuote());
		assertNotNull(vendorDetails.getQuote().getContent().getWebElement());
		WebElement vquoteStatus = vendorDetails.getQuote().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-3']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(vquoteStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Contract section under Vendor Module
	 */

	@Test
	public void vendorModuleNavigateContractsSection() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getContracts());
		assertNotNull(vendorDetails.getContracts().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Contracts section availability and user should be able
	 * to see details under Contracts section of vendor Module
	 */

	@Test
	public void vendorModuleValidateContractsSectionStatus() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getContracts());
		assertNotNull(vendorDetails.getContracts().getContent().getWebElement());
		WebElement vcontractsStatus = vendorDetails.getContracts().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-4']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(vcontractsStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Lessee section under Vendor Module
	 */

	@Test
	public void vendorModuleNavigateLesseeSection() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getLessee());
		assertNotNull(vendorDetails.getLessee().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Lessee section availability and user should be able to
	 * see details under Lessee section of vendor Module
	 */

	@Test
	public void vendorModuleValidatelesseeSectionStatus() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getLessee());
		assertNotNull(vendorDetails.getLessee().getContent().getWebElement());
		WebElement lesseeStatus = vendorDetails.getLessee().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-5']/div[2]/div[2]/div/div[1]/ul/li[1]/p"));
		assertNotNull(lesseeStatus);
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to navigate the Investor section under Vendor Module
	 */

	@Test
	public void vendorModuleNavigateInvestorSection() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getInvestor());
		assertNotNull(vendorDetails.getInvestor().getContent().getWebElement());
	}

	/**
	 * This test case is written to validate if the logged in user should be
	 * able to view the Investor section availability and user should be able to
	 * see details under Investor section of vendor Module
	 */

	@Test
	public void vendorModuleValidateInvestorSectionStatus() {

		String vendorNbr = StringUtils.isNotBlank(contract.getVendorId()) ? contract.getVendorId() : "24864";
		List<WebElement> searchResult = processor.search(vendorNbr);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
		VendorDetail vendorDetails = processor.process(contract, searchResult.get(0));
		System.out.println(vendorDetails);
		assertNotNull(vendorDetails);
		processor.loadSection(vendorDetails.getInvestor());
		assertNotNull(vendorDetails.getInvestor().getContent().getWebElement());
		WebElement vinvesterStatus = vendorDetails.getInvestor().getContent().getWebElement()
				.findElement(By.xpath("//*[@id='tab-6']/div[2]/div[2]/div[1]/div[1]/ul/li[1]/p"));
		assertNotNull(vinvesterStatus);
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
		processor = new VendorModuleProcessor(driver);
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}
