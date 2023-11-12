package ub.code.definition.news;

import io.cucumber.java.en.*;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.MatcherAssert;
import ub.code.definition.context.GuardianTestContext;
import ub.code.definition.news.base.TheGuardianBase;
import ub.code.model.GoogleSearchResult;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TheGuardianWebDefinitions extends TheGuardianBase {

    @Given("The Guardian news feed is open")
    public void guardianToneFeedIsOpen() {
        guardian.openGuardianFeed();
        context = new GuardianTestContext();
    }

    @When("first news on the tone feed is taken")
    public void firstNewsIsTaken() {
        context.put(GuardianTestContext.ContextVar.NEWS_TITLE, guardian.takeFirstNewsFeedTitle());
    }

    @And("news title is searched for in Google")
    public void newsTitleIsSearchedInGoogle() {
        google.inGoogle().searchFor(context.get(GuardianTestContext.ContextVar.NEWS_TITLE).toString());
    }

    @Then("there should be at least {int} Google search results except from {string}")
    public void thereShouldBeAtLeastNGoogleSearchResultsExceptFrom(Integer n, String exceptSource) {
        List<GoogleSearchResult> gsr = google.currentSearchResults().stream()
                .filter(result -> !StringUtils.equalsIgnoreCase(result.getSource(), exceptSource))
                .collect(Collectors.toList());

        context.put(GuardianTestContext.ContextVar.GOOGLE_SEARCH_RESULTS, gsr);
        assertThat(gsr.size(), greaterThanOrEqualTo(n));
    }

    @Then("there should be at least {int} Google search results")
    public void thereShouldBeAtLeastNGoogleSearchResults(Integer n) {
        List<GoogleSearchResult> gsr = google.currentSearchResults();

        context.put(GuardianTestContext.ContextVar.GOOGLE_SEARCH_RESULTS, gsr);
        assertThat(gsr.size(), greaterThanOrEqualTo(n));
    }

    @When("first news having {string} in title is searched")
    public void firstNewsHavingKeywordInTitleIsSearched(String keyWord) {
        context.put(GuardianTestContext.ContextVar.NEWS_TITLE, guardian.takeFirstNewsFeedTitleWithKeyWord(keyWord));
    }

    @And("such news title was found")
    public void suchNewsTitleWasFound() {
        MatcherAssert.assertThat(context.get(GuardianTestContext.ContextVar.NEWS_TITLE), notNullValue());
    }

    @SuppressWarnings("unchecked")
    @And("there is/are at least {int} result(s) with similarity {double} or more")
    public void thereAreAtLeastResultsWithSimilarityScoreOrMore(int resultsCount, double score) {
        assertThat(googleResultsExceedingSimilarityThreshold(score), greaterThanOrEqualTo(resultsCount));
    }

    @SuppressWarnings("unchecked")
    @But("no more than {int} result(s) with similarity more than {double}")
    public void noMoreThanResultsWithSimilarityMoreThanScore(int countResults, double score) {
        assertThat(googleResultsExceedingSimilarityThreshold(score), lessThanOrEqualTo(countResults));
    }

    @And("news title is searched for with Google on {string}")
    public void newsTitleIsSearchedForWithGoogleOnSites(String siteName) {
        String title = context.get(GuardianTestContext.ContextVar.NEWS_TITLE).toString();
        title = StringUtils.substring(title, 0, (int) (title.length() * 0.2));
        google.inGoogle().searchFor(String.format("site:%s %s", siteName, title));
        context.put(GuardianTestContext.ContextVar.GOOGLE_SEARCH_RESULTS, google.currentSearchResults());
    }

    @Then("title should not have similarity more than {double} to any of results")
    public void titleShouldNotHaveSimilarityMoreThanScoreToAnyOfResults(double score) {
        assertThat(googleResultsExceedingSimilarityThreshold(score), is(0));
    }
}
