package com.epam.tc.nitcenkov.hw6.pages;

import com.epam.tc.nitcenkov.hw6.components.BenefitsComponent;
import com.epam.tc.nitcenkov.hw6.components.HeaderMenuComponent;
import com.epam.tc.nitcenkov.hw6.components.LeftSectionComponent;
import com.epam.tc.nitcenkov.hw6.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage  {

    protected WebDriver driver;

    protected WebDriverWait webDriverWait;

    protected HeaderMenuComponent headerMenuComponent;
    protected BenefitsComponent benefitsComponent;
    protected LoginComponent loginComponent;
    protected LeftSectionComponent leftSectionComponent;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 10);
    }
}
