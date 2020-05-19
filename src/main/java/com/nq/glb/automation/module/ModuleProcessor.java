package com.nq.glb.automation.module;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.nq.glb.automation.model.Contract;

public interface ModuleProcessor<T> {

	void navigate();

	void process();

	void exit();

	List<WebElement> search(String id);

	T process(Contract contract, WebElement moduleContainer);

	T process(String id, WebElement moduleContainer);
}
