package com.nq.glb.automation.model.web;

/**
 * @author jswati
 *
 */
public class StateDetail {

	private String stateId;
	private SiteElement summary;
		
	
	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public SiteElement getSummary() {
		return summary;
	}
	public void setSummary(SiteElement summary) {
		this.summary = summary;
	}
	
	@Override
	public String toString() {
		return "StateDetail [stateId=" + stateId + ", summary=" + summary + "]";
	}



}