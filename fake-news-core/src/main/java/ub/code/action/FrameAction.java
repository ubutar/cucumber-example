package ub.code.action;

import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface FrameAction {
    void execute(WebElement f, WebElement e);
}
