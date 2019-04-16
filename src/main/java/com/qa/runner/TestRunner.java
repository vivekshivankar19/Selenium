package com.qa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\lenovo\\eclipse-workspace\\POM\\src\\main\\java\\com\\qa\\features\\freecrm.feature",
		glue= {"C:\\Users\\lenovo\\eclipse-workspace\\POM\\src\\main\\java\\com\\qa\\stepDefinations"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
        monochrome = true,  // display the console output in proper readable format
        strict = false,  // check if any steps not define 
        dryRun = false // check the proper mapping between feature file and stepDef
	)
public class TestRunner {

}
