package com.epam.tc.nitcenkov.hw2.ex1;

import com.epam.tc.nitcenkov.hw2.GeneralExerciseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FirstExerciseTest extends GeneralExerciseTest {

    @Test
    public void firstExerciseTest() {

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
        webDriverWait.until(ExpectedConditions
            .visibilityOfAllElements(
                webDriver.findElements(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']"))));
        List<WebElement> menuButtons =
            webDriver.findElements(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8'][1]/li"));
        softAssertions.assertThat(menuButtons.size()).isEqualTo(4);
        softAssertions.assertThat(menuButtons.get(0).getText()).isEqualTo("HOME");
        softAssertions.assertThat(menuButtons.get(1).getText()).isEqualTo("CONTACT FORM");
        softAssertions.assertThat(menuButtons.get(2).getText()).isEqualTo("SERVICE");
        softAssertions.assertThat(menuButtons.get(3).getText()).isEqualTo("METALS & COLORS");

        //Assert that there are 4 images on the Index Page and they are displayed
        webDriverWait.until(
            ExpectedConditions
                .visibilityOfAllElements(webDriver.findElements(By.xpath("//*[@class='benefit-icon']"))));
        List<WebElement> images = webDriver.findElements(By.xpath("//*[@class='benefit-icon']"));
        softAssertions.assertThat(images.size()).isEqualTo(4);

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        webDriverWait.until(ExpectedConditions
            .visibilityOfAllElements(webDriver.findElements(By.xpath("//span[@class='benefit-txt']"))));
        List<WebElement> benefitTexts = webDriver.findElements(By.xpath("//span[@class='benefit-txt']"));
        softAssertions.assertThat(benefitTexts.get(0).getText())
                      .isEqualTo(
                          "To include good practices" + "\n" + "and ideas from successful" + "\n" + "EPAM project");
        softAssertions.assertThat(benefitTexts.get(1).getText())
                      .isEqualTo("To be flexible and" + "\n" + "customizable");

        softAssertions.assertThat(benefitTexts.get(2).getText()).isEqualTo("To be multiplatform");
        softAssertions.assertThat(benefitTexts.get(3).getText())
                      .isEqualTo(
                          "Already have good base" + "\n" + "(about 20 internal and" + "\n" + "some external projects),"
                              + "\n" + "wish to get more…");

        //Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(webDriver.findElement(By.tagName("iframe")).isDisplayed()).isTrue();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        webDriver.switchTo().frame(iframe);
        softAssertions.assertThat(webDriver.findElement(By.xpath("//*[@class='btn btn-info']")).isDisplayed())
                      .isTrue();

        //Switch to original window back
        webDriver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sideBarElements = webDriverWait.until(ExpectedConditions
            .visibilityOfAllElements(webDriver.findElements(By.xpath("//*[@class='sidebar-menu left']/li/a"))));
        softAssertions.assertThat(sideBarElements.get(0).getText()).isEqualTo("Home");
        softAssertions.assertThat(sideBarElements.get(1).getText()).isEqualTo("Contact form");
        softAssertions.assertThat(sideBarElements.get(2).getText()).isEqualTo("Service");
        softAssertions.assertThat(sideBarElements.get(3).getText()).isEqualTo("Metals & Colors");
        softAssertions.assertThat(sideBarElements.get(4).getText()).isEqualTo("Elements packs");

        //Close Browser - Already implemented in GeneralExerciseTest as tearDownDriver().
        softAssertions.assertAll();
    }
}
