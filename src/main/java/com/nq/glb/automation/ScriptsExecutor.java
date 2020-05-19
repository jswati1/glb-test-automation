package com.nq.glb.automation;

public class ScriptsExecutor {
//	@Test
//	@Parameters({ "customer", "supplier", "accountType", "extractionType" })
//	public void StartExecution(String customer, String supplier, String accountType, String extractionType)
//			throws Exception {
//		Message.printExecutionStarted();
//		final SupplierDetail supplierDetail = CredentialsManager.getSupplierDetails(customer, supplier, accountType,
//				extractionType);
//		if (supplierDetail == null) {
//			System.out.println("Unable to get the credentials");
//			throw new Exception("Unable to get the credentials");
//		}
//		try {
//			Executor(supplierDetail);
//		} catch (final Exception ex) {
//			ex.printStackTrace();
//			System.out.println("Unknown Exception");
//		}
//	}
//
//	private void Executor(SupplierDetail supplierDetail) {
//
//	    final Instant startTime = Instant.now();
//        Instant endTime = Instant.now();
//
//		if (supplierDetail.getCredential().size() <= 0) {
//			Message.printAllCredentialsAreInvalid();
//			Generic.Log(supplierDetail, supplierDetail.getExecutionDetails());
//			Message.printExecutionEnded();
//			System.exit(-1);
//		}
//
//		// System.out.println("Supplier details:"+supplierDetail);
//
//		int driverClosed = -1;
//		// supplierDetail.setDriver("chrome");
//		final IExecutor supplierExecutor = new ExecutorFactory().GetExecutor(supplierDetail.getSupplier());
//		final IExtractor supplierExtractor = new ExtractorFactory().getExtractor(supplierDetail.getAccountType(),
//				supplierDetail.getSupplier());
//
//		supplierExecutor.setDetails(supplierDetail, supplierExtractor);
//
//		System.out.println("Supplier executor and extractor is setup.");
//
//		for (final CustomerCredential credential : supplierDetail.getCredential()) {
//			credential.Status.isLoginSuccess = supplierExecutor.login(credential.getUserName(),
//					credential.getPassword(), credential.Status);
//
//			if (credential.Status.isLoginSuccess != 1) {
//				// System.out.println("Supplier credentials are invalid:" +
//				// credential.getUserName());
//				continue;
//			} else {
//				// System.out.println("Supplier credentials are valid."+
//				// credential.getUserName());
//			}
//
//			endTime = Instant.now();
//	        System.out.println("Total time taken in Authentication: "+Duration.between(startTime,endTime));
//			credential.Status.isNavigateSuccess = supplierExecutor.navigateToAllocationPage(credential.Status);
//
//			if (credential.Status.isNavigateSuccess != 1) {
//				System.out.println("Failed to navigate to allocation page.");
//				continue;
//			} else {
//				System.out.println("Successfully navigated to allocation page.");
//			}
//            endTime = Instant.now();
//            System.out.println(
//                    "Total time taken in Navigation to allocation page: " + Duration.between(startTime, endTime));
//
//			System.out.println("Extracting the allocation details.");
//			credential.Status.isExtractSuccess = supplierExecutor.extract(credential.Status);
//
//			endTime = Instant.now();
//            System.out.println(
//                    "Total time taken in Extracting the allocation details: " + Duration.between(startTime, endTime));
//
//			if (credential.Status.isExtractSuccess == 1) {
//				System.out.println("Successfully extracted the alocation details with status 1");
//				if (credential.Status.isDriverClosed != 1) {
//					SeleniumUtil.closeDriver(supplierDetail.getWebDriver());
//					credential.Status.isDriverClosed = 1;
//				}
//
//				System.out.println("Application workspace type is configured as:" + ApplicationConstants.WorkspaceType);
//				if (ApplicationConstants.WorkspaceType.equalsIgnoreCase(ApplicationConstants.WorkspaceType_Main)) {
//					Generic.exportedPythonInvocation(supplierDetail, credential.Status,
//							supplierDetail.getExecutionDetails());
//				}
//				// Call python script
//				System.out.println("call python script to process the records to database.");
//				Generic.callPythonScript(supplierDetail.getExtractedFileName(), supplierDetail.getURL(),
//						credential.getUserName(), supplierDetail.getFileSavePath(), supplierDetail.getAccountType(),
//						credential.Status, ApplicationConstants.Extracted);
//				Message.printExecutionEnded();
//				Generic.Log(supplierDetail, supplierDetail.getExecutionDetails());
//
//				try {
//					if (supplierDetail.getWebDriver() != null) {
//						System.out.println("Terminating the supplier driver.");
//						supplierDetail.getWebDriver().quit();
//					}
//				} catch (final Exception e) {
//					System.err.println("Failed to close browser windows due to:" + e);
//				}
//				
//	            endTime = Instant.now();
//	            System.out.println(
//	                    "Total time taken in execution of polling script: " + Duration.between(startTime, endTime));
//
//				// For Jenkind to indicate color...on success
//				System.out.println("Returning with status 0.");
//				System.exit(0);
//				break;
//			}
//
//			else if (credential.Status.isExtractSuccess == 0 || credential.Status.isExtractSuccess == -1) {
//				System.out.println("Failed to extract the alocation details:" + credential.Status.isExtractSuccess);
//
//				if (ApplicationConstants.WorkspaceType.equalsIgnoreCase(ApplicationConstants.WorkspaceType_Main)) {
//					Generic.exportedPythonInvocation(supplierDetail, credential.Status,
//							supplierDetail.getExecutionDetails());
//				}
//				continue;
//			}
//			driverClosed = credential.Status.isDriverClosed;
//		}
//		if (driverClosed != 1) {
//			SeleniumUtil.closeDriver(supplierDetail.getWebDriver());
//			Generic.Log(supplierDetail, supplierDetail.getExecutionDetails());
//			Message.printExecutionEnded();
//			System.out.println("Failed to close driver.");
//			System.exit(-1);
//		}
//
//	}
//
}
