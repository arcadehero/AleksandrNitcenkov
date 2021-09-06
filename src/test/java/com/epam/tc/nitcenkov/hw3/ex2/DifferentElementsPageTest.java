package com.epam.tc.nitcenkov.hw3.ex2;

import com.epam.tc.nitcenkov.hw3.BaseTest;
import com.epam.tc.nitcenkov.hw3.pages.DifferentElementsPage;
import com.epam.tc.nitcenkov.hw3.pages.IndexPage;
import com.epam.tc.nitcenkov.hw3.util.DataProviderClass;
import com.epam.tc.nitcenkov.hw3.util.Util;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    @Test(dataProvider = "DataProviderForDifferentElementsPage", dataProviderClass = DataProviderClass.class)
    public void secondExerciseTest(String title, String login, String password, String userName,
                                   List<String> expectedElements) {

        SoftAssertions softAssertions = new SoftAssertions();

        //Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo(title);

        //Perform login
        IndexPage indexPage = new IndexPage(webDriver);
        indexPage.getHeaderComponent().clickOnUserIcon();
        indexPage.getLoginComponent().performLogin(login, password);

        //Assert Username is logged
        softAssertions.assertThat(indexPage.getHeaderComponent().getUserName()).isEqualTo(userName);

        //Open through the header menu Service -> Different Elements Page
        indexPage.getHeaderComponent().clickOnServiceButton();
        indexPage.getHeaderComponent().clickOnDifferentElementsButton();

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
