package step.core;

import io.cucumber.java.After;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import ub.code.driver.BrowserFactory;

@Log
public class DriverManagementSteps {

    @Autowired
    private BrowserFactory browserFactory;

    @After
    public void tearDownThreadDriver() {
        log.info(String.format("Quitting WebDriver %d", browserFactory.getWebDriver().hashCode()));
        browserFactory.destroyWebDriver();
    }
}
