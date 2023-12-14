package ub.code.definition.core.hook;

import io.cucumber.java.After;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import ub.code.core.driver.BrowserFactory;

@Log
public class DriverManagementSteps {

    @Autowired
    private BrowserFactory browserFactory;

    @After
    public void tearDownThreadDriver() {
        if(browserFactory != null) {
            log.info(String.format("Quitting WebDriver %d", browserFactory.getWebDriver().hashCode()));
            browserFactory.destroyWebDriver();
        }
    }
}
