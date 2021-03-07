package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * @author jaishankar
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/com/hypenapp/features", 
monochrome = true, 
dryRun = false,
glue = { "com.hypenapp.stepdefinitions","apphooks" },
plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"}
)
public class MyTestRunner {

}