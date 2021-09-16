package com.epam.tc.nitcenkov.hw5.pages;

import com.epam.tc.nitcenkov.hw5.components.LogComponent;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementPage extends AbstractBasePage {

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

    public DifferentElementPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LogComponent getLogComponent() {
        return logComponent;
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
}
