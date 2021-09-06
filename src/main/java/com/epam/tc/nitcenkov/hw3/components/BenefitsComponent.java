package com.epam.tc.nitcenkov.hw3.components;

import com.epam.tc.nitcenkov.hw3.pages.BasePage;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BenefitsComponent extends BasePage {

    @FindBy(className = "benefit-icon")
    List<WebElement> benefitIcon;

    @FindBy(className = "benefit-txt")
    List<WebElement> benefitText;

    public BenefitsComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isIndexPageImagesDisplayed() {
        return benefitIcon.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isIndexPageTextsDisplayed() {
        return benefitText.stream().allMatch(WebElement::isDisplayed);
    }

    public List<String> getIndexPageTexts() {
        return benefitText.stream().map(WebElement::getText)
                          .collect(Collectors.toList());
    }

    public List<WebElement> getIndexPageImages() {
        return benefitIcon;
    }
}
