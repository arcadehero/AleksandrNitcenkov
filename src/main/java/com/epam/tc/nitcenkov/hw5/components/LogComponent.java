package com.epam.tc.nitcenkov.hw5.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogComponent extends AbstractComponent {

    @FindBy(css = ".panel-body-list > li")
    List<WebElement> logRows;

    public LogComponent(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getLogRows() {
        return logRows.stream().map(WebElement::getText)
                      .map(s -> s.replaceAll("\\d", "")
                                 .replaceAll(":", "").trim())
                      .collect(Collectors.toList());
    }

    public boolean isLogRowDisplayed() {
        return logRows.stream().allMatch(WebElement::isDisplayed);
    }

    public void checkForTextInLogSection() {

    }
}
