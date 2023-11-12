package spring;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import step.context.DefinitionsConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {
        DefinitionsConfiguration.class
})
public class SpringTogether {
}
