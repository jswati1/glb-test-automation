package com.nq.glb.automation.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.web.ContractStatusReportsDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.model.web.SiteElement;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * This Processor class is used to navigate and load the Contract Status Report
 * module and provides the methods to access section of Report module.
 * 
 * @author jswati
 *
 */
public class ContractStatusReportModuleProcessor extends ReportModuleProcessor<ContractStatusReportsDetail> {

	public ContractStatusReportModuleProcessor(WebDriver driver) {
		super(driver);
	}

	@Override
	public void navigate() {

		this.driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[6]/a")).click();
	}

	@Override
	public void process() {
		this.driver.findElement(By.xpath("//*[@id='report-group-list']/li[2]/div/div[1]")).click();
		SeleniumUtil.sleep(1);
	}

	@Override
	public void exit() {
		driver.close();
	}

	@Override
	public ContractStatusReportsDetail process(Contract contract, WebElement moduleContainer) {
		return null;
	}
	/*
	 * This method loads the Contract Status Reports module container and
	 * provides the ReportsDetail instance having all the sub section xpath and
	 * section container element.
	 * 
	 * @see
	 * com.nq.glb.automation.module.ModuleProcessor#process(java.lang.String,
	 * org.openqa.selenium.WebElement)
	 */

	@Override
	public ContractStatusReportsDetail process(String id, WebElement moduleContainer) {
		return null;
	}

	@Override
	public ContractStatusReportsDetail loadReport() {
		ContractStatusReportsDetail reportDetails = new ContractStatusReportsDetail();
		reportDetails.setRoot(new SiteElement(By.xpath("//*[@id='reportsTable']")));

		Section section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[1]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		// section.setContent(By.xpath("//*[@id='contractStatusTable']"));
		reportDetails.setRqActiveReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[2]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		// section.setContent(By.xpath("//*[@id='contractStatusTable']"));
		reportDetails.setPendingInProcessReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[3]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		// section.setContent(By.xpath("//*[@id='contractStatusTable']"));
		reportDetails.setDocsCompleteReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[4]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		// section.setContent(By.xpath("//*[@id='contractStatusTable']"));
		reportDetails.setContractActiveReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[5]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		// section.setContent(By.xpath("//*[@id='contractStatusTable']"));
		reportDetails.setEndOfLeaseReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[6]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		// section.setContent(By.xpath("//*[@id='contractStatusTable']"));
		reportDetails.setPostClosingChecklistReport(section);

		section = new Section();
		section.setLink(By.xpath("//*[@id='reportsTable']/tbody/tr[7]/td[4]/div/a[1]"));
		section.setContent(By.xpath("/html/body/div[3]/div"));
		// section.setContent(By.xpath("//*[@id='contractStatusTable']"));
		reportDetails.setSkippedPaymentsReport(section);

		return reportDetails;
	}
}
