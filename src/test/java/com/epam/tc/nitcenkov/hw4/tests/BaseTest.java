package com.epam.tc.nitcenkov.hw4.tests;

import com.epam.tc.nitcenkov.hw4.util.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        context.setAttribute("driver", webDriver);
        webDriver.get(Util.URL);
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        webDriver.quit();
    }
}
