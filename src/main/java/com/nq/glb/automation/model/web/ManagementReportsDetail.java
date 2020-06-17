package com.nq.glb.automation.model.web;

public class ManagementReportsDetail extends ReportsDetail {

	private Section dealFundedReport;
	private Section contractStatusChangeReport;
	private Section vendorsPayableReport;
	private Section documentsStatusSummaryReport;
	private Section fundingDueReport;
	private Section monthlyRentalReport;
	private Section grossMarginReport;

	public Section getDealFundedReport() {
		return dealFundedReport;
	}

	public void setDealFundedReport(Section dealFundedReport) {
		this.dealFundedReport = dealFundedReport;
	}

	public Section getContractStatusChangeReport() {
		return contractStatusChangeReport;
	}

	public void setContractStatusChangeReport(Section contractStatusChangeReport) {
		this.contractStatusChangeReport = contractStatusChangeReport;
	}

	public Section getVendorsPayableReport() {
		return vendorsPayableReport;
	}

	public void setVendorsPayableReport(Section vendorsPayableReport) {
		this.vendorsPayableReport = vendorsPayableReport;
	}

	public Section getDocumentsStatusSummaryReport() {
		return documentsStatusSummaryReport;
	}

	public void setDocumentsStatusSummaryReport(Section documentsStatusSummaryReport) {
		this.documentsStatusSummaryReport = documentsStatusSummaryReport;
	}

	public Section getFundingDueReport() {
		return fundingDueReport;
	}

	public void setFundingDueReport(Section fundingDueReport) {
		this.fundingDueReport = fundingDueReport;
	}

	public Section getMonthlyRentalReport() {
		return monthlyRentalReport;
	}

	public void setMonthlyRentalReport(Section monthlyRentalReport) {
		this.monthlyRentalReport = monthlyRentalReport;
	}

	public Section getGrossMarginReport() {
		return grossMarginReport;
	}

	public void setGrossMarginReport(Section grossMarginReport) {
		this.grossMarginReport = grossMarginReport;
	}

	@Override
	public String toString() {
		return "ManagementReports [dealFundedReport=" + dealFundedReport + ", contractStatusChangeReport="
				+ contractStatusChangeReport + ", vendorsPayableReport=" + vendorsPayableReport
				+ ", documentsStatusSummaryReport=" + documentsStatusSummaryReport + ", fundingDueReport="
				+ fundingDueReport + ", monthlyRentalReport=" + monthlyRentalReport + ", grossMarginReport="
				+ grossMarginReport + "]";
	}

}