package ub.code.base;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ub.config", "ub.code.driver"})
public class DriverConfiguration {
}
