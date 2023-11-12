package ub.code.page.google;

import ub.code.page.core.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ub.code.core.action.FrameAction;

public class GoogleBasePage extends BasePage {

    protected FrameAction frameSingleClick = (f, e) -> {
        e.click(); driver.switchTo().defaultContent();
    };

    @FindBy(xpath = "(//button[@id][@data-ved])[3]")
    private WebElement acceptAllCookies;

    public GoogleBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleBasePage handleConsenting() {
        this.singleClickConsent(null, acceptAllCookies);
        return this;
    }

    @Override
    public void singleClickConsent(WebElement frame, WebElement handling) {
        minorWait(handling);
        frameSingleClick.execute(frame, handling);
    }
}
