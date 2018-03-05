package tests;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import util.TestRule;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/QuemSomos.feature", tags = "~@Visual", 
	  glue = {""}, monochrome = true, dryRun = false)
public class QuemSomosTests {
	@ClassRule
	public static TestRule testRule = new TestRule();
}
