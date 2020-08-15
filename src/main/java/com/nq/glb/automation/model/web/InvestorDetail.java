package com.nq.glb.automation.model.web;

/**
 * @author jswati
 *
 */
public class InvestorDetail {

	private String investorNbr;
	private SiteElement summary;
	private Section info;
	private Section comments;
	private Section quote;
	private Section contracts;
	private Section lessee;
	private Section vendor;
	
	public String getInvestorNbr() {
		return investorNbr;
	}

	public void setInvestorNbr(String investorNbr) {
		this.investorNbr = investorNbr;
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

	

	@Override
	public String toString() {
		return "InvestorDetail [investorNbr=" + investorNbr + ", summary=" + summary + ", info=" + info + ", comments="
				+ comments + ", quote=" + quote + ", contracts=" + contracts + ", lessee=" + lessee + ", vendor=" + vendor + "]";
	}

}
