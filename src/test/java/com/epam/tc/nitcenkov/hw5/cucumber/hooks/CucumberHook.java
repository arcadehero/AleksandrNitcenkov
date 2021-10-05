package com.epam.tc.nitcenkov.hw5.cucumber.hooks;

import com.epam.tc.nitcenkov.hw5.cucumber.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHook {

    private WebDriver webDriver;


    @Before
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        TestContext.getInstance().addTestObject("web-driver", webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        TestContext.getInstance().clean();
    }
}
