
package com.nq.glb.automation.model.web;

public class SalesReportsDetail extends ReportsDetail {

	private Section rateQuoteFollowUpReport;
	private Section contractsPendingDocumentsReport;
	private Section lastNextContactsReport;
	private Section rateQuoteGivenReport;

	public Section getRateQuoteFollowUpReport() {
		return rateQuoteFollowUpReport;
	}

	public void setRateQuoteFollowUpReport(Section rateQuoteFollowUpReport) {
		this.rateQuoteFollowUpReport = rateQuoteFollowUpReport;
	}

	public Section getContractsPendingDocumentsReport() {
		return contractsPendingDocumentsReport;
	}

	public void setContractsPendingDocumentsReport(Section contractsPendingDocumentsReport) {
		this.contractsPendingDocumentsReport = contractsPendingDocumentsReport;
	}

	public Section getLastNextContactsReport() {
		return lastNextContactsReport;
	}

	public void setLastNextContactsReport(Section lastNextContactsReport) {
		this.lastNextContactsReport = lastNextContactsReport;
	}

	public Section getRateQuoteGivenReport() {
		return rateQuoteGivenReport;
	}

	public void setRateQuoteGivenReport(Section rateQuoteGivenReport) {
		this.rateQuoteGivenReport = rateQuoteGivenReport;
	}

	@Override
	public String toString() {
		return "SalesReportsDetail [rateQuoteFollowUpReport=" + rateQuoteFollowUpReport
				+ ", contractsPendingDocumentsReport=" + contractsPendingDocumentsReport + ", lastNextContactsReport="
				+ lastNextContactsReport + ", rateQuoteGivenReport=" + rateQuoteGivenReport + "]";
	}

}
