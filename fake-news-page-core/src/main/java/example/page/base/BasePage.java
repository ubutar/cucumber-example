package example.page.base;

import example.page.constant.PageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ub.code.action.FrameAction;
import ub.code.annotations.DirectUrl;

import java.time.Duration;
import java.util.Optional;

public abstract class BasePage extends SpringContextAwarePageObject {

    protected WebDriver driver;

    protected FrameAction frameSingleClick = (f, e) -> {
        driver.switchTo().frame(f); e.click(); driver.switchTo().defaultContent();
    };

    public BasePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void singleClickConsent(WebElement frame, WebElement accept) {
        WebDriverWait consentPanelWait = new WebDriverWait(driver,
                Duration.ofSeconds(Long.parseLong(getPageProperty(PageConstants.GUARDIAN_PAGE_MINOR_EVENT_TIMEOUT))));
        consentPanelWait.until(ExpectedConditions.visibilityOf(frame));
        frameSingleClick.execute(frame, accept);
    }

    public BasePage openDirectly() {
        Optional.of(this.getClass().getAnnotation(DirectUrl.class))
                .ifPresent(annotation -> driver.navigate().to(getPageProperty(annotation.propertyKey()))
        );
        return this;
    }



}
