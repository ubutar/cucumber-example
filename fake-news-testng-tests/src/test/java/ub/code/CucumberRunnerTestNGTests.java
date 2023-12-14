package ub.code;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = {"src/test/resources/features/base"},
        glue = {"classpath:ub.code.definition.other"
                , "classpath:ub.code.core.testng.spring"
        }
)
public class CucumberRunnerTestNGTests extends AbstractTestNGCucumberTests {

}
