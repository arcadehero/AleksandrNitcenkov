package com.epam.tc.nitcenkov.hw5.pages;

import com.epam.tc.nitcenkov.hw5.components.AbstractComponent;
import com.epam.tc.nitcenkov.hw5.components.HeaderMenuComponent;
import com.epam.tc.nitcenkov.hw5.components.LogComponent;
import com.epam.tc.nitcenkov.hw5.components.LoginComponent;
import org.openqa.selenium.WebDriver;

public class AbstractBasePage extends AbstractComponent {

    protected HeaderMenuComponent headerMenuComponent;
    protected LoginComponent loginComponent;
    protected LogComponent logComponent;

    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html  ";

    public AbstractBasePage(WebDriver webDriver) {
        super(webDriver);
        headerMenuComponent = new HeaderMenuComponent(webDriver);
        loginComponent = new LoginComponent(webDriver);
        logComponent = new LogComponent(webDriver);
    }

    public void open() {
        webDriver.navigate().to(URL);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
