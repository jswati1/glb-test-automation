package com.nq.glb.automation.model;

public class SiteDetail {

	private String url;
	private Credential user;

	public SiteDetail(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Credential getUser() {
		return user;
	}

	public void setUser(Credential user) {
	}

}
