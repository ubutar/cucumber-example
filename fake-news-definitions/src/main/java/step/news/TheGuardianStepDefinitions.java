package step.news;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import ub.code.driver.BrowserFactory;


public class TheGuardianStepDefinitions {

    @Autowired
    private BrowserFactory browserFactory;

    @SneakyThrows
    @Given("this does smth in thread")
    public void thisReadsAndWritesProperties() {
        System.out.println("this reads and writes properties");
        browserFactory.getWebDriver().get("http://example.com");
        Thread.sleep(10000);
    }

    @When("it is executed")
    public void itIsExecuted() {
        System.out.println("it is executed");
        System.out.println(browserFactory.getWebDriver().getCurrentUrl());
        System.out.println("webdriver is"+browserFactory.getWebDriver().getWindowHandle());
    }

    @Then("it will be executed")
    public void itWillBeExecuted() {
        System.out.println("it will be executed");
        System.out.println(browserFactory.getWebDriver().getPageSource());
    }

    @SneakyThrows
    @Given("this does smth in another thread")
    public void thisReadsProperties() {
        System.out.println("this reads properties");
        browserFactory.getWebDriver().get("http://example.org");
        Thread.sleep(10000);
    }
}
