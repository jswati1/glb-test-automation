package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * @author jswati
 *
 */
public class LogoutModuleProcessor extends BaseModuleProcessor<SiteDetail> {

	private SiteDetail siteDetail;

	public SiteDetail getSiteDetail() {
		return siteDetail;
	}

	public void setSiteDetail(SiteDetail siteDetail) {
		this.siteDetail = siteDetail;
	}

	public LogoutModuleProcessor(WebDriver driver) {
		super(driver);
	}

	@Override
	public void navigate() {
		System.out.println("navigate to site Logout screen");
		this.driver.findElement(By.xpath("//*[@id='logoutForm']/ul/li/a")).click();
		SeleniumUtil.sleep(1);

	}

	@Override
	public void process() {
		this.navigate();
		System.out.println("initiating the logout process");
		this.driver.findElement(By.xpath("//*[@id='users']/div/div/div[1]/div[1]/ul/li[9]/a")).click();
		this.exit();
	}

	@Override
	public void exit() {
		SeleniumUtil.sleep(1);
		System.out.println("successfully logged out and routed to welcome page.");
	}

	@Override
	public SiteDetail process(Contract contract, WebElement moduleContainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteDetail process(String id, WebElement moduleContainer) {
		// TODO Auto-generated method stub
		return null;
	}

}
