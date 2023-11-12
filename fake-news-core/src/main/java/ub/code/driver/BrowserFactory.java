package ub.code.driver;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ub.config.BrowserConfig;

import java.time.Duration;

@Component
@Getter @Setter
public class BrowserFactory {

    @Autowired
    private BrowserConfig browserConfig;

    private ThreadLocal<WebDriver> threadLocalWebDriver = ThreadLocal.withInitial(() -> {

        if(browserConfig.isRemoteDriver()) {
            System.setProperty("webdriver.remote.server", browserConfig.getRemoteDriverUrl());
            WebDriver webDriver = new RemoteWebDriver(browserConfig.getDesiredCapabilities());

            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(browserConfig.getDriverImplicitWait()));
            return webDriver;
        } else {
            //  Given availability of containers
            //  and client-server architecture of Selenium WebDriver,
            //  this option is really unnecessary
            throw new UnsupportedOperationException("'Local' WebDriver creation is not supported yet");
        }

    });

    public WebDriver getWebDriver() {
        return threadLocalWebDriver.get();
    }

    public void destroyWebDriver() {
        threadLocalWebDriver.get().quit();
        threadLocalWebDriver.remove();
    }
}
