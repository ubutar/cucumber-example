package step.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import ub.code.services.GoogleFacade;
import ub.code.services.GuardianFacade;

public class TheGuardianSimpleDefinitions {

    @Autowired
    private GuardianFacade guardian;

    private String firstNewsFeedTitle;

    @Autowired
    private GoogleFacade google;

    @Given("The Guardian news feed is open")
    public void guardianToneFeedIsOpen() {
        guardian.openGuardianFeed();
    }

    @When("first news on the tone feed is taken")
    public void firstNewsIsTaken() {
        this.firstNewsFeedTitle = guardian.takeFirstNewsFeedTitle();
    }

    @And("news title is searched for in Google")
    public void newsTitleIsSearchedInGoogle() {
        google.inGoogle().searchFor(firstNewsFeedTitle);
    }

    @Then("there should be at least {int} Google search results")
    public void thereShouldBeAtLeastNGoogleSearchResults(Integer n) {
        assert google.currentSearchResults().size() >= n;
    }
}
