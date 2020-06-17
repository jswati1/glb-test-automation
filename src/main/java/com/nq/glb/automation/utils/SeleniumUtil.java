package com.nq.glb.automation.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nq.glb.automation.model.DriverType;
import com.nq.glb.automation.model.web.SiteElement;

public class SeleniumUtil {

	private static final Logger logger = LoggerFactory.getLogger(SeleniumUtil.class);
	// private static final String CHROME_PROFILE_DIR = "C:/chrome/test";

	public static WebDriver getDriver(DriverType driverType) {
		logger.debug("Initialize the web driver for driver type {}", driverType);
		WebDriver driver = null;
		try {
			switch (driverType) {
			case CHROME:

				System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
				final ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("enable-automation");
			//	 chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--dns-prefetch-disable");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				chromeOptions.setCapability("chrome.verbose", true);
				// disable logging
				// disable the web security
				chromeOptions.addArguments("--disable-web-security");
				chromeOptions.addArguments("--allow-running-insecure-content");
				// options.addArguments("user-data-dir=" +
				// CHROME_PROFILE_DIR);
				// chromeOptions.setBinary("C:\\Program Files
				// (x86)\\Google\\Chrome\\Application\\chrome.exe");
				driver = new ChromeDriver(chromeOptions);
				break;

			case IE:

				if (driver == null) {

					System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}

				break;

			case FIREFOX:

				if (driver == null) {

					// System.setProperty("webdriver.gecko.driver","C:\\temp\\geckodriver.exe");

					System.setProperty("webdriver.gecko.driver",
							"C:\\tools\\geckodriver-v0.24.0-win64\\geckodriver.exe");

					File pathBinary = new File("C:\\Program Files(x86)\\Mozilla Firefox\\firefox.exe");
					if (!pathBinary.exists()) {
						pathBinary = new File("C:\\Program Files\\MozillaFirefox\\firefox.exe");
					}
					// FirefoxBinary firefoxBinary = new
					// FirefoxBinary(pathBinary);

					// final FirefoxProfile firefoxProfile = new
					// FirefoxProfile();
					final GeckoDriverService gecoService = new GeckoDriverService.Builder().build();
					final FirefoxOptions options = new FirefoxOptions();
					options.setHeadless(true);
					options.setLogLevel(FirefoxDriverLogLevel.ERROR);
					options.setCapability("marionette", true);
					driver = new FirefoxDriver(gecoService, options);

				}
				break;

			default:

				if (driver == null) {
					// System.setProperty("webdriver.firefox.bin","C:\\Program
					// Files (x86)\\Mozilla Firefox\\firefox.exe");
					System.setProperty("webdriver.gecko.driver",
							"C:\\tools\\geckodriver-v0.24.0-win64\\geckodriver.exe");
					final FirefoxOptions options = new FirefoxOptions();
					// options.setHeadless(true);
					options.setLogLevel(FirefoxDriverLogLevel.FATAL);
					options.setCapability("marionette", false);
					// driver = new FirefoxDriver(options);
					driver = new FirefoxDriver();

				}
				break;
			}

		} catch (final UnreachableBrowserException ex) {
			logger.error("UnreachableBrowserException :{}", ex);
		} catch (final Exception ex) {
			logger.error("Exception while initializing :{}", ex);
		}

		logger.debug("driver is initialized {}", (driver != null));
		System.out.println(driver);
		driver.manage().window().maximize();
		return driver;

	}

	public static int getWindowHandles(WebDriver driver) {
		return driver.getWindowHandles().size();
	}

	public static String getParentWindowHandler(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public static Set<String> getSecondWidnowHandler(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public static void switchToWindow(WebDriver driver, String handler) {
		driver.switchTo().window(handler);
	}

	public static String getNewTab(WebDriver driver) {
		return driver.getWindowHandles().stream().skip(1).findFirst().orElse(null);
	}

	public static void switchToNewTab(WebDriver driver) {
		driver.switchTo().window(getNewTab(driver));
	}

	public static void switchToParentWindow(WebDriver driver) {
		driver.switchTo().window(driver.getWindowHandles().stream().findFirst().orElse(null));
	}

	/**
	 * Method to switch the windows if multiple windows are oended and we need
	 * to switch to specific window url.
	 * 
	 * @param url
	 * @param driver
	 * @return
	 */
	public static boolean switchToWindow(String url, WebDriver driver) {

		final String currentTab = driver.getWindowHandle();
		final List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for (final String tab : tabs) {
			if (currentTab.equalsIgnoreCase(url)) {
				return true;
			} else {
				driver.switchTo().window(tab);
			}
		}
		return false;
	}

	public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
		for (int i = 0; i < 2; i++) {

			final JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: Red; border: 10px solid Red;");
			// Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			// Thread.sleep(1000);
		}

	}

	public static WebElement IsElementFound(WebDriver d, By elementValue) {
		try {
			final WebElement myDynamicElement = new WebDriverWait(d, 10)
					.until(ExpectedConditions.presenceOfElementLocated(elementValue));
			// elementFound = checkWebElementExistsOrNot(d,elementValue);
			return myDynamicElement;
		} catch (final TimeoutException e) {
			System.out.println("Timeout exception:" + e);
		}

		return null;
	}

	public static WebElement isElementPresent(WebDriver d, WebElement parent, By child) {
		try {
			final WebElement childElement = parent.findElement(child);
			return childElement;
		} catch (final Exception e) {
			System.out.println("Timeout exception:" + e);
		}

		return null;
	}

	// public static WebElement IsElementFound(WebDriver d,By elementValue, int
	// waitTime)
	// {
	// try{
	// WebElement myDynamicElement = (new WebDriverWait(d,
	// waitTime)).until(ExpectedConditions.presenceOfElementLocated(elementValue));
	// elementFound = checkWebElementExistsOrNot(d,elementValue);
	// return myDynamicElement;
	// }
	// catch(Exception e)
	// {
	// System.out.println(e.getMessage());
	// e.printStackTrace();
	// System.out.println("Could not load the element");
	// closeDriver(d);
	// System.exit(-1);
	// }

	// Driver closing
	public static void closeDriver(WebDriver driver) {
		try {
			driver.close();
			driver.quit();
			TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
		} catch (final Exception e) {
			e.printStackTrace();
			TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
		}
	}

	public static boolean isAttribtuePresent(WebElement element, String attribute, String value) {
		Boolean result = false;
		try {
			final String val = element.getAttribute(attribute);
			if (StringUtils.isNotBlank(val) && value.equalsIgnoreCase(val)) {
				result = true;
			}
		} catch (final Exception e) {
		}

		return result;
	}

	public static boolean isAttribtuePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			final String value = element.getAttribute(attribute);
			if (StringUtils.isNotBlank(value)) {
				result = true;
			}
		} catch (final Exception e) {
		}

		return result;
	}

	public static void loadElement(SiteElement siteElement, WebDriver driver) {
		siteElement.setWebElement(driver.findElement(siteElement.getXpath()));
	}

	public static boolean hasClass(WebElement element, String name) {
		return element.getAttribute("class").contains(name);
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {

		}
	}

}