package ub.code.core.testng.spring;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ub.code.core.testng.config.OtherDefinitionsConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {
        OtherDefinitionsConfiguration.class
})
public class SpringTestngTogether {
}
