package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.web.DocsetDetail;
import com.nq.glb.automation.module.DocsetModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * Docset module regression functionality(Utilities).
 * 
 * @author jswati
 *
 */
public class DocsetModuleTest extends BaseTestSuite {

	private DocsetModuleProcessor docsetprocessor;
	private DocsetDetail docsetDetail;

	/**
	 * Test case to validate if the docset lodaing page gets successfully
	 * loaded when user navigates to UTILITIES > Docset.
	 */
	@Test
	public void docset_loading_success() {
		SeleniumUtil.loadElement(docsetDetail.getRoot(),driver);
		assertNotNull(docsetDetail.getRoot().getWebElement());

	}

	/**
	 * Test case to validate if 'All' docs  gets successfully
	 * loaded when user navigates to UTILITIES > Docset > ALL.
	 */
	@Test
	public void allUtilities_loading_success() {

	SeleniumUtil.loadElement(docsetDetail.getRoot(), driver);
	assertNotNull(docsetDetail.getRoot().getWebElement());
	docsetprocessor.loadSection(docsetDetail.getAll());
	assertNotNull(docsetDetail.getAll().getContent());
	}
	/**
	 * Test case to validate if 'federal' docs gets successfully loaded
	 * when user navigates to UTILITIES > Docset > Federal.
	 */
	@Test
	public void federalUtilities_loading_success() {
		docsetDetail.getRoot().setWebElement(driver.findElement(docsetDetail.getRoot().getXpath()));
		WebElement utilitiesContainer = docsetDetail.getRoot().getWebElement();
		assertNotNull(utilitiesContainer);
		docsetprocessor.loadSection(docsetDetail.getFederal());
		assertNotNull(docsetDetail.getFederal().getContent());

	}
	/**
	 * Test case to validate if 'Municipal' gets successfully loaded
	 * when user navigates to UTILITIES > Docset > Municipal.
	 */
	@Test
	public void municipalUtilities_loading_success() {
		docsetDetail.getRoot().setWebElement(driver.findElement(docsetDetail.getRoot().getXpath()));
		WebElement utilitiesContainer = docsetDetail.getRoot().getWebElement();
		assertNotNull(utilitiesContainer);
		docsetprocessor.loadSection(docsetDetail.getMunicipal());
		assertNotNull(docsetDetail.getMunicipal().getContent());
	}
	
	/**
	 * Test case to validate if 'tribal' gets successfully loaded
	 * when user navigates to UTILITIES > Docset > Tribal.
	 */
	@Test
	public void tribalUtilities_loading_success() {
		docsetDetail.getRoot().setWebElement(driver.findElement(docsetDetail.getRoot().getXpath()));
		WebElement utilitiesContainer = docsetDetail.getRoot().getWebElement();
		assertNotNull(utilitiesContainer);
		docsetprocessor.loadSection(docsetDetail.getTribal());
		assertNotNull(docsetDetail.getTribal().getContent());	
	}

	/**
	 * Test case to validate if 'commercial' gets successfully loaded
	 * when user navigates to UTILITIES > Docset > Commercial.
	 */
	@Test
	public void MunicipalUtilities_loading_success() {
		docsetDetail.getRoot().setWebElement(driver.findElement(docsetDetail.getRoot().getXpath()));
		WebElement utilitiesContainer = docsetDetail.getRoot().getWebElement();
		assertNotNull(utilitiesContainer);
		docsetprocessor.loadSection(docsetDetail.getCommercial());
		assertNotNull(docsetDetail.getCommercial().getContent());
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		docsetprocessor.navigate();
		if (contract == null) {
			loadTestData();
		}
	docsetprocessor.process();
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
		docsetprocessor = new DocsetModuleProcessor(driver);
	docsetDetail = docsetprocessor.loadUtilities();
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}