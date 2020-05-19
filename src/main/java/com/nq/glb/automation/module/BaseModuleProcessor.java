package com.nq.glb.automation.module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;
import com.nq.glb.automation.model.DriverType;
import com.nq.glb.automation.model.web.RateDetail;
import com.nq.glb.automation.model.web.Section;
import com.nq.glb.automation.utils.SeleniumUtil;

public abstract class BaseModuleProcessor<T> implements ModuleProcessor<T> {

	protected WebDriver driver;

	public BaseModuleProcessor(WebDriver driver) {
		super();
		if (driver == null) {
			driver = SeleniumUtil.getDriver(DriverType.CHROME);
		}
		this.driver = driver;
	}

	/**
	 * @param section
	 */
	public void loadSection(Section section) {
		section.getLink().setWebElement(this.driver.findElement(section.getLink().getXpath()));
		section.getLink().getWebElement().click();
		SeleniumUtil.sleep(1);
		section.getContent().setWebElement(this.driver.findElement(section.getContent().getXpath()));
	}

	/**
	 * @param id
	 * @return
	 */
	public List<WebElement> search(String id) {
		List<WebElement> searchResult = null;

		this.driver.findElement(By.xpath("//*[@id='searchVendor']")).sendKeys(id);
		this.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[1]/button")).click();
		SeleniumUtil.sleep(1);

		WebElement searchResultsContainer = SeleniumUtil.IsElementFound(this.driver,
				By.xpath("//*[@id='result']/div/div[2]/div[2]/div/div/div"));
		if (searchResultsContainer != null) {
			searchResult = searchResultsContainer.findElements(By.xpath("div"));
		}
		return searchResult;
	}

	/**
	 * @param rateDetails
	 * @return
	 */
	public Contract getContract(RateDetail rateDetails) {

		Contract contract = new Contract();
		if (rateDetails != null) {
			contract.setContractId(rateDetails.getContractId());
			WebElement element = null;
			if (rateDetails.getContracts() != null) {
				this.loadSection(rateDetails.getContracts());
				if (rateDetails.getContracts().getContent().getWebElement() != null) {
					element = SeleniumUtil.isElementPresent(this.driver,
							rateDetails.getContracts().getContent().getWebElement(),
							By.xpath("//*[@id='main-tab']/div[2]/div[1]/div[1]/ul/li[1]/span"));
					if (element != null) {
						contract.setContractId(element.getText());

					}
				}
			}

			if (rateDetails.getInvestor() != null) {
				this.loadSection(rateDetails.getInvestor());
				if (rateDetails.getInvestor().getContent().getWebElement() != null) {
					element = SeleniumUtil.isElementPresent(this.driver,
							rateDetails.getInvestor().getContent().getWebElement(),
							By.xpath("//*[@id='main-tab']/div[1]/div[2]/div[1]/ul/li[1]/span"));
					if (element != null) {
						contract.setInvestorNbr(element.getText());

					}
				}
			}

			if (rateDetails.getInvestorBroker() != null) {
				this.loadSection(rateDetails.getInvestorBroker());
				if (rateDetails.getInvestorBroker().getContent().getWebElement() != null) {
					element = SeleniumUtil.isElementPresent(this.driver,
							rateDetails.getInvestorBroker().getContent().getWebElement(),
							By.xpath(""));
					if (element != null) {
						contract.setInvestorBrokerNbr(element.getText());

					}
				}
			}

			if (rateDetails.getLessee() != null) {
				this.loadSection(rateDetails.getLessee());
				if (rateDetails.getLessee().getContent().getWebElement() != null) {
					element = SeleniumUtil.isElementPresent(this.driver,
							rateDetails.getLessee().getContent().getWebElement(),
							By.xpath("//*[@id='main-tab']/div[1]/div[2]/div[1]/ul/li[1]/span"));
					if (element != null) {
						contract.setLesseeNbr(element.getText());

					}
				}
			}
			if (rateDetails.getVendor() != null) {
				this.loadSection(rateDetails.getVendor());
				if (rateDetails.getVendor().getContent().getWebElement() != null) {
					element = SeleniumUtil.isElementPresent(this.driver,
							rateDetails.getVendor().getContent().getWebElement(),
							By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[1]"));
					if (element != null) {
						contract.setVendorId(element.getText());

					}
				}
			}
		}

		return contract;

	}

}
