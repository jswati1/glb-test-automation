package com.nq.glb.automation.model.web;

/**
 * @author jswati
 *
 */
public class VendorDetail {

	private String vendorNbr;
	private SiteElement summary;
	private Section vendorinfo;
	private Section comments;
	private Section quote;
	private Section contracts;
	private Section lessee;
	private Section investor;

	public String getVendorNbr() {
		return vendorNbr;
	}

	public void setVendorNbr(String vendorNbr) {
		this.vendorNbr = vendorNbr;
	}
	public SiteElement getSummary() {
		return summary;
	}

	public void setSummary(SiteElement summary) {
		this.summary = summary;
	}
	
	public Section getVendorInfo() {
		return vendorinfo;
	}

	public void setVendorInfo(Section vendorinfo) {
		this.vendorinfo = vendorinfo;
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

	
	public Section getInvestor() {
		return investor;
	}

	public void setInvestor(Section investor) {
		this.investor = investor;
	}

	@Override
	public String toString() {
		return "VendorDetail [vendorNbr=" + vendorNbr + ",summary=" + summary + ", vendorinfo=" + vendorinfo + ", comments="
				+ comments + ", quote=" + quote + ", contracts=" + contracts + ", lessee=" + lessee + ", investor=" + investor + "]";
	}

	public void set(Section section) {
		// TODO Auto-generated method stub
		
	}

}
