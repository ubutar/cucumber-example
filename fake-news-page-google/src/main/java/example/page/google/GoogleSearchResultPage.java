package example.page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GoogleSearchResultPage extends GoogleBasePage {

    public static final String singleSearchResultPreview =
            "//*[contains(@class, 'notranslate')]/preceding-sibling::h3/ancestor::a[@ping]";

    public static final By sourceNameRelativeLocator =
            By.xpath("//descendant::span[position()=2 or @class='VuuXrf']");

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
                !Objects.equals(srp.findElement(sourceNameRelativeLocator).getText(), sourceName))
                .collect(Collectors.toList());
    }

}
