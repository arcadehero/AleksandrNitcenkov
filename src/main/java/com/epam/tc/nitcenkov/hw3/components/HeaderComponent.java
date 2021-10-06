package com.epam.tc.nitcenkov.hw3.components;

import com.epam.tc.nitcenkov.hw3.pages.BasePage;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderComponent extends BasePage {

    @FindBy(id = "user-icon")
    WebElement userIcon;

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(css = "ul.nav > li")
    List<WebElement> headerMenuButtons;

    @FindBy(css = ".dropdown-toggle")
    WebElement serviceButton;

    @FindBy(css = "li:nth-child(8) > a")
    WebElement differentElementsButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        webDriverWait.until(ExpectedConditions.visibilityOf(userName));
        return userName.getText();
    }

    public void clickOnUserIcon() {
        userIcon.click();
    }

    public boolean isHeaderElementsVisible() {
        return headerMenuButtons.stream().allMatch(WebElement::isDisplayed);
    }

    public List<WebElement> getHeaderMenuButtons() {
        return headerMenuButtons;
    }

    public List<String> getHeaderElementsText() {
        return headerMenuButtons.stream()
                                .map(WebElement::getText)
                                .collect(Collectors.toList());
    }

    public void clickOnServiceButton() {
        serviceButton.click();
    }

    public void clickOnDifferentElementsButton() {
        differentElementsButton.click();
    }
}
