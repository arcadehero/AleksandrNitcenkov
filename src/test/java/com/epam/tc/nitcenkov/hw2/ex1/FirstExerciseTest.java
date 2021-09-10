package com.epam.tc.nitcenkov.hw2.ex1;

import com.epam.tc.nitcenkov.hw2.GeneralExerciseTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FirstExerciseTest extends GeneralExerciseTest {

    @Test
    public void firstExerciseTest() {

        SoftAssertions softAssertions = new SoftAssertions();

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

        //Assert Username is logged
        String actualUserName =
            webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("user-name")))).getText();
        softAssertions.assertThat(actualUserName).isEqualTo("ROMAN IOVLEV");

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> expectedMenuButtons = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<WebElement> menuButtons = webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.cssSelector("ul.nav > li"))));
        softAssertions.assertThat(menuButtons.size()).isEqualTo(4);
        softAssertions.assertThat(menuButtons.stream().allMatch(WebElement::isDisplayed)).isTrue();

        List<String> actualMenuButtons = menuButtons
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
        softAssertions.assertThat(actualMenuButtons).isEqualTo(expectedMenuButtons);

        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = webDriverWait.until(ExpectedConditions
            .visibilityOfAllElements(webDriver.findElements(By.className("benefit-icon"))));
        softAssertions.assertThat(images.size()).isEqualTo(4);

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = webDriverWait.until(ExpectedConditions
            .visibilityOfAllElements(webDriver.findElements(By.className("benefit-txt"))));
        List<String> actualBenefitTexts = benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedIndexPageTexts =
            Arrays.asList("To include good practices" + "\n" + "and ideas from successful" + "\n" + "EPAM project",
                "To be flexible and" + "\n" + "customizable", "To be multiplatform",
                "Already have good base" + "\n" + "(about 20 internal and" + "\n" + "some external projects),"
                    + "\n" + "wish to get more…");
        softAssertions.assertThat(actualBenefitTexts).isEqualTo(expectedIndexPageTexts);

        //Assert that there is the iframe with “Frame Button” exist

        WebElement iframe = webDriver.findElement(By.id("frame"));
        softAssertions.assertThat(iframe.isDisplayed()).isTrue();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(iframe);
        softAssertions.assertThat(webDriver.findElement(By.id("frame-button")).isDisplayed()).isTrue();

        //Switch to original window back
        webDriver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sideBarElements = webDriverWait.until(ExpectedConditions
            .visibilityOfAllElements(webDriver.findElements(By.cssSelector("ul.sidebar-menu > li"))));

        List<String> expectedSideBarElements =
            Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        List<String> actualSideBarElements = sideBarElements
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
        softAssertions.assertThat(actualSideBarElements).isEqualTo(expectedSideBarElements);

        //Close Browser - Already implemented in GeneralExerciseTest as tearDownDriver().
        softAssertions.assertAll();
    }
}
