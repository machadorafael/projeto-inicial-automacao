package tests;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import util.TestRule;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/FabricaDeTestes.feature", tags = "~@Visual", 
	  glue = {""}, monochrome = true, dryRun = false)
public class FabricaDeTestesTests {
	@ClassRule
	public static TestRule testRule = new TestRule();
}
