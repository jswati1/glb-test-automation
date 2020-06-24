

Java Based 

Technology stack 
- Java JDK 1.8 - programming 
- Maven 
- Eclipse IDE
- Chrome driver 

Test frameworks 
- testNG - test automation
- Selenium - web automation scripting

How to run it 

process  - Using shared JAR file 

- Unzip executor folder. 
- Go inside the executor folder. This contains the jar file named - test-automation-0.0.1-SNAPSHOT-automation-tests.jar
- Open test-config.properties and define the value of key "test.execution.report.path" to the location where you want the test execution report to be generated. E.g. 
	test.execution.report.path=D:/reports
- Create C:\tools directory and copy the chromedriver.exe into it. 
  E.g. C:\tools\chromedriver.exe
- Open glb-automation-test-suites.xml file and update the paramter named "config-file-path" with value as the location where test-config.properties file is located. 
  E.g. <parameter name="config-file-path" value="D:/executor" />
- Open the command prompt and run the below command
	java -jar test-automation-0.0.1-SNAPSHOT-automation-tests.jar org.testng.TestNG glb-automation-test-suites.xml
	
- After execution of test cases, it will generate the report at the configured location defined in test.execution.report.path property. 
- Open the glb_automation.html to get the details of test execution results. 




























process 2 - Using shared code 

- Go to the roject root directory. 
 E.g. D:\code\glb-test-automation

- Run the below command 
 mvn clean install -DskipTests=true

- After jar is created get the jar file from target directory and coy it into any directory. 
- Coy the test-config.properties and glb-automation-test-suites.xml from code to directory where jar is laced. 
- Follow the stes as mentioned above in process 1. 
