package com.epam.tc.nitcenkov.hw6.driver;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        var driverType = System.getProperty("driver.type", "local");
        var browserName = System.getProperty("browser.name", "chrome");
        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.createWebDriver(driverType, browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
