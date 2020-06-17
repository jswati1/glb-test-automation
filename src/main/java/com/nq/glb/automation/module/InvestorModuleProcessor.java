package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.InvestorDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the Investor module and
 * provides the methods to access section of Investor module.
 * 
 * @author jswati
 *
 */
public class InvestorModuleProcessor extends BaseModuleProcessor<InvestorDetail> {

	public InvestorModuleProcessor(WebDriver driver) {
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
		// System.out.println("navigate to Investor module");
		// this.driver.findElement(By.linkText("INVESTOR")).click();
		this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[5]/a")).click();
	}

	@Override
	public void process() {
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
		driver.close();
	}

	@Override
	public InvestorDetail process(Contract contract, WebElement moduleContainer) {
		return this.process(contract.getInvestorNbr(), moduleContainer);
	}
	/*
	 * This method loads the Investor module container and provides the
	 * InvestorDetail instance having all the sub section xpath and section
	 * container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */

	@Override
	public InvestorDetail process(String id, WebElement moduleContainer) {

		moduleContainer.findElement(By.xpath("div/a")).click();

		SeleniumUtil.sleep(3);
		InvestorDetail investorDetail = new InvestorDetail();
		investorDetail.setInvestorNbr(id);
		investorDetail.setSummary(new SiteElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/header")));
		Section section = new Section();

		
		section.setLink(By.linkText("Info"));
		section.setContent(By.xpath("//*[@id='tab-1']/div/div[2]"));
		investorDetail.setInfo(section);

		section = new Section();
		section.setLink(By.linkText("Comments"));
		section.setContent(By.xpath("//*[@id='tab-2']"));
		investorDetail.setComments(section);

		section = new Section();
		section.setLink(By.linkText("Quote"));
		section.setContent(By.xpath("//*[@id='tab-3']"));
		investorDetail.setQuote(section);

		section = new Section();
		section.setLink(By.linkText("Contracts"));
		section.setContent(By.xpath("//*[@id='tab-4']"));
		investorDetail.setContracts(section);

		section = new Section();
		section.setLink(By.linkText("Lessee"));
		section.setContent(By.xpath("//*[@id='tab-3']"));
		investorDetail.setLessee(section);

		section = new Section();
		section.setLink(By.linkText("Vendor"));
		section.setContent(By.xpath("//*[@id='tab-7']"));
		investorDetail.setVendor(section);


		return investorDetail;

	}

}
