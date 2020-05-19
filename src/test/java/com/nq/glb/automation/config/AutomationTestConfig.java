package com.nq.glb.automation.config;

public class AutomationTestConfig {

	private final ApplicationConfig config;

	private AutomationTestConfig() {
		config = new ApplicationConfig();
	}

	public static AutomationTestConfig testConfig() {
		return new AutomationTestConfig();
	}

}
