package com.epam.tc.nitcenkov.hw4.pages;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {

    SoftAssertions softAssertions = new SoftAssertions();
    private static final int EXPECTED_IMAGES_NUMBER = 4;
    private static final int EXPECTED_TEXTS_NUMBER = 4;

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
    }

    @Step("Check if index page images are displayed")
    public boolean isIndexPageImagesDisplayed() {
        softAssertions.assertThat(benefitIcon.size()).isEqualTo(EXPECTED_IMAGES_NUMBER);
        for (WebElement element : benefitIcon
        ) {
            if (element.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    @Step("Check if index page texts are displayed")
    public boolean isIndexPageTextsDisplayed() {
        softAssertions.assertThat(benefitIcon.size()).isEqualTo(EXPECTED_TEXTS_NUMBER);
        for (WebElement element : benefitText
        ) {
            if (element.isDisplayed()) {
                return true;
            }
        }
        return false;
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
