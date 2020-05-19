package com.nq.glb.automation.model.web;

/**
 * @author jswati
 *
 */
public class RateDetail {

	private String contractId;
	private SiteElement summary;
	private Section quote;
	private Section contracts;
	private Section comments;
	private Section equipment;
	private Section documents;
	private Section lessee;
	private Section vendor;
	private Section vendorBroker;
	private Section investor;
	private Section investorBroker;
	private Section invoiceSchedule;

	public Section getInvoiceSchedule() {
		return invoiceSchedule;
	}

	public void setInvoiceSchedule(Section invoiceSchedule) {
		this.invoiceSchedule = invoiceSchedule;
	}

	private Section recDis;
	private Section state;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public SiteElement getSummary() {
		return summary;
	}

	public void setSummary(SiteElement summary) {
		this.summary = summary;
	}

	public Section getQuote() {
		return quote;
	}

	public void setQuote(Section quote) {
		this.quote = quote;
	}

	public Section getContracts() {
		return contracts;
	}

	public void setContracts(Section contracts) {
		this.contracts = contracts;
	}

	public Section getComments() {
		return comments;
	}

	public void setComments(Section comments) {
		this.comments = comments;
	}

	public Section getEquipment() {
		return equipment;
	}

	public void setEquipment(Section equipment) {
		this.equipment = equipment;
	}

	public Section getDocuments() {
		return documents;
	}

	public void setDocuments(Section documents) {
		this.documents = documents;
	}

	public Section getLessee() {
		return lessee;
	}

	public void setLessee(Section lessee) {
		this.lessee = lessee;
	}

	public Section getVendor() {
		return vendor;
	}

	public void setVendor(Section vendor) {
		this.vendor = vendor;
	}

	public Section getVendorBroker() {
		return vendorBroker;
	}

	public void setVendorBroker(Section vendorBroker) {
		this.vendorBroker = vendorBroker;
	}

	public Section getInvestor() {
		return investor;
	}

	public void setInvestor(Section investor) {
		this.investor = investor;
	}

	public Section getInvestorBroker() {
		return investorBroker;
	}

	public void setInvestorBroker(Section investorBroker) {
		this.investorBroker = investorBroker;
	}

	public Section getRecDis() {
		return recDis;
	}

	public void setRecDis(Section recDis) {
		this.recDis = recDis;
	}

	public Section getState() {
		return state;
	}

	public void setState(Section state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ContractDetail [contractId=" + contractId + ", summary=" + summary + ", quote=" + quote + ", contracts="
				+ contracts + ", comments=" + comments + ", equipment=" + equipment + ", documents=" + documents
				+ ", lessee=" + lessee + ", vendor=" + vendor + ", vendorBroker=" + vendorBroker + ", investor="
				+ investor + ", investorBroker=" + investorBroker + ", invoiceSchedule=" + invoiceSchedule + ", recDis="
				+ recDis + ", state=" + state + "]";
	}

}
