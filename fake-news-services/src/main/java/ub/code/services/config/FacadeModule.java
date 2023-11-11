package ub.code.services.config;

import example.page.config.PagesConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ub.code.base.DriverConfiguration;

@Configuration
@Import({DriverConfiguration.class, PagesConfiguration.class})
@ComponentScan(basePackages = "ub.code.services")
public class FacadeModule {
}
