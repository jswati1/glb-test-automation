package com.nq.glb.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.nq.glb.automation.config.Configuration;

/**
 * 
 * Utility to load the configurations from the rovided file.
 * 
 * @author jswati
 *
 */
public class ConfigurationUtils {

	public static Configuration loadYml(String configFilePath) {
		Configuration configs = null;
		// Instantiating a new ObjectMapper as a YAMLFactory
		ObjectMapper om = new ObjectMapper(new YAMLFactory());

		File configFile = new File(configFilePath);
		try {
			configs = om.readValue(configFile, Configuration.class);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (configs == null) {
			try {
				// Loading the YAML file from the /resources folder
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				configFile = new File(classLoader.getResource(configFilePath).getFile());
				configs = om.readValue(configFile, Configuration.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return configs;
	}

	/**
	 * Method to load the test configurations.
	 * 
	 * @param configFilePath
	 * @return
	 */
	public static Properties loadProperties(String configFilePath) {

		Properties configs = new Properties();
		try (FileInputStream propConfigs = new FileInputStream(configFilePath)) {
			configs.load(propConfigs);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (configs == null || configs.size() <= 0) {
			try {
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				configs.load(classLoader.getResourceAsStream(configFilePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return configs;
	}
}
