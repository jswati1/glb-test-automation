# GLB Test Automation 

GLB Test Automation is the automation testing tool to test the glb website. 
It is currently tested and programmed for GLB Beta website on chrome web browser.

# Features
  - Automation Test Suite for following modules: 
     - Rate 
     - Leessee
     - Vendor
     - Investor
     - State 
     - Utilities - Invoice 
     - Utilities - Filter 
     - Utilities - Docset 
     - Reports - Contract Status Reports 
     - Reports - Management Status Reports 
     - Reports - Sales Reports 

### Technology stack
* Java JDK 1.8 - programming
*  Maven - Build and dependency management.
*  Eclipse IDE - develoment Editor
*  Chrome driver - supporting chrome web browser.  
*  TestNG - Test automation framework
*  Selenium - web automation scripting framework

## Installation and execution instructions
#### Using GLB Automation JAR file 
If you already have the automation test suite executor zip file. Then follow below steps: 
- The executor zip contains below files after you unzip it:  
    ```sh
    cd C:/executor
    ```
    - test-automation-0.0.1-SNAPSHOT-automation-tests.jar
    - testng.xml
    - test-config.properties
    - chromedriver.exe
- Open test-config.properties
    - define the value of key "test.execution.report.path" to the location   where you want the test execution report to be generated. E.g. 
      ```sh
  	    test.execution.report.path=C:/executor/reports
      ```
    - define the value of key "browser.config.driver.path" to the complete location where you have browser driver. E.g. 
      ```sh
  	    browser.config.driver.path=C:/executor/chromedriver.exe
      ```      
        OR 
    - create C:\tools directory and copy the chromedriver.exe into it. This is the default location configured in configuration file. 
        ```sh
  	    browser.config.driver.path= C:/tools/chromedriver.exe
      ```   
    - set the execution background to "true" if you do not want the automation test execution to be done in background. 
        ```sh
  	    test.execution.background.enabled=true
      ```         
- Open testng.xml file
    - update the paramter named "config-file-path" with value as the location where test-config.properties file is located. 
        ```sh
  	        <parameter name="config-file-path" value="C:/executor" />
        ```  
    - comment the test cases if want to execute test cases for only specific moduel. 
        ```sh
  	        <!-- class name="com.nq.glb.automation.test.suite.InvoicesModuleTest" />  -->
        ```  
- Open the command prompt and run the below command
    ```sh
  	    java -jar test-automation-0.0.1-SNAPSHOT-automation-tests.jar org.testng.TestNG testng.xml
    ``` 
- After execution of test cases, it will generate the report at the configured location defined in test.execution.report.path property. 
- Open the glb_automation.html to get the details of test execution results. 


#### Using GLB Automation Code 

- Go to the roject root directory. 
    ```sh
        cd C:\code\glb-test-automation
    ``` 
- Run the below command 
    ```sh
        mvn clean install -DskipTests=true
    ``` 
- After jar is created get the jar file from target directory and coy it into any directory. 
- Coy the test-config.properties and testng.xml from code to directory where jar is placed. 
- Follow the steps as mentioned above in process 1. 

#### Using GLB Automation Code and Eclipse IDE

- Open the glb-test-automation roject in eclise. 
- right click on testng.xml and run it as TestNG. This will execute the testcases.  
