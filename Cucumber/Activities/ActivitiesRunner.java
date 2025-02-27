package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@activity5",
        plugin = {
                "pretty",
                "html:test-reports/html-report.html",
                "json:test-reports/json-report.json"
        },
       monochrome = true

)

public class ActivitiesRunner {
    //empty
}


