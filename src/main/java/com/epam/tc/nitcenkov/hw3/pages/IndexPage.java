package com.epam.tc.nitcenkov.hw3.pages;

import com.epam.tc.nitcenkov.hw3.components.BenefitsComponent;
import com.epam.tc.nitcenkov.hw3.components.HeaderComponent;
import com.epam.tc.nitcenkov.hw3.components.LeftSectionComponent;
import com.epam.tc.nitcenkov.hw3.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {



    @FindBy(id = "frame")
    WebElement iframe;

    @FindBy(id = "frame-button")
    WebElement frameButton;

    public IndexPage(WebDriver webdriver1) {
        super(webdriver1);
        PageFactory.initElements(webdriver1, this);
        headerComponent = new HeaderComponent(webdriver1);
        benefitsComponent = new BenefitsComponent(webdriver1);
        loginComponent = new LoginComponent(webdriver1);
        leftSectionComponent = new LeftSectionComponent(webdriver1);
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    public LeftSectionComponent getLeftSectionComponent() {
        return leftSectionComponent;
    }

    public BenefitsComponent getBenefitsComponent() {
        return benefitsComponent;
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public boolean isIframeVisible() {
        return iframe.isDisplayed();
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public boolean isFrameButtonExist() {
        return frameButton.isDisplayed();
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}
