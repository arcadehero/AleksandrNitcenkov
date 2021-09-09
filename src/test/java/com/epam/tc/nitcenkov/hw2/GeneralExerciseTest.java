package com.epam.tc.nitcenkov.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class GeneralExerciseTest {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        webDriver.quit();
    }
}
