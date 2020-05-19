package com.nq.glb.automation.model;

import java.util.List;

public class Contract {

	private String contractId;
	private String lesseeNbr;
	private String vendorId;
	private String investorNbr;
	private String investorBrokerNbr;
	private String state;
	private List<String> invoiceNbrs;
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getLesseeNbr() {
		return lesseeNbr;
	}
	public void setLesseeNbr(String lesseeNbr) {
		this.lesseeNbr = lesseeNbr;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getInvestorNbr() {
		return investorNbr;
	}
	public void setInvestorNbr(String investorNbr) {
		this.investorNbr = investorNbr;
	}
	public String getInvestorBrokerNbr() {
		return investorBrokerNbr;
	}
	public void setInvestorBrokerNbr(String investorBrokerNbr) {
		this.investorBrokerNbr = investorBrokerNbr;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<String> getInvoiceNbrs() {
		return invoiceNbrs;
	}
	public void setInvoiceNbrs(List<String> invoiceNbrs) {
		this.invoiceNbrs = invoiceNbrs;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", lesseeNbr=" + lesseeNbr + ", vendorId=" + vendorId
				+ ", investorNbr=" + investorNbr + ", investorBrokerNbr=" + investorBrokerNbr + ", state=" + state
				+ ", invoiceNbrs=" + invoiceNbrs + "]";
	}

}
