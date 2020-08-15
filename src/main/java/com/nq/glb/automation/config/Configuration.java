package com.nq.glb.automation.config;

import java.util.ArrayList;
import java.util.List;

import com.nq.glb.automation.model.User;

/**
 * @author jswati
 *
 */
public class Configuration {

	String name;
	List<String> modules;
	List<User> credentials;
	String siteUrl;

	public List<User> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<User> credentials) {
		this.credentials = credentials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "Configuration [name=" + name + ", modules=" + modules + ", credentials=" + credentials + ", siteUrl="
				+ siteUrl + "]";
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public void addCredential(User user) {
		if (this.credentials == null) {
			this.credentials = new ArrayList<>();
		}
		this.credentials.add(user);
	}

}
