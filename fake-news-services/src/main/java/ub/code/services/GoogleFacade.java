package ub.code.services;

import example.page.google.GoogleSearchResultPage;
import example.page.google.GoogleStarterPage;
import org.springframework.stereotype.Component;
import ub.code.model.GoogleSearchResult;

import java.util.List;

@Component
public class GoogleFacade extends WebFacade {

    public GoogleFacade inGoogle() {
        new GoogleStarterPage(browserFactory.getWebDriver()).openDirectly().handleConsenting();
        return this;
    }

    public GoogleFacade searchFor(String query) {
        new GoogleStarterPage(browserFactory.getWebDriver()).searchByText(query).waitForSearchResults();
        return this;
    }

    public List<GoogleSearchResult> currentSearchResults() {
        return new GoogleSearchResultPage(browserFactory.getWebDriver()).getSearchResults();
    }
}
