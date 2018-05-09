package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/cucumber/features", glue = "cucumber/stepdefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {
}
