package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features", tags="@auto",plugin = {"json:target/jsonReports/cucumber-report.json","rerun:rerun.txt"}, glue = {"stepDefinitions"} )
public class TestRunner {

}
