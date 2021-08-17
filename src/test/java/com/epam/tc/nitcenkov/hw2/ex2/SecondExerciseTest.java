package com.epam.tc.nitcenkov.hw2.ex2;

import com.epam.tc.nitcenkov.hw2.GeneralExerciseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SecondExerciseTest extends GeneralExerciseTest {

    @Test
    public void secondExerciseTest() {

        //Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        //Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        //Perform login

        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.id("user-icon")))).click();

        webDriver.switchTo().activeElement();

        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.id("name")))).sendKeys("Roman");

        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.id("password")))).sendKeys("Jdi1234");

        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.id("login-button")))).click();

        //Open through the header menu Service -> Different Elements Page

        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver
            .findElement(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']"))))
                     .click();
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.xpath("//*[@href='different-elements.html']")))).click();

        //Select checkboxes
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.xpath("//*[text()[contains(.,'Water')]]//input")))).click();
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.xpath("//*[text()[contains(.,'Wind')]]//input")))).click();

        //Select radio
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.xpath("//*[text()[contains(.,'Selen')]]//input")))).click();

        //Select in dropdown
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.xpath("//*[@class='colors']//option[text()='Yellow']")))).click();

        //Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> elements = webDriver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        softAssertions.assertThat(elements.get(0).getText()).contains("Colors: value changed to Yellow");
        softAssertions.assertThat(elements.get(1).getText()).contains("metal: value changed to Selen");
        softAssertions.assertThat(elements.get(2).getText()).contains("Wind: condition changed to true");
        softAssertions.assertThat(elements.get(3).getText()).contains("Water: condition changed to true");

        //Close Browser Already implemented in GeneralExerciseTest as tearDownDriver().
        softAssertions.assertAll();
    }
}
