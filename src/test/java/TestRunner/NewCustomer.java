package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"E:\\CucumberFromScratch\\Features\\Login.feature","E:\\CucumberFromScratch\\Features\\Customers.feature"},
                  glue="StepDefinition",
                  dryRun=true, 
                  monochrome=true,
                  plugin={"pretty","html:test-output "})
public class NewCustomer {

}
