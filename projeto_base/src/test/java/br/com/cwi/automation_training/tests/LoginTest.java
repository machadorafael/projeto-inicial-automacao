package br.com.cwi.automation_training.tests;

import org.junit.ClassRule;
import org.junit.runner.RunWith;

import br.com.cwi.automation_training.pages.ParallelCucumber;
import br.com.cwi.automation_training.util.TestRule;
import cucumber.api.CucumberOptions;

@RunWith(ParallelCucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@login", glue = { "" })
public class LoginTest {

    @ClassRule
    public static TestRule testRule = new TestRule();

}