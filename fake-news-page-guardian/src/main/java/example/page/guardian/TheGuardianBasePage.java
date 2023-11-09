package example.page.guardian;

import example.page.base.BasePage;
import example.page.constant.PageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ub.code.annotations.DirectUrl;

@DirectUrl(propertyKey = PageConstants.GUARDIAN_BASE_PAGE_KEY)
public class TheGuardianBasePage extends BasePage {

    @FindBy(xpath = "//iframe[contains(@id, 'sp_message_iframe')]")
    private WebElement bottomMessageIframe;

    @FindBy(xpath = "//*[@id='notice']//button[contains(@title, 'Yes')][1]")
    private WebElement yesIamHappy;

    @FindBy(xpath = "//gu-island[@name='StickyBottomBanner']//button[contains(., 'Close')]")
    private WebElement closeSupportBanner;

    @FindBy(xpath = "//*[@id='navigation']/parent::*")
    private WebElement newsHeaderButton;

    public TheGuardianBasePage(WebDriver driver) {
        super(driver);
    }

    public TheGuardianBasePage handleConsenting() {
        super.singleClickConsent(bottomMessageIframe, yesIamHappy);
        return this;
    }

    public TheGuardianBasePage reasonNotToSupportTheGuardian() {
        closeSupportBanner.click();
        return this;
    }

    @Override
    public TheGuardianBasePage openDirectly() {
        return (TheGuardianBasePage) super.openDirectly();
    }
}
