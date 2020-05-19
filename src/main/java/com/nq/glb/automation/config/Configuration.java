package com.nq.glb.automation.config;

import java.util.List;

public class Configuration {

	String name;
	List<String> modules;
	List<User> credentials;

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
		return "Configuration [name=" + name + ", modules=" + modules + ", credentials=" + credentials + "]";
	}

}
