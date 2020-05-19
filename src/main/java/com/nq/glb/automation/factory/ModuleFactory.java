package com.nq.glb.automation.factory;

import org.openqa.selenium.WebDriver;

import com.nq.glb.automation.model.ModuleType;
import com.nq.glb.automation.module.ModuleProcessor;
import com.nq.glb.automation.module.RateModuleProcessor;

/**
 * @author jswati
 *
 */
public class ModuleFactory {

	private static final ModuleFactory factory = new ModuleFactory();

	private ModuleFactory() {

	}

	public static ModuleFactory factory() {
		return factory;
	}

	public static ModuleProcessor module(ModuleType module, WebDriver driver) {

		ModuleProcessor processor = null;

		switch (module) {

		case RATE:
			processor = new RateModuleProcessor(driver);
		}
		return processor;
	}

}
