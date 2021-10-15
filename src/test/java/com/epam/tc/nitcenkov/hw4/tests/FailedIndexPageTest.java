package com.epam.tc.nitcenkov.hw4.tests;

import com.epam.tc.nitcenkov.hw4.listener.ScreenshotListener;
import com.epam.tc.nitcenkov.hw4.pages.IndexPage;
import com.epam.tc.nitcenkov.hw4.util.DataProviderClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class FailedIndexPageTest extends BaseTest {

    private static final int EXPECTED_IMAGES_NUMBER = 4;

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "DataProviderForIndexPageTest")
    @Severity(SeverityLevel.BLOCKER)
    @Epic(value = "Jdi-light site testing")
    @Feature(value = "Login tests")
    @Story(value = "Valid login")
    public void firstExerciseTest(String title, String login, String password, String userName,
                                  List<String> expectedMenuButtons,
                                  List<String> expectedIndexPageTexts, List<String> expectedSideBarElements) {

        SoftAssertions softAssertions = new SoftAssertions();

        //Assert Browser title
        Assertions.fail("For example");
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo(title);

        //Perform login
        IndexPage indexPage = new IndexPage(webDriver);
        indexPage.getHeaderComponent().clickOnUserIcon();
        indexPage.getLoginComponent().performLogin(login, password);

        //Assert Username is logged
        softAssertions.assertThat(indexPage.getHeaderComponent().getUserName()).isEqualTo(userName);

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssertions.assertThat(indexPage.getHeaderComponent().getHeaderMenuButtons())
                      .hasSize(expectedMenuButtons.size());
        softAssertions.assertThat(indexPage.getHeaderComponent().isHeaderElementsVisible()).isTrue();
        softAssertions.assertThat(indexPage.getHeaderComponent().getHeaderElementsText())
                      .isEqualTo(expectedMenuButtons);

        //Assert that there are 4 images on the Index Page and they are displayed
        softAssertions.assertThat(indexPage.getBenefitsComponent().isIndexPageImagesDisplayed()).isTrue();
        softAssertions.assertThat(indexPage.getBenefitsComponent().getIndexPageImages())
                      .hasSize(EXPECTED_IMAGES_NUMBER);

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssertions.assertThat(indexPage.getBenefitsComponent().isIndexPageTextsDisplayed()).isTrue();
        softAssertions.assertThat(indexPage.getBenefitsComponent().getIndexPageTexts())
                      .hasSize(expectedIndexPageTexts.size());
        softAssertions.assertThat(indexPage.getBenefitsComponent().getIndexPageTexts())
                      .isEqualTo(expectedIndexPageTexts);

        //Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(indexPage.isIframeVisible()).isTrue();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToIframe();
        softAssertions.assertThat(indexPage.isFrameButtonExist()).isTrue();

        //Switch to original window back
        indexPage.switchToOriginalWindow();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssertions.assertThat(indexPage.getLeftSectionComponent().isLeftSectionElementsDisplayed()).isTrue();
        softAssertions.assertThat(indexPage.getLeftSectionComponent().getLeftSectionElements())
                      .isEqualTo(expectedSideBarElements);
        softAssertions.assertAll();
    }
}
