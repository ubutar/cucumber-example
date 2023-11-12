package ub.code;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/news")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value =
        "classpath:ub/code/definition/news" +
        ",classpath:ub/code/definition/core" +
        ",classpath:ub/code/tests/core/spring"
)
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @off")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value =
        "json:target/cucumber-reports/cucumber.json" +
        ",html:target/cucumber-reports/cucumber.html")
public class CucumberWebNewsTestsRunner {

}