package com.epam.tc.nitcenkov.hw4.pages;

import com.epam.tc.nitcenkov.hw4.components.BenefitsComponent;
import com.epam.tc.nitcenkov.hw4.components.HeaderComponent;
import com.epam.tc.nitcenkov.hw4.components.LeftSectionComponent;
import com.epam.tc.nitcenkov.hw4.components.LoginComponent;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {

    @FindBy(className = "benefit-icon")
    List<WebElement> benefitIcon;

    @FindBy(className = "benefit-txt")
    List<WebElement> benefitText;

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

    @Step
    public List<String> getIndexPageTexts() {
        return benefitText.stream().map(WebElement::getText)
                          .collect(Collectors.toList());
    }

    @Step("Check if frame is visible ")
    public boolean isIframeVisible() {
        return iframe.isDisplayed();
    }

    @Step("Switch fo frame")
    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    @Step("Check if frame button exists")
    public boolean isFrameButtonExist() {
        return frameButton.isDisplayed();
    }

    @Step("Switch to original window")
    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}
