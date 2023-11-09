package example.page.guardian;

import example.page.constant.PageConstants;
import org.openqa.selenium.WebDriver;
import ub.code.annotations.DirectUrl;

@DirectUrl(propertyKey = PageConstants.GUARDIAN_TONE_PAGE_KEY)
public class TheGuardianTonePage extends TheGuardianBasePage {

    public TheGuardianTonePage(WebDriver driver) {
        super(driver);
    }

}
