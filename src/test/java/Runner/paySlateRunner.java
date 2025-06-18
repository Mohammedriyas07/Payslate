package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Feature",glue = {"Stepdef","Hooks"},tags = "@bus1")
public class paySlateRunner extends AbstractTestNGCucumberTests {
}
