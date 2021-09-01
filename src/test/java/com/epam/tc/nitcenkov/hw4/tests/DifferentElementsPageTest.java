package com.epam.tc.nitcenkov.hw4.tests;

import com.epam.tc.nitcenkov.hw4.components.HeaderComponent;
import com.epam.tc.nitcenkov.hw4.components.LoginComponent;
import com.epam.tc.nitcenkov.hw4.listener.ScreenshotListener;
import com.epam.tc.nitcenkov.hw4.pages.DifferentElementsPage;
import com.epam.tc.nitcenkov.hw4.util.Util;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class DifferentElementsPageTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic(value = "Jdi-light site testing")
    @Feature(value = "Different elements page tests")
    @Story(value = "Checking for correct values in result box")
    public void secondExerciseTest() {

        SoftAssertions softAssertions = new SoftAssertions();

        //Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        //Perform login
        HeaderComponent headerComponent = PageFactory.initElements(webDriver, HeaderComponent.class);
        headerComponent.clickOnUserIcon();
        LoginComponent loginComponent = PageFactory.initElements(webDriver, LoginComponent.class);
        loginComponent.performLogin(Util.LOGIN, Util.PASSWORD);

        //Assert Username is logged
        softAssertions.assertThat(headerComponent.getUserName()).isEqualTo("ROMAN IOVLEV");

        //Open through the header menu Service -> Different Elements Page
        headerComponent.clickOnServiceButton();
        headerComponent.clickOnDifferentElementsButton();

        //Select checkboxes

        DifferentElementsPage differentElementsPage =
            PageFactory.initElements(webDriver, DifferentElementsPage.class);

        differentElementsPage.clickWaterCheckBox();
        differentElementsPage.clickWindCheckBox();

        //Select radio
        differentElementsPage.clickRadioButton();

        //Select in dropdown
        differentElementsPage.clickChooseColorButton();
        differentElementsPage.clickYellowButton();

        //Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<String> expectedElements = Arrays
            .asList("Colors value changed to Yellow", "metal value changed to Selen",
                "Wind condition changed to true", "Water condition changed to true");
        softAssertions.assertThat(differentElementsPage.getLogRows()).isEqualTo(expectedElements);
        softAssertions.assertAll();
    }
}
