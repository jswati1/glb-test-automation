package com.nq.glb.automation.module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.SiteDetail;
import com.nq.glb.automation.model.web.DocsetDetail;
import com.nq.glb.automation.model.web.InvoicesDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.model.web.StateDetail;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the Docset module and
 * provides the methods to access section of UTILITY module.
 * 
 * @author jswati
 *
 */

public class DocsetModuleProcessor extends UtilitiesModuleProcessor<DocsetDetail> {

	private static final Logger logger = LoggerFactory.getLogger(InvoicesModuleProcessor.class);

	public DocsetModuleProcessor(WebDriver driver) {
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
		
		final WebElement utilities = SeleniumUtil.IsElementFound(driver,(By.xpath("/html/body/header/div[2]/nav/ul/li[8]/a")));
	//	this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[8]/div/div[2]/a[3]")).click();
		 Actions action = new Actions(this.driver);
		action.moveToElement(utilities).click().perform();
	}

	@Override
	public void process() {
		final WebElement docset = SeleniumUtil.IsElementFound(driver,By.linkText("Docset"));
		Actions action = new Actions(this.driver);
		action.moveToElement(docset).click().perform();
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
		driver.close();
	}
	
	@Override
	public DocsetDetail process(Contract contract, WebElement moduleContainer) {
		return null;
	}

	/*
	 * This method loads the DOCSET module(UTILITIES) container and provides the
	 * DocsetDetail instance having all the sub section xpath and section
	 * container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */
	/* (non-Javadoc)
	 * @see com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String, org.openqa.selenium.WebElement)
	 */
	@Override
	public DocsetDetail process(String id, WebElement moduleContainer) {
return null;
	}
	
	@Override
	public DocsetDetail loadUtilities() {
	
		//moduleContainer.findElement(By.xpath("div/a")).click();

		//SeleniumUtil.sleep(3);
		DocsetDetail docsetDetail = new DocsetDetail();
		docsetDetail.setRoot(new SiteElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/ul")));	
				
		Section section = new Section();
		section.setLink(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/ul/li[1]/a"));
		section.setContent(By.xpath("/html/body/div[3]/div/div[2]/div[1]"));
		docsetDetail.setAll(section);

		section = new Section();
		section.setLink(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a"));
		section.setContent(By.xpath("/html/body/div[3]/div/div[2]/div[1]"));
		docsetDetail.setFederal(section);
		
		section = new Section();
		section.setLink(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/ul/li[3]/a"));
		section.setContent(By.xpath("/html/body/div[3]/div/div[2]/div[1]"));
		docsetDetail.setMunicipal(section);
			
		section = new Section();
		section.setLink(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/ul/li[4]/a"));
		section.setContent(By.xpath("/html/body/div[3]/div/div[2]/div[1]"));
		docsetDetail.setTribal(section);
		
		section = new Section();
		section.setLink(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/ul/li[5]/a"));
		section.setContent(By.xpath("/html/body/div[3]/div/div[2]/div[1]"));
		docsetDetail.setCommercial(section);
		
		return docsetDetail;

	}

}
