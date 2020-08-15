package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.RateDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the rate module and
 * provides the methods to access section of rate module.
 * 
 * @author jswati
 *
 */
public class RateModuleProcessor extends BaseModuleProcessor<RateDetail> {

	private SiteDetail siteDetail;

	public SiteDetail getSiteDetail() {
		return siteDetail;
	}

	public void setSiteDetail(SiteDetail siteDetail) {
		this.siteDetail = siteDetail;
	}

	public RateModuleProcessor(WebDriver driver) {
		super(driver);
	}

	@Override
	public void navigate() {
		this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[2]/a")).click();
	}
	

	@Override
	public void process() {
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
	}

	@Override
	public RateDetail process(Contract contract, WebElement moduleContainer) {
		return this.process(contract.getContractId(), moduleContainer);
	}

	/*
	 * This method loads the rate module container and provides the RateDetail
	 * instance having all the sub section xpath and section container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */
	@Override
	public RateDetail process(String id, WebElement moduleContainer) {

		moduleContainer.findElement(By.xpath("div/a")).click();

		SeleniumUtil.sleep(3);
		RateDetail contractDetail = new RateDetail();
		contractDetail.setContractId(id);
		contractDetail.setSummary(new SiteElement(By.xpath("//*[@id='topHeader']/div[2]")));
		Section section = new Section();

		section.setLink(By.linkText("Quote"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setQuote(section);

		section = new Section();
		section.setLink(By.linkText("Contracts"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setContracts(section);

		section = new Section();
		section.setLink(By.linkText("Comments"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setComments(section);

		section = new Section();
		section.setLink(By.linkText("Equipment"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setEquipment(section);

		section = new Section();
		section.setLink(By.linkText("Documents"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setDocuments(section);

		section = new Section();
		section.setLink(By.linkText("Lessee"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setLessee(section);

		section = new Section();
		section.setLink(By.linkText("Vendor"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setVendor(section);

		section = new Section();
		section.setLink(By.linkText("Vendor Broker"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setVendorBroker(section);

		section = new Section();
		section.setLink(By.linkText("Investor"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setInvestor(section);

		section = new Section();
		section.setLink(By.linkText("Investor Broker"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setInvestorBroker(section);

		section = new Section();
		section.setLink(By.linkText("Invoice Schedule"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setInvoiceSchedule(section);

		section = new Section();
		section.setLink(By.linkText("Rec/Dis"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setRecDis(section);

		section = new Section();
		section.setLink(By.linkText("State"));
		section.setContent(By.xpath("//*[@id='main-tab']/div[1]"));
		contractDetail.setState(section);

		return contractDetail;

	}

}
