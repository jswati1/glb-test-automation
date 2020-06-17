package com.nq.glb.automation.module;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;

/**
 * Interface to represent the module processor. This mainly provides the default
 * capability of module processor implementor.
 * 
 * @author jswati
 *
 * @param <T>
 */
public interface ModuleProcessor<T> {

	/**
	 * Implement this method to provide the initial web flow to navigate to
	 * underline web module on website.
	 */
	void navigate();

	/**
	 * Implement this method to provide specific web flow that is common and
	 * required to load and make module available. E.g. logic to add time delays
	 * while loading the module.
	 */
	void process();

	/**
	 * Implement this method to provide the logic or web flow that is needed to
	 * exit from the module. E.g. navigating back to home page.
	 */
	void exit();

	/**
	 * Implement this method to provide the capability of search on the
	 * underline module web page and to provide the search result.
	 * 
	 * @param id
	 * @return
	 */
	List<WebElement> search(String id);

	/**
	 * Implement this method to provide the logic to load a provided
	 * moduleContainer which mainly received from the module search
	 * functionality. It can use {@link Contract} object to get the module
	 * container identifier.
	 * 
	 * @param contract
	 * @param moduleContainer
	 * @return
	 */
	T process(Contract contract, WebElement moduleContainer);

	/**
	 * Implement this method to provide the logic to load a provided
	 * moduleContainer which mainly received from the module search
	 * functionality. It can use provided module container identifier to load
	 * and provide the instance of module specific entity instance.
	 * 
	 * @param id
	 * @param moduleContainer
	 * @return
	 */
	T process(String id, WebElement moduleContainer);
}
