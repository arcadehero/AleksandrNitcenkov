package com.epam.tc.nitcenkov.hw5.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent extends AbstractComponent {
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

    @FindBy(css = "li:nth-child(6) > a")
    WebElement userTableButton;

    public HeaderMenuComponent(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnUserIcon() {
        userIcon.click();
    }

    public void clickOnServiceButton() {
        serviceButton.click();
    }

    public void clickOnDifferentElementsButton() {
        differentElementsButton.click();
    }

    public void clickOnUserTableButton() {
        userTableButton.click();
    }

}
