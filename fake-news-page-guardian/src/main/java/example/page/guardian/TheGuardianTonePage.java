package example.page.guardian;

import example.page.constant.PageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ub.code.annotations.DirectUrl;

import java.util.List;

@DirectUrl(propertyKey = PageConstants.GUARDIAN_TONE_PAGE_KEY)
public class TheGuardianTonePage extends TheGuardianBasePage {

    public final static By NEWS_TITLE_RELATIVE_XPATH =
            By.xpath("//*[contains(@class, 'headline-text') and not(self::a)]");
    @FindBys(@FindBy(xpath = "//*[@data-id]"))
    public List<WebElement> availableNewsShortcuts;

    public TheGuardianTonePage(WebDriver driver) {
        super(driver);
    }

    public String getFirstTitle() {
        return availableNewsShortcuts.stream().findFirst()
                .map(webElement -> webElement.findElement(NEWS_TITLE_RELATIVE_XPATH)
                        .getText()).orElse(null);
    }

}
