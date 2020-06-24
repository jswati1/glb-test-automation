package com.nq.glb.automation.model;

public class SiteDetail {

	private String url;
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SiteDetail [url=" + url + ", user=" + user + "]";
	}

}
