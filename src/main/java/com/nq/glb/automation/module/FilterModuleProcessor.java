package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.web.FilterDetail;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the Filter module and
 * provides the methods to access section of Filter (UTILITY) module.
 * 
 * @author jswati
 *
 */

public class FilterModuleProcessor extends UtilitiesModuleProcessor<FilterDetail> {

	private static final Logger logger = LoggerFactory.getLogger(FilterModuleProcessor.class);

	public FilterModuleProcessor(WebDriver driver) {
		super(driver);
	}

	@Override
	public void navigate() {
		final WebElement utilities = SeleniumUtil.IsElementFound(driver,
				By.xpath("/html/body/header/div[2]/nav/ul/li[8]/a"));
	    Actions action = new Actions(this.driver);
		action.moveToElement(utilities).click().perform();

	}

	@Override
	public void process() {
		
	
		final WebElement invoices = SeleniumUtil.IsElementFound(driver,By.linkText("Filter"));
		Actions action = new Actions(this.driver);
		action.moveToElement(invoices).click().perform();
		
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
		driver.close();
	}

	@Override
	public FilterDetail process(Contract contract, WebElement moduleContainer) {
		return null;
	}

	/*
	 * This method loads the Invoice module container and provides the
	 * filterDetail instance having all the sub section xpath and section
	 * container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */
	@Override
	public FilterDetail process(String id, WebElement moduleContainer) {
		return null;
	}

	@Override
	public FilterDetail loadUtilities() {
		FilterDetail filterDetail = new FilterDetail();

		filterDetail.setHeader(new SiteElement(By.xpath("/html/body/div[3]/div[1]/section/div/header")));
		filterDetail.setContent(new SiteElement(By.xpath("/html/body/div[3]/div[1]/section/div/div[1]")));

		return filterDetail;

	}

}
