package com.epam.tc.nitcenkov.hw5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;

    protected AbstractComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 10L);
        PageFactory.initElements(webDriver, this);
        actions = new Actions(webDriver);
    }
}
