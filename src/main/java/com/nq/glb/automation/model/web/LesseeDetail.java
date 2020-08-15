package com.nq.glb.automation.model.web;

/**
 * @author jswati
 *
 */
public class LesseeDetail {

	private String lesseeNbr;
	private SiteElement summary;
	private Section info;
	private Section comments;
	private Section quote;
	private Section contracts;
	private Section vendor;
	private Section vendorBroker;
	private Section investor;

	public String getLesseeNbr() {
		return lesseeNbr;
	}

	public void setLesseeNbr(String lesseeNbr) {
		this.lesseeNbr = lesseeNbr;
	}

	public SiteElement getSummary() {
		return summary;
	}

	public void setSummary(SiteElement summary) {
		this.summary = summary;
	}

	public Section getInfo() {
		return info;
	}

	public void setInfo(Section info) {
		this.info = info;
	}

	public Section getComments() {
		return comments;
	}

	public void setComments(Section comments) {
		this.comments = comments;
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

	@Override
	public String toString() {
		return "LesseeDetail [lesseeNbr=" + lesseeNbr + ", summary=" + summary + ", info=" + info + ", comments="
				+ comments + ", quote=" + quote + ", contracts=" + contracts + ", vendor=" + vendor + ", vendorBroker="
				+ vendorBroker + ", investor=" + investor + "]";
	}

}
