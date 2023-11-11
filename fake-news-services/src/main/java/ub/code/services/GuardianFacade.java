package ub.code.services;

import example.page.guardian.TheGuardianTonePage;
import org.springframework.stereotype.Component;

@Component
public class GuardianFacade extends WebFacade {

    public GuardianFacade openGuardianFeed() {
         new TheGuardianTonePage(browserFactory.getWebDriver())
                .openDirectly().handleConsenting();
         return this;
    }

    public String takeFirstNewsFeedTitle() {
        return new TheGuardianTonePage(browserFactory.getWebDriver()).getFirstTitle();
    }

}
