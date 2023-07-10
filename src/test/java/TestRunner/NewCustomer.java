package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"E:\\CucumberFromScratch\\Features\\Customers.feature"},
                  glue="StepDefinition",
                  dryRun=false, 
                  monochrome=true,
                  plugin={"pretty","html:test-output.html"},
                  tags= "@sanity" )

//and condition - tags={"@Sanity","@Smoke"}
//or condition - tags={"@Sanity, @Smoke"}

public class NewCustomer {

}
