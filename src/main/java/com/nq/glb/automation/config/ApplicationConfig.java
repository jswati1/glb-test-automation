package com.nq.glb.automation.config;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ApplicationConfig {

	private Configuration configuration = new Configuration();

	public Configuration config() {

		try {
			// Loading the YAML file from the /resources folder
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			File configFile = new File(classLoader.getResource("application.yml").getFile());
			// Instantiating a new ObjectMapper as a YAMLFactory
			ObjectMapper om = new ObjectMapper(new YAMLFactory());

			try {
				configuration = om.readValue(configFile, Configuration.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Printing out the information
			System.out.println("Application Configurations :" + this.configuration);
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
		return this.configuration;
	}

	public static void main(String[] args) {
		ApplicationConfig config = new ApplicationConfig();
		config.config();
	}
}
