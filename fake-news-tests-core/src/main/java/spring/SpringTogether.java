package spring;

import example.page.config.PagesConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import step.context.DefinitionsConfiguration;
import ub.code.base.DriverConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {
        DefinitionsConfiguration.class
})
public class SpringTogether {
}
