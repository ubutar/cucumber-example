package spring;

import example.page.config.PagesConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import step.context.DefinitionsConfiguration;
import ub.code.base.DriverConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {DriverConfiguration.class, PagesConfiguration.class, DefinitionsConfiguration.class})
public class SpringTogether {
}
