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
public class LoginModuleProcessor extends BaseModuleProcessor<SiteDetail> {

	private SiteDetail siteDetail;

	public SiteDetail getSiteDetail() {
		return siteDetail;
	}

	public void setSiteDetail(SiteDetail siteDetail) {
		this.siteDetail = siteDetail;
	}

	public LoginModuleProcessor(WebDriver driver) {
		super(driver);
	}

	@Override
	public void navigate() {
		System.out.println("navigate to site url");
		this.driver.get(siteDetail.getUrl());
		SeleniumUtil.sleep(1);
		this.driver.findElement(By.xpath("//*[@id='loginLink']")).click();
		SeleniumUtil.sleep(1);

	}

	@Override
	public void process() {
		this.navigate();
		System.out.println("initiating the login process: "+siteDetail);
		this.driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(siteDetail.getUser().getUsername());
		this.driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(siteDetail.getUser().getPassword());
		this.driver.findElement(By.xpath("//*[@id='loginForm']/form/div[4]/div/input")).click();
		this.exit();
	}

	@Override
	public void exit() {
		SeleniumUtil.sleep(1);
		System.out.println("successfully logged in and routed to home page.");
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
