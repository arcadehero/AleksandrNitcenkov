package com.epam.tc.nitcenkov.hw3.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends BasePage {

    @FindBy(css = ".checkbox-row :nth-child(1)")
    WebElement waterCheckBox;

    @FindBy(css = ".checkbox-row :nth-child(3)")
    WebElement windCheckBox;

    @FindBy(css = ".label-radio:nth-of-type(4)")
    WebElement radioButton;

    @FindBy(css = "select.uui-form-element")
    WebElement colorChooseButton;

    @FindBy(css = "option:nth-child(4)")
    WebElement yellowButton;

    @FindBy(css = ".panel-body-list > li")
    List<WebElement> logRows;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWaterCheckBox() {
        waterCheckBox.click();
    }

    public void clickWindCheckBox() {
        windCheckBox.click();
    }

    public void clickRadioButton() {
        radioButton.click();
    }

    public void clickChooseColorButton() {
        colorChooseButton.click();
    }

    public void clickYellowButton() {
        yellowButton.click();
    }

    public List<String> getLogRows() {
        return logRows.stream().map(WebElement::getText)
                      .map(s -> s.replaceAll("\\d", "")
                                 .replaceAll(":", "").trim())
                      .collect(Collectors.toList());
    }
}
