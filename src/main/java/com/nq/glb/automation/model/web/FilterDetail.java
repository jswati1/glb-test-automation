package com.nq.glb.automation.model.web;

/**
 * @author jswati
 *
 */
public class FilterDetail extends UtilitiesDetail {

		private SiteElement summary;
	
	
	public SiteElement getSummary() {
		return summary;
	}

	public void setSummary(SiteElement summary) {
		this.summary = summary;
	}
	

	

	@Override
	public String toString() {
		return "InvoicesDetail [summary=" + summary + "]";
	}

}
