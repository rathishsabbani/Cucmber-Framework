package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\ABC\\eclipse-workspace\\Cucumber-Scratch\\Features\\Login.feature",
                 glue={"StepDefinition"},
                 dryRun=false, 
                 monochrome = true, 
                 plugin={"pretty","html:test-output.html"}
                 )


public class TestRun
{

	
		
	
	
}
