package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"C:\\Users\\ABC\\eclipse-workspace\\Cucumber-Scratch\\Features\\Customers.feature"},
                  glue="StepDefinition",
                  dryRun=false, 
                  monochrome=true,
                  plugin={"pretty","html:test-output.html"}
                   )

//and condition - tags={"@Sanity","@Smoke"}
//or condition - tags={"@Sanity, @Smoke"}

public class NewCustomer {

}
