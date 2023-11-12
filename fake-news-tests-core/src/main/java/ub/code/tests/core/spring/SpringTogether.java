package ub.code.tests.core.spring;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ub.code.definition.core.context.DefinitionsConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {
        DefinitionsConfiguration.class
})
public class SpringTogether {
}
