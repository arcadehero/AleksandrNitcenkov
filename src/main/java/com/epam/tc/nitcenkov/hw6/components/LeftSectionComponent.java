package com.epam.tc.nitcenkov.hw6.components;

import com.epam.tc.nitcenkov.hw6.pages.BasePage;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSectionComponent extends BasePage {

    @FindBy(css = "ul.sidebar-menu > li")
    List<WebElement> sideBarElements;

    @Step("Check if left section elements are displayed")
    public boolean isLeftSectionElementsDisplayed() {
        return sideBarElements.stream().allMatch(WebElement::isDisplayed);
    }

    public List<String> getLeftSectionElements() {
        return sideBarElements
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public LeftSectionComponent(WebDriver driver) {
        super(driver);
    }
}
