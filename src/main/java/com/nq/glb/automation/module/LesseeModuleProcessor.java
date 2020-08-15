package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.LesseeDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the Lessee module and
 * provides the methods to access section of Lessee module.
 * 
 * @author jswati
 *
 */
public class LesseeModuleProcessor extends BaseModuleProcessor<LesseeDetail> {

	private static final Logger logger = LoggerFactory.getLogger(LesseeModuleProcessor.class);

	public LesseeModuleProcessor(WebDriver driver) {
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
		this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[3]/a")).click();
	}

	@Override
	public void process() {
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
	}

	@Override
	public LesseeDetail process(Contract contract, WebElement moduleContainer) {
		logger.debug("process operation started.");
		return this.process(contract.getLesseeNbr(), moduleContainer);
	}

	/*
	 * This method loads the Lessee module container and provides the
	 * LesseeDetail instance having all the sub section xpath and section
	 * container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */
	@Override
	public LesseeDetail process(String id, WebElement moduleContainer) {

		moduleContainer.findElement(By.xpath("div/a")).click();

		SeleniumUtil.sleep(3);
		LesseeDetail lesseeDetail = new LesseeDetail();
		lesseeDetail.setLesseeNbr(id);
		lesseeDetail.setSummary(new SiteElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/header")));
		Section section = new Section();

		section.setLink(By.linkText("Info"));
		section.setContent(By.xpath("/html/body/div[3]/div[1]/div[2]/section"));
		lesseeDetail.setInfo(section);

		section = new Section();
		section.setLink(By.linkText("Comments"));
		section.setContent(By.xpath("/html/body/div[3]/div[1]/div[2]/section"));
		lesseeDetail.setComments(section);

		section = new Section();
		section.setLink(By.linkText("Quote"));
		section.setContent(By.xpath("//*[@id='tab-3']"));
		lesseeDetail.setQuote(section);

		section = new Section();
		section.setLink(By.linkText("Contracts"));
		section.setContent(By.xpath("//*[@id='tab-4']"));
		lesseeDetail.setContracts(section);

		section = new Section();
		section.setLink(By.linkText("Investor"));
		section.setContent(By.xpath("//*[@id='tab-6']/div[2]"));
		lesseeDetail.setInvestor(section);

		section = new Section();
		section.setLink(By.linkText("Vendor"));
		section.setContent(By.xpath("//*[@id='tab-7']"));
		lesseeDetail.setVendor(section);

		section = new Section();
		section.setLink(By.linkText("Vendor Broker"));
		section.setContent(By.xpath("//*[@id='tab-7']"));
		lesseeDetail.setVendorBroker(section);

		return lesseeDetail;

	}

}
