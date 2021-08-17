package com.epam.tc.nitcenkov.hw2.ex2;

import com.epam.tc.nitcenkov.hw2.GeneralExerciseTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
            .findElement(By.cssSelector(".dropdown-toggle"))))
                     .click();
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.cssSelector("li:nth-child(8) > a")))).click();

        //Select checkboxes
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.cssSelector(".checkbox-row :nth-child(1)")))).click();
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.cssSelector(".checkbox-row :nth-child(3)")))).click();

        //Select radio
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.cssSelector(".label-radio:nth-of-type(4)")))).click();

        //Select in dropdown
        webDriverWait.until(ExpectedConditions
            .visibilityOf(webDriver.findElement(By.cssSelector("option:nth-child(4)")))).click();

        //Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> elements = webDriverWait.until(ExpectedConditions
            .visibilityOfAllElements(webDriver.findElements(By.cssSelector(".panel-body-list > li"))));

        List<String> actualElements = elements
            .stream()
            .map(WebElement::getText)
            .map(s -> s.replaceAll("\\d", ""))
            .map(e -> e.replaceAll(":", "").trim())
            .collect(Collectors.toList());

        List<String> expectedElements = Arrays
            .asList("Colors value changed to Yellow", "metal value changed to Selen",
                "Wind condition changed to true", "Water condition changed to true");
        softAssertions.assertThat(actualElements).isEqualTo(expectedElements);

        //Close Browser Already implemented in GeneralExerciseTest as tearDownDriver().
        softAssertions.assertAll();
    }
}
