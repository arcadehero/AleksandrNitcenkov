package com.epam.tc.nitcenkov.hw3.components;

import com.epam.tc.nitcenkov.hw3.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends BasePage {

    @FindBy(id = "name")
    WebElement loginField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void performLogin(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickOnLoginButton();
    }
}
