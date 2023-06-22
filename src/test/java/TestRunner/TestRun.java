package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="E:\\CucumberFromScratch\\Features\\Customers.feature",
                 glue={"StepDefinition"},
                 dryRun=false, 
                 monochrome = true, 
                 plugin={"pretty","html:test-output.html"},
                 tags = "@sanity"
                 )


public class TestRun
{

	
		
	
	
}
