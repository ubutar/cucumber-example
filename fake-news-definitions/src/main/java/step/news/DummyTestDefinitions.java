package step.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import ub.util.nlp.CosineSimilarity;

@Log
public class DummyTestDefinitions {

    @Autowired
    private CosineSimilarity cosineSimilarity;

    @Given("test always passes")
    public void testAlwaysPasses() {
    }

    @And("everyone is happy")
    public void everyoneIsHappy() {
        log.info("c.sim.: " + cosineSimilarity.cosineSimilarity("every body is happy", "every one is happy"));
    }
}
