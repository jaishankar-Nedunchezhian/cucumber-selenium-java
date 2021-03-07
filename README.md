# cucumber-selenium-java
## BDD Automation Framework for Betterworks App 

This Automation framework with BDD approach using Cucumber ,Java ,selenium , Junit and Extent Spark Reports

Design Pattern - Page Object Model + Singleton + SRP(single responsibility principle)

# src/main/java
1. com.hypen.factory
2. com.hypen.pages
3. com.hypen.util

# src/test/java
1. apphooks
2. com.hypenapp.stepdefinitions
3. testrunners

# src/test/resource
1. com.hypenapp.features
2. config
3. cucumber.properties
4. extend-config.xml
5. extend-properties
6. junit-platform.properties

# Reports 
1. test output
2. test-output
3. test-output-thread

## Technologies Used 
1. Selenium WebDriver with Java
2. Cucumber 6.x JVM library
3. WebDriverManager
4. JDK 1.8
5. Maven (Build tool) and Maven Plugins
6. Cucumber extent report 6 adapter
7. JUnit 4.x library

## Framework Design layer Components 
1. Feature files - [location :src/test/resource] - [package : com.hypenapp.features]
		File where you will describe your tests and it can contain a scenario or can contain many scenarios in a 			single 	feature.
		
2. Step Definition Classes - [location :src/test/java] - [package : com.hypenapp.stepdefinitions]
		Steps definition file stores the mapping between each step of the scenario defined in the feature file with 		a 	code of function to be executed. So, now when Cucumber executes a step of the scenario mentioned in the 		feature 	file, it scans the step definition file and figures out which function is to be called.

3. Configuration Files - [location :src/test/resource] - [package : config.properties]
		Properties file to store the Application URL and other properties

4. Cucumber Hooks - [location :src/test/java] - [package : apphooks]
		Cucumber supports hooks, which are blocks of code that run before or after each scenario

5. Utilities - [location :src/test/java] - [package : com.hypen.util]
		Utility methods , Waits , Libraries and generic functions can be added
		
6. Test Runner - [location :src/test/java] - [package : testrunners]
		Cucumber uses Junit we need to have a Test Runner class. This class will use the Junit annotation 				@RunWith(), which tells JUnit what is the test runner class. It more like a starting point for Junit to 			start executing your tests.

7. Cucumber 6 extend Spark Report 
		A PDF report and HTML report is generated with the cucumber adapter plugin and dependencies

8. Page Classes in Page Object Model 
		Page object model design pattern is followed for each page with locators and their actions
		
9. Maven with pom.xml 
		Different dependencies and plugins for the project
		
10. Parallel Execution 
		Plugin added in pom.xml , Feature file parallel execution is achieved with junit

11. Driver Factory
		Initialise the Driver with Thread.local (java 8 feature)

12. Config reader File 
		Load the configuration files 

## Improvement /Enhancements to the Project

1. Generic functions / Libraries can be built 
2. Running testcases from Jenkins - Integration 
3. Running testcases on Dockerized selenium Grid
4. Testng for parallel exectution of scenarios
5. Integration with AWS 
6. Log4j for logging
