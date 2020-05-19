package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.LesseeDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the lessee module and
 * provides the methods to access section of lessee module.
 * 
 * @author jswati
 *
 */
public class InvestorModuleProcessor extends BaseModuleProcessor<LesseeDetail> {

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
		// System.out.println("navigate to lessee module");
		// this.driver.findElement(By.linkText("LESSEE")).click();
		this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[2]/a")).click();
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
	public LesseeDetail process(Contract contract, WebElement moduleContainer) {
		return this.process(contract.getLesseeNbr(), moduleContainer);
	}

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
		lesseeDetail.setQuote(section);

		section = new Section();
		section.setLink(By.linkText("Comments"));
		section.setContent(By.xpath("/html/body/div[3]/div[1]/div[2]/section"));
		lesseeDetail.setContracts(section);

		section = new Section();
		section.setLink(By.linkText("Quote"));
		section.setContent(By.xpath("//*[@id='tab-3']"));
		lesseeDetail.setComments(section);

		section = new Section();
		section.setLink(By.linkText("Contracts"));
		section.setContent(By.xpath("//*[@id='tab-4']"));
		lesseeDetail.setVendor(section);

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
