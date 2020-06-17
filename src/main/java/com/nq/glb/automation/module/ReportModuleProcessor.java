package com.nq.glb.automation.module;

import org.openqa.selenium.WebDriver;

import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.utils.SeleniumUtil;

public abstract class ReportModuleProcessor<T> extends BaseModuleProcessor<T> {

	public ReportModuleProcessor(WebDriver driver) {
		super(driver);
	}

	abstract T loadReport();

	/**
	 * This method can be used to load the section of the underline module.
	 * 
	 * @param section
	 */
	public void loadSection(Section section) {
		section.getLink().setWebElement(this.driver.findElement(section.getLink().getXpath()));
		section.getLink().getWebElement().click();
		SeleniumUtil.switchToNewTab(driver);
		SeleniumUtil.sleep(1);
		section.getContent().setWebElement(this.driver.findElement(section.getContent().getXpath()));
	}
}
