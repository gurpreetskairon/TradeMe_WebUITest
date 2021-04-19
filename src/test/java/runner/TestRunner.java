package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featurefiles", glue= {"stepdefinitions"},
monochrome=true,
plugin= {"junit:target/JUnitReports/report.xml", "json:target/JSONReports/report.json", "html:target/HTMLReprts"})
public class TestRunner {

}
