package com.epam.tc.nitcenkov.hw4.pages;

import com.epam.tc.nitcenkov.hw4.components.BenefitsComponent;
import com.epam.tc.nitcenkov.hw4.components.HeaderComponent;
import com.epam.tc.nitcenkov.hw4.components.LeftSectionComponent;
import com.epam.tc.nitcenkov.hw4.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    protected HeaderComponent headerComponent;
    protected BenefitsComponent benefitsComponent;
    protected LoginComponent loginComponent;
    protected LeftSectionComponent leftSectionComponent;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 10);
    }
}
