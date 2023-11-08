package spring;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ub.code.base.DriverConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {DriverConfiguration.class})
public class SpringTogether {
}
