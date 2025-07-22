package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "Feature",
        glue = {"Stepdef", "Hooks"},
        tags = "@material",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)

public class paySlateRunner extends AbstractTestNGCucumberTests {
}
