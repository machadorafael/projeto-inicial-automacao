package tests;

import org.junit.ClassRule;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import util.TestRule;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/NovosExtratosValoresDepositadosSuaConta.feature", tags = "@Visual", 
	  glue = {""}, monochrome = true, dryRun = false, plugin = {"json:cucumber.json"})
public class VisualTests {
	@ClassRule
	public static TestRule testRule = new TestRule();
}