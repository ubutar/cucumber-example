package ub.code.page.google;

import ub.code.page.core.constant.PageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ub.code.core.annotations.DirectUrl;

@DirectUrl(propertyKey = PageConstants.GOOGLE_SEARCH_PAGE_KEY)
public class GoogleStarterPage extends GoogleBasePage {

    @FindBy(xpath = "//textarea[@name='q']")
    public WebElement searchInput;

    @FindBy(xpath = "(//input[@name='btnK'][@type='submit'][@role='button'])[2]")
    public WebElement searchButton;

    public GoogleStarterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleStarterPage openDirectly() {
        return (GoogleStarterPage) super.openDirectly();
    }

    @Override
    public GoogleStarterPage handleConsenting() {
        return (GoogleStarterPage) super.handleConsenting();
    }

    public GoogleSearchResultPage searchByText(CharSequence c) {
        searchInput.sendKeys(c);
        searchButton.click();
        return new GoogleSearchResultPage(driver);
    }
}
