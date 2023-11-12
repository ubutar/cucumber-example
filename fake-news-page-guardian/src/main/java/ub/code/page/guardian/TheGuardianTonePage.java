package ub.code.page.guardian;

import ub.code.page.core.constant.PageConstants;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ub.code.core.annotations.DirectUrl;

import java.util.List;

@DirectUrl(propertyKey = PageConstants.GUARDIAN_TONE_PAGE_KEY)
public class TheGuardianTonePage extends TheGuardianBasePage {

    public final static By NEWS_TITLE_RELATIVE_XPATH =
            By.xpath(".//*[contains(@class, 'headline-text') and not(self::a)]");
    @FindBys(@FindBy(xpath = "//*[@data-id and contains(@class, 'fc-item')]"))
    public List<WebElement> availableNewsShortcuts;

    public TheGuardianTonePage(WebDriver driver) {
        super(driver);
    }

    public String getFirstTitle() {
        return availableNewsShortcuts.stream().findFirst()
                .map(webElement -> webElement.findElement(NEWS_TITLE_RELATIVE_XPATH)
                        .getText()).orElse(null);
    }

    public String getFirstTitle(String containing) {
        return availableNewsShortcuts.stream().map(webElement -> webElement.findElement(NEWS_TITLE_RELATIVE_XPATH)
                        .getText()).filter(
                                text -> ArrayUtils.contains(text.toLowerCase().split("\\W"),
                                        containing.toLowerCase()))
                .findFirst().orElse(null);
    }

}
