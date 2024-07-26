package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/",glue= {"stepDefinitions"},
monochrome = true,
plugin = {"pretty","html:target/HtmlReports/htmlReport.html","json:target/jsonReports/jsonReport.json","junit:target/xmlReports/xmlReport.xml"},
tags="@tag2"
		)
public class TestRunner {

}
