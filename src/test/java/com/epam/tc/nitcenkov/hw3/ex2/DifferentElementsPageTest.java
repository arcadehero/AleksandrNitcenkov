package com.epam.tc.nitcenkov.hw3.ex2;

import com.epam.tc.nitcenkov.hw3.BaseTest;
import com.epam.tc.nitcenkov.hw3.pages.DifferentElementsPage;
import com.epam.tc.nitcenkov.hw3.pages.components.HeaderComponent;
import com.epam.tc.nitcenkov.hw3.pages.components.LoginComponent;
import com.epam.tc.nitcenkov.hw3.util.Util;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    @Test
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
