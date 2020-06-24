package com.nq.glb.automation.config;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.DriverType;
import com.nq.glb.automation.model.User;
import com.nq.glb.automation.utils.ConfigurationUtils;
import com.nq.glb.automation.utils.SeleniumUtil;

/**
 * @author jswati
 *
 */
public class AutomationTestConfig {

	private static final Logger logger = LoggerFactory.getLogger(AutomationTestConfig.class);
	private static final String DEFAULT_TEST_CONFIG_PATH = "test-config.properties";
	private static final String DEFAULT_APP_CONFIG_PATH = "application.yml";

	private final Configuration appConfig;

	private static AutomationTestConfig automationContext;

	private final Properties testConfig;

	private WebDriver driver;

	private Contract testData = new Contract();

	private final BrowserDriverConfig browserConfig;

	private AutomationTestConfig(String testExecutionPath) {
		String filePath = "";
		if (StringUtils.isNotBlank(testExecutionPath)) {
			filePath = testExecutionPath + "/";
		}
		// appConfig = new ApplicationConfig(filePath +
		// DEFAULT_APP_CONFIG_PATH).getConfiguration();
		loadTestData();
		testConfig = ConfigurationUtils.loadProperties(filePath + DEFAULT_TEST_CONFIG_PATH);
		browserConfig = new BrowserDriverConfig();
		browserConfig
				.setDriverPath(testConfig.getProperty("browser.config.driver.path", "C:\\tools\\chromedriver.exe"));
		browserConfig.setBinaryPath(testConfig.getProperty("browser.config.binary.path", ""));
		browserConfig.setDriverType(DriverType.valueOf(testConfig.getProperty("browser.config.driver.type", "CHROME")));
		browserConfig
				.setHeadless(Boolean.valueOf(testConfig.getProperty("test.execution.background.enabled", "false")));
		browserConfig.setVerbose(Boolean.valueOf(testConfig.getProperty("browser.config.debug.enabled", "false")));

		appConfig = new Configuration();
		appConfig.setSiteUrl(testConfig.getProperty("site.url", "https://glc-beta.newsquantified.com/"));
		User credential = new User();
		credential.setUsername(testConfig.getProperty("site.credentials.username", "qa@newsquantified.com"));
		credential.setPassword(testConfig.getProperty("site.credentials.password", "jMTJdjNW%Qje!L4t"));
		appConfig.addCredential(credential);
	}

	public static AutomationTestConfig automationContext() {
		if (automationContext == null) {
			automationContext = new AutomationTestConfig(null);
		}
		return automationContext;
	}

	public static AutomationTestConfig automationContext(String testExecutionPath) {
		if (automationContext == null) {
			automationContext = new AutomationTestConfig(testExecutionPath);
		}
		return automationContext;
	}

	private void loadTestData() {
		this.testData.setContractId("22244");
		this.testData.setInvestorBrokerNbr("");
		this.testData.setInvestorNbr("1209");
		// this.testData.setInvoiceNbrs();
		this.testData.setLesseeNbr("13129");
		this.testData.setState("TX");
		this.testData.setVendorId("24864");
	}

	@Override
	public String toString() {
		return "AutomationTestConfig [appConfig=" + appConfig + ", testConfig=" + testConfig + ", testData=" + testData
				+ "]";
	}

	public Configuration getAppConfig() {
		return appConfig;
	}

	public Properties getTestConfig() {
		return testConfig;
	}

	public Contract getTestData() {
		return testData;
	}

	public WebDriver getDriver() {
		if (driver == null) {
			logger.debug("Browser configurations: {}", browserConfig);
			if (browserConfig!=null && browserConfig.getDriverType() != null) {
				driver = SeleniumUtil.getDriver(browserConfig);
			} else {
				driver = SeleniumUtil.getDriver(DriverType.CHROME);

			}
		}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
