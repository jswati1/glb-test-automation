package com.nq.glb.automation.config;

import com.nq.glb.automation.model.DriverType;

/**
 * @author jswati
 *
 */
public class BrowserDriverConfig {

	private String driverPath;
	private String binaryPath;
	private DriverType driverType;
	private boolean headless;
	private boolean verbose;

	public String getDriverPath() {
		return driverPath;
	}

	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	public String getBinaryPath() {
		return binaryPath;
	}

	public void setBinaryPath(String binaryPath) {
		this.binaryPath = binaryPath;
	}

	public DriverType getDriverType() {
		return driverType;
	}

	public void setDriverType(DriverType driverType) {
		this.driverType = driverType;
	}

	public boolean isHeadless() {
		return headless;
	}

	public void setHeadless(boolean headless) {
		this.headless = headless;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	@Override
	public String toString() {
		return "BrowserDriverConfig [driverPath=" + driverPath + ", binaryPath=" + binaryPath + ", driverType="
				+ driverType + ", headless=" + headless + ", verbose=" + verbose + "]";
	}

}
