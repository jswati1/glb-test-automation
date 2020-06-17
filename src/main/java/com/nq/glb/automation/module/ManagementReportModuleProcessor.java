package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.web.ManagementReportsDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the Management Status
 * module and provides the methods to access section of Management Status module(REPORT).
 * 
 * @author jswati
 *
 */
public class ManagementReportModuleProcessor extends ReportModuleProcessor<ManagementReportsDetail> {

	public ManagementReportModuleProcessor(WebDriver driver) {
		super(driver);
	}

	@Override
	public void navigate() {
		this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[6]/a")).click();
	}

	@Override
	public void process() {
		this.driver.findElement(By.xpath("//*[@id='report-group-list']/li[3]/div/div[1]")).click();
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
		driver.close();
	}

	@Override
	public ManagementReportsDetail process(Contract contract, WebElement moduleContainer) {
	//	return this.process(contract.getInvestorNbr(), moduleContainer);
	return null;
	}
	/*
	 * This method loads the Management Report module container and provides the
	 * ReportsDetail instance having all the sub section xpath and section
	 * container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */

	@Override
	public ManagementReportsDetail process(String id, WebElement moduleContainer) {

		return null;

	}

	@Override
	public ManagementReportsDetail loadReport() {

		ManagementReportsDetail reportDetails = new ManagementReportsDetail();
		reportDetails.setRoot(new SiteElement(By.xpath("//*[@id='reportsTable']")));

		Section section = new Section();
		
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[1]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setDealFundedReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[2]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setContractStatusChangeReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[3]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setVendorsPayableReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[4]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setDocumentsStatusSummaryReport(section);

		section = new Section();
		section.setLink(By.xpath("/html/body/div[3]/div[1]/div/div/div/div/div[2]/div/div[2]/div/table/tbody/tr[5]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setFundingDueReport(section);
		
		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[6]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setMonthlyRentalReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[7]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		reportDetails.setGrossMarginReport(section);

		return reportDetails;
	}

}
