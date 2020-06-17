package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.web.SalesReportsDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;


/**
 * This Processor class is used to navigate and load the Sales Report
 * module and provides the methods to access section of Sales Report module(REPORT).
 * 
 * @author jswati
 *
 */
public class SalesReportModuleProcessor extends ReportModuleProcessor<SalesReportsDetail> {

	public SalesReportModuleProcessor(WebDriver driver) {
		super(driver);
	}

	@Override
	public void navigate() {
		this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[6]/a")).click();
	}

	@Override
	public void process() {
		this.driver.findElement(By.xpath("//*[@id='report-group-list']/li[4]/div/div[1]")).click();
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
		driver.close();
	}

	@Override
	public SalesReportsDetail process(Contract contract, WebElement moduleContainer) {
		return this.process(contract.getInvestorNbr(), moduleContainer);
	}
	/*
	 * This method loads the Sales Reports module container and provides the
	 * ReportsDetail instance having all the sub section xpath and section
	 * container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */

	@Override
	public SalesReportsDetail process(String id, WebElement moduleContainer) {

		return null;

	}

	@Override
	public SalesReportsDetail loadReport() {

		SalesReportsDetail reportDetails = new SalesReportsDetail();
		reportDetails.setRoot(new SiteElement(By.xpath("//*[@id='reportsTable']")));

		Section section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[1]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setRateQuoteFollowUpReport(section);
		

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[2]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setContractsPendingDocumentsReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[3]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setLastNextContactsReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[4]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setRateQuoteGivenReport(section);

		return reportDetails;
	}

}