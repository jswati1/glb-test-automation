package com.nq.glb.automation.model.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SiteElement {

	private By xpath;
	private WebElement webElement;

	public SiteElement() {
	}

	public SiteElement(By xpath) {
		super();
		this.xpath = xpath;
	}

	public By getXpath() {
		return xpath;
	}

	public void setXpath(By xpath) {
		this.xpath = xpath;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}

}
