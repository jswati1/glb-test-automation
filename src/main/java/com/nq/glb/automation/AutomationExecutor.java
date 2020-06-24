package com.nq.glb.automation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * @author jswati
 *
 */
public class AutomationExecutor {

	public static void main(String[] args) {
		runTestSuite();
	}

	public static void runTestSuite() {
		XmlSuite suite = new XmlSuite();
		suite.setName("GLB Automation Test Suite");
		XmlTest testTag = new XmlTest(suite);
		testTag.setName("automation test");
		testTag.setVerbose(2);
		Map<String, String> testngParams = new HashMap<String, String>();
		testngParams.put("contractId", "22244");
		testTag.setParameters(testngParams);
		List<XmlClass> xmlclasses = new ArrayList<XmlClass>();
		String className = "com.nq.glb.automation.test.suite.RateModuleTest";
		XmlClass xmlClass = new XmlClass(className);
		xmlclasses.add(xmlClass);
		className = "com.nq.glb.automation.test.suite.LesseeModuleTest";
		xmlClass = new XmlClass(className);
		xmlclasses.add(xmlClass);
		className = "com.nq.glb.automation.test.suite.VendorModuleTest";
		xmlClass = new XmlClass(className);
		xmlclasses.add(xmlClass);
		className = "com.nq.glb.automation.test.suite.InvestorModuleTest";
		xmlClass = new XmlClass(className);
		xmlclasses.add(xmlClass);
		className = "com.nq.glb.automation.test.suite.ReportModuleTest";
		xmlClass = new XmlClass(className);
		xmlclasses.add(xmlClass);
		testTag.setXmlClasses(xmlclasses);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG testNg = new TestNG();
		testNg.setXmlSuites(suites);
		testNg.run();
	}

}
