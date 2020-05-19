package com.nq.glb.automation;

public class ApplicationMain {
//	public static void main(String[] args) throws FileNotFoundException {
//		if (args[0] == null || args[1] == null || args[2] == null) {
//			throw new IllegalArgumentException("Not all parameters are present for the execution");
//		}
//		String extractionType = ApplicationConstants.ScriptExecutionType_e1;
//		if (args.length == 4) {
//			if (args[3] == null) {
//				extractionType = ApplicationConstants.ScriptExecutionType_e1;
//			} else {
//				extractionType = args[3];
//			}
//		}
//		Environment env = null;
//		if (args.length == 5) {
//			if (args[4] != null) {
//				try {
//					env = Environment.valueOf(args[4].toUpperCase());
//				} catch (Exception ignore) {
//				}
//			}
//		}
//
//		IntializeApplicationConstants.intializeApplicationContants(env);
//		// Dynamic TestNg suite instantiation
//		System.out.println("Running Test Suite..." + ApplicationConstants.WorkspaceType);
//		runTestSuite(args[0], args[1], args[2], extractionType);
//	}
//
//	public static void runTestSuite(String customer, String supplier, String accountType, String extractionType) {
//		XmlSuite suite = new XmlSuite();
//		suite.setName("TestNG");
//		XmlTest testTag = new XmlTest(suite);
//		testTag.setName("Extraction");
//		testTag.setVerbose(2);
//		Map<String, String> testngParams = new HashMap<String, String>();
//		testngParams.put("customer", customer);
//		testngParams.put("supplier", supplier);
//		testngParams.put("accountType", accountType);
//		testngParams.put("extractionType", extractionType);
//		testTag.setParameters(testngParams);
//		List<XmlClass> xmlclasses = new ArrayList<XmlClass>();
//		String className = "com.en.rackinsight.ScriptsExecutor";
//		XmlClass xmlClass = new XmlClass(className);
//		xmlclasses.add(xmlClass);
//		testTag.setXmlClasses(xmlclasses);
//
//		List<XmlSuite> suites = new ArrayList<XmlSuite>();
//		suites.add(suite);
//		TestNG testNg = new TestNG();
//		testNg.setXmlSuites(suites);
//		testNg.run();
//	}
}
