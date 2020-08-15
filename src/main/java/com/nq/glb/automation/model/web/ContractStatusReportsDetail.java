package com.nq.glb.automation.model.web;

public class ContractStatusReportsDetail extends ReportsDetail {

	private Section rqActiveReport;
	private Section pendingInProcessReport;
	private Section docsCompleteReport;
	private Section contractActiveReport;
	private Section endOfLeaseReport;
	private Section postClosingChecklistReport;
	private Section skippedPaymentsReport;

	public Section getRqActiveReport() {
		return rqActiveReport;
	}

	public void setRqActiveReport(Section rqActiveReport) {
		this.rqActiveReport = rqActiveReport;
	}

	public Section getPendingInProcessReport() {
		return pendingInProcessReport;
	}

	public void setPendingInProcessReport(Section pendingInProcessReport) {
		this.pendingInProcessReport = pendingInProcessReport;
	}

	public Section getDocsCompleteReport() {
		return docsCompleteReport;
	}

	public void setDocsCompleteReport(Section docsCompleteReport) {
		this.docsCompleteReport = docsCompleteReport;
	}

	public Section getContractActiveReport() {
		return contractActiveReport;
	}

	public void setContractActiveReport(Section contractActiveReport) {
		this.contractActiveReport = contractActiveReport;
	}

	public Section getEndOfLeaseReport() {
		return endOfLeaseReport;
	}

	public void setEndOfLeaseReport(Section endOfLeaseReport) {
		this.endOfLeaseReport = endOfLeaseReport;
	}

	public Section getPostClosingChecklistReport() {
		return postClosingChecklistReport;
	}

	public void setPostClosingChecklistReport(Section postClosingChecklistReport) {
		this.postClosingChecklistReport = postClosingChecklistReport;
	}

	public Section getSkippedPaymentsReport() {
		return skippedPaymentsReport;
	}

	public void setSkippedPaymentsReport(Section skippedPaymentsReport) {
		this.skippedPaymentsReport = skippedPaymentsReport;
	}

	@Override
	public String toString() {
		return "ContractStatusReports [rqActiveReport=" + rqActiveReport + ", pendingInProcessReport="
				+ pendingInProcessReport + ", docsCompleteReport=" + docsCompleteReport + ", contractActiveReport="
				+ contractActiveReport + ", endOfLeaseReport=" + endOfLeaseReport + ", postClosingChecklistReport="
				+ postClosingChecklistReport + ", skippedPaymentsReport=" + skippedPaymentsReport + "]";
	}

}