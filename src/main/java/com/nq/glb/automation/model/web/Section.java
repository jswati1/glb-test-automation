package com.nq.glb.automation.model.web;

import org.openqa.selenium.By;

public class Section {

	private SiteElement link;
	private SiteElement content;

	public SiteElement getLink() {
		return link;
	}

	public void setLink(SiteElement link) {
		this.link = link;
	}

	public SiteElement getContent() {
		return content;
	}

	public void setContent(SiteElement content) {
		this.content = content;
	}

	public void setLink(By xpath) {

		this.link = new SiteElement(xpath);
	}

	public void setContent(By xpath) {

		this.content = new SiteElement(xpath);

	}
}
