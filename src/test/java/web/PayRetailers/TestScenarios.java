package web.PayRetailers;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
glue = "web.PayRetailers", 
//plugin = {"testng:target/testng-cucumber-reports/second/cuketestng.xml"},
plugin = {"progress"},
features = "src/test/resources/features/PayRetailers.feature",
tags = "@HOM", 
monochrome = true)
public class TestScenarios extends AbstractTestNGCucumberTests {

}
