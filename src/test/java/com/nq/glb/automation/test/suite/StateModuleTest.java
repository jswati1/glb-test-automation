package com.nq.glb.automation.test.suite;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nq.glb.automation.model.web.StateDetail;
import com.nq.glb.automation.module.StateModuleProcessor;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This test suite contains all the test cases that are required to validate the
 * State module regression functionality.
 * 
 * @author jswati
 *
 */
public class StateModuleTest extends BaseTestSuite {

	private StateModuleProcessor stateProcessor;

	/**
	 * This test case is written to validate if the logged in user search for
	 * the valid state name and he should get valid search results.
	 */
	@Test
	public void stateContractSearch_whenValidContractId() {
		String stateid = "tx";
		List<WebElement> state = stateProcessor.search(stateid);
		assertNotNull(state);
		assertTrue(state.size() > 0);
		StateDetail stateDetails = stateProcessor.process(stateid, state.get(0));
		assertNotNull(stateDetails);
	}

	/**
	 * This test case is written to validate if the logged in user search for
	 * the invalid state name, he should not receive any search results to
	 * browser.
	 */
	@Test
	public void stateContractSearch_whenInValidContractId() {
		String stateid = "abc";
		List<WebElement> state = stateProcessor.search(stateid);
		assertNull(state);
	}

	/**
	 * This test case is written to validate if -Texashe logged in user search
	 * for the valid state name and select the state from search result, he
	 * should be able to view state detail under state module page
	 */
	@Test
	public void stateDetails_whenValidContractId() {
		String stateid = "tx";
		List<WebElement> state = stateProcessor.search(stateid);
		assertNotNull(state);
		assertTrue(state.size() > 0);
		StateDetail stateDetail = stateProcessor.process(stateid, state.get(0));
		assertNotNull(stateDetail);
		stateDetail.getSummary().setWebElement(driver.findElement(stateDetail.getSummary().getXpath()));
		assertNotNull(stateDetail.getSummary().getWebElement());

	}

	@BeforeMethod
	public void beforeMethod() {
		stateProcessor.navigate();
		if (contract == null) {
			loadTestData();
		}
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

	// @BeforeClass
	@BeforeSuite
	public void beforeClass() {
		this.openSite();
		stateProcessor = new StateModuleProcessor(driver);
	}

	@AfterSuite
	public void afterSuite() {
		this.closeSite();
	}
}