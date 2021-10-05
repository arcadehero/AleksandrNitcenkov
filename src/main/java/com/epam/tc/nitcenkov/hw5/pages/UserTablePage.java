package com.epam.tc.nitcenkov.hw5.pages;

import com.epam.tc.nitcenkov.hw5.components.LogComponent;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractBasePage {

    @FindBy(id = "ivan")
    WebElement checkboxIvan;

    @FindBy(css = " td:nth-child(1)")
    List<WebElement> sixNumberType;

    @FindBy(css = "td a[href]")
    List<WebElement> sixUsernames;

    @FindBy(css = "div.user-descr")
    List<WebElement> sixDescriptionTexts;

    @FindBy(css = "div.user-descr input")
    List<WebElement> sixCheckboxes;

    @FindBy(css = "#user-table")
    WebElement userTable;

    @FindBy(css = "tr:nth-child(1) > td:nth-child(2) > select > option")
    List<WebElement> dropdownForRoman;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    public LogComponent getLogComponent() {
        return logComponent;
    }

    public void clickOnCheckboxIvan() {
        checkboxIvan.click();
    }

    public boolean isSixNumberTypeDisplayed() {
        return sixNumberType.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isSixUsernamesDisplayed() {
        return sixUsernames.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isSixDescriptionTextsUnderImagesDisplayed() {
        return sixDescriptionTexts.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isSixCheckboxesDisplayed() {
        return sixCheckboxes.stream().allMatch(WebElement::isDisplayed);
    }

    public String getUserTable() {
        return userTable.getText().replaceAll("\n", " ").trim();
    }

    public List<String> getDropdownForRoman() {
        return dropdownForRoman.stream()
                               .map(WebElement::getText)
                               .collect(Collectors.toList());
    }
}
