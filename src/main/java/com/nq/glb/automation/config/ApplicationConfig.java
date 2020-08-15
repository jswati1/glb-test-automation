package com.nq.glb.automation.config;

import org.apache.commons.lang3.StringUtils;

import com.nq.glb.automation.utils.ConfigurationUtils;

/**
 * @author jswati
 *
 */
public class ApplicationConfig {

	private Configuration configuration = new Configuration();

	public ApplicationConfig(String configFile) {
		if (StringUtils.isBlank(configFile)) {
			this.configuration = ConfigurationUtils.loadYml("application.yml");
		} else {
			this.configuration = ConfigurationUtils.loadYml(configFile);
		}
	}

	public Configuration getConfiguration() {
		return configuration;
	}
}
