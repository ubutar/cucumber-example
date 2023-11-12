package ub.code.core.base;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ub.code.core.config", "ub.code.core.driver"})
public class DriverConfiguration {
}
