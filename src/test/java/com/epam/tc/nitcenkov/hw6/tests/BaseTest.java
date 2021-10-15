package com.epam.tc.nitcenkov.hw6.tests;

import com.epam.tc.nitcenkov.hw6.driver.WebDriverSingleton;
import com.epam.tc.nitcenkov.hw6.util.Util;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(ITestContext context) {
        webDriver = WebDriverSingleton.getDriver();
        webDriver.manage().window().maximize();
        webDriver.get(Util.URL);
        context.setAttribute("driver", webDriver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        WebDriverSingleton.closeDriver();
    }
}
