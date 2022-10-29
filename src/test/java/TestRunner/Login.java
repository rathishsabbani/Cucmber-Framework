package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Feature/Customers.feature",glue={"StepDefinition"}
                   ,dryRun=false, monochrome = true, plugin={"pretty","html:test-output "},
                    tags = "@sanity")
public class Login {


}
