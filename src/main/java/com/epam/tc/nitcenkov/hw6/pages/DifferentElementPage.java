package com.epam.tc.nitcenkov.hw6.pages;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementPage extends BasePage {

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

    public DifferentElementPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click water checkbox")
    public void clickWaterCheckBox() {
        waterCheckBox.click();
    }

    @Step("Click wind checkbox")
    public void clickWindCheckBox() {
        windCheckBox.click();
    }

    @Step("Click radio button")
    public void clickRadioButton() {
        radioButton.click();
    }

    @Step("Click color button")
    public void clickChooseColorButton() {
        colorChooseButton.click();
    }

    @Step("Click yellow button")
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
