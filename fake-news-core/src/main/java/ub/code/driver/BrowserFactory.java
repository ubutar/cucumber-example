package ub.code.driver;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ub.config.BrowserConfig;

@Component
@Getter @Setter
public class BrowserFactory {

    @Autowired
    private BrowserConfig browserConfig;

    private ThreadLocal<WebDriver> threadLocalWebDriver = ThreadLocal.withInitial(() -> {

        if(browserConfig.isRemoteDriver()) {
            System.setProperty("webdriver.remote.server", browserConfig.getRemoteDriverUrl());
            return new RemoteWebDriver(browserConfig.getDesiredCapabilities());
        } else {
            // TODO given docker and client-server architecture of SWD, do we really need this option here?
        }
        return null;
    });

    public WebDriver getWebDriver() {
        return threadLocalWebDriver.get();
    }

    public void destroyWebDriver() {
        threadLocalWebDriver.get().quit();
    }
}
