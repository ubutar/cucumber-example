package ub.code.definition.other;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import ub.util.nlp.Similarity;

@Log
public class OtherDefinitions {

    @Autowired
    protected Similarity similarityCalc;

    @Given("This is a TestNG test")
    public void thisIsATestNGTest() {
    }

    @When("Some service is called")
    public void someServiceIsWorking() {
        log.info(String.valueOf(similarityCalc.similarity("This is text", "This is text too")));
    }

    @Then("Integration is working")
    public void integrationIsWorking() {

    }
}
