package ub.code.page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ub.code.model.GoogleSearchResult;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GoogleSearchResultPage extends GoogleBasePage {

    public static final String singleSearchResultPreview =
            "//*[@data-snc]";

    public static final By resultUrlRelativeLocator =
            By.xpath(".//*[@data-snhf='0']//a");
    public static final By resultTitleRelativeLocator =
            By.xpath(".//*[@data-snhf='0']//*[self::h3 or self::h2]");

    public static final By resultSourceRelativeLocator =
            By.xpath(".//*[@data-snhf='0']//*[contains(@class, 'notranslate')]//*[contains(@class, 'VuuXrf')]");

    @FindBys(@FindBy(xpath = singleSearchResultPreview))
    private List<WebElement> searchResultPreviews;

    public GoogleSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public GoogleSearchResultPage waitForSearchResults() {
        minorWait(ExpectedConditions.visibilityOfElementLocated(By.xpath(singleSearchResultPreview)));
        return this;
    }

    public List<WebElement> exceptSource(String sourceName) {
        return searchResultPreviews.stream().filter(srp ->
                        !Objects.equals(srp.findElement(resultTitleRelativeLocator).getText(), sourceName))
                .collect(Collectors.toList());
    }

    public List<GoogleSearchResult> getSearchResults() {
        return searchResultPreviews.stream().map(result -> {
                    GoogleSearchResult gsr = new GoogleSearchResult(
                            result.findElement(resultUrlRelativeLocator).getAttribute("href"),
                            result.findElement(resultTitleRelativeLocator).getText());
                    gsr.setSource(result.findElement(resultSourceRelativeLocator).getText());
                    return gsr;
                }
        ).collect(Collectors.toList());
    }

}
