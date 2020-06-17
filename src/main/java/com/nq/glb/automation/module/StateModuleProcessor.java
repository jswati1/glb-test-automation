package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.model.web.StateDetail;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the STATE module and
 * provides the methods to access section of State  module.
 * 
 * @author jswati
 *
 */
public class StateModuleProcessor extends BaseModuleProcessor<StateDetail> {

	private static final Logger logger = LoggerFactory.getLogger(StateModuleProcessor.class);

	public StateModuleProcessor(WebDriver driver) {
		super(driver);
	}

	private SiteDetail siteDetail;

	public SiteDetail getSiteDetail() {
		return siteDetail;
	}

	public void setSiteDetail(SiteDetail siteDetail) {
		this.siteDetail = siteDetail;
	}

	@Override
	public void navigate() {
		logger.debug("navigation operation started.");
		this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[7]/a")).click();
	}

	@Override
	public void process() {
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
	}

	@Override
	public StateDetail process(Contract contract, WebElement moduleContainer) {
		logger.debug("process operation started.");
		return this.process(contract.getState(), moduleContainer);
	}

	/*
	 * This method loads the State module container and provides the
	 * StateDetail instance having all the sub section xpath and section
	 * container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */
	@Override
	public StateDetail process(String id, WebElement moduleContainer) {

		moduleContainer.findElement(By.xpath("div/a")).click();

		SeleniumUtil.sleep(3);
		StateDetail stateDetail = new StateDetail();
		stateDetail.setStateId(id);
		stateDetail.setSummary(new SiteElement(By.xpath("/html/body/div[3]")));
				
		return stateDetail;

	}

}
