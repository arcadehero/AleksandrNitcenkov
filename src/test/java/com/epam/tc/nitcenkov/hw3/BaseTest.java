package com.epam.tc.nitcenkov.hw3;

import com.epam.tc.nitcenkov.hw3.util.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(Util.URL);
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        webDriver.quit();
    }
}
