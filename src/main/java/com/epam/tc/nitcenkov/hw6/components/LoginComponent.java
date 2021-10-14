package com.epam.tc.nitcenkov.hw6.components;

import com.epam.tc.nitcenkov.hw6.pages.BasePage;
import io.qameta.allure.Step;
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

    @Step("Enter {Util.LOGIN}")
    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    @Step("Enter {Util.PASSWORD}")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Click on login button")
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Step("Perform login with {Util.LOGIN} : {Util.PASSWORD}")
    public void performLogin(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickOnLoginButton();
    }
}
