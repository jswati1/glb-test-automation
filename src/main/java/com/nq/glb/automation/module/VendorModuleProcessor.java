package com.nq.glb.automation.module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.VendorDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the Vendor module and
 * provides the methods to access section of Vendor module.
 * 
 * @author jswati
 *
 */
 
public class VendorModuleProcessor extends BaseModuleProcessor<VendorDetail> {

	public VendorModuleProcessor(WebDriver driver) {
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
	public VendorDetail process(Contract contract, WebElement moduleContainer) {
		return this.process(contract.getVendorId(), moduleContainer);
	}

	@Override
	public VendorDetail process(String id, WebElement moduleContainer) {

		moduleContainer.findElement(By.xpath("div/a")).click();

		SeleniumUtil.sleep(3);
		VendorDetail vendorDetail = new VendorDetail();
		vendorDetail.setVendorNbr(id);
		vendorDetail.setSummary(new SiteElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[1]")));

		Section section = new Section();
		section.setLink(By.linkText("Vendor Info"));
		section.setContent(By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[1]"));
		vendorDetail.setVendorInfo(section);

		section = new Section();
		section.setLink(By.linkText("Comments"));
		section.setContent(By.xpath("/html/body/div[3]/div/div[2]/section/div/div/div"));
		vendorDetail.setComments(section);

		section = new Section();
		section.setLink(By.linkText("Quote"));
		section.setContent(By.xpath("//*[@id='tab-3']"));
		vendorDetail.setQuote(section);

		section = new Section();
		section.setLink(By.linkText("Contracts"));
		section.setContent(By.xpath("//*[@id='tab-4']"));
		vendorDetail.setContracts(section);

		section = new Section();
		section.setLink(By.linkText("Lessee"));
		section.setContent(By.xpath("//*[@id='tab-5']"));
		vendorDetail.setLessee(section);
		
		section = new Section();
		section.setLink(By.linkText("Investor"));
		section.setContent(By.xpath("//*[@id='tab-6']"));
		vendorDetail.setInvestor(section);

		

		

		return vendorDetail;

	}

}
