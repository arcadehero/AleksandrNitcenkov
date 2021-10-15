package com.epam.tc.nitcenkov.hw6.tests;

import com.epam.tc.nitcenkov.hw3.pages.DifferentElementsPage;
import com.epam.tc.nitcenkov.hw6.listener.ScreenshotListener;
import com.epam.tc.nitcenkov.hw6.pages.IndexPage;
import com.epam.tc.nitcenkov.hw6.util.DataProviderClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class DifferentElementsPageTest extends BaseTest {

    @Test(dataProvider = "DataProviderForDifferentElementsPage", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.NORMAL)
    @Epic(value = "Jdi-light site testing")
    @Feature(value = "Different elements page tests")
    @Story(value = "Checking for correct values in result box")
    public void secondExerciseTest(String title, String login, String password, String userName,
                                   List<String> expectedElements) {

        SoftAssertions softAssertions = new SoftAssertions();

        //Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo(title);

        //Perform login
        IndexPage indexPage = new IndexPage(webDriver);
        indexPage.getHeaderMenuComponent().clickOnUserIcon();
        indexPage.getLoginComponent().performLogin(login, password);

        //Assert Username is logged
        softAssertions.assertThat(indexPage.getHeaderMenuComponent().getUserName()).isEqualTo(userName);

        //Open through the header menu Service -> Different Elements Page
        indexPage.getHeaderMenuComponent().clickOnServiceButton();
        indexPage.getHeaderMenuComponent().clickOnDifferentElementsButton();

        //Select checkboxes
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
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
        softAssertions.assertThat(differentElementsPage.getLogRows()).isEqualTo(expectedElements);
        softAssertions.assertAll();
    }
}
