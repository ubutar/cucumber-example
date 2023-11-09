package ub.config;

import lombok.Data;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BrowserConfig {

    @Value("${is.remote.driver}")
    private boolean isRemoteDriver;

    @Value("${driver.path}")
    private String driverPath;

    @Value("${remote.driver.url}")
    private String remoteDriverUrl;

    @Value("${remote.driver.capabilities.json}")
    private String remoteDriverCapabilitiesJson;

    @Value("${driver.implicit.wait}")
    private Integer driverImplicitWait;

    @Bean
    @SneakyThrows
    public DesiredCapabilities getDesiredCapabilities() {
        return new DesiredCapabilities(new JacksonJsonParser().parseMap(remoteDriverCapabilitiesJson));
    }
}
