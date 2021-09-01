package com.epam.tc.nitcenkov.hw4.tests;

import com.epam.tc.nitcenkov.hw4.components.HeaderComponent;
import com.epam.tc.nitcenkov.hw4.components.LeftSectionComponent;
import com.epam.tc.nitcenkov.hw4.components.LoginComponent;
import com.epam.tc.nitcenkov.hw4.listener.ScreenshotListener;
import com.epam.tc.nitcenkov.hw4.pages.IndexPage;
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
public class IndexPageTest extends BaseTest {

    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Epic(value = "Jdi-light site testing")
    @Feature(value = "Login tests")
    @Story(value = "Valid login")
    public void firstExerciseTest() {

        //Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        //Perform login
        HeaderComponent headerComponent = PageFactory.initElements(webDriver, HeaderComponent.class);
        headerComponent.clickOnUserIcon();
        LoginComponent loginComponent = PageFactory.initElements(webDriver, LoginComponent.class);
        loginComponent.performLogin(Util.LOGIN, Util.PASSWORD);

        //Assert Username is logged
        softAssertions.assertThat(headerComponent.getUserName()).isEqualTo("ROMAN IOVLEV");

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssertions.assertThat(headerComponent.isHeaderElementsVisible()).isTrue();
        List<String> expectedMenuButtons = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssertions.assertThat(headerComponent.getHeaderElementsText()).isEqualTo(expectedMenuButtons);

        //Assert that there are 4 images on the Index Page and they are displayed
        IndexPage indexPage = PageFactory.initElements(webDriver, IndexPage.class);
        softAssertions.assertThat(indexPage.isIndexPageImagesDisplayed()).isTrue();

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssertions.assertThat(indexPage.isIndexPageTextsDisplayed()).isTrue();
        List<String> expectedIndexPageTexts = Arrays
            .asList("To include good practices" + "\n" + "and ideas from successful" + "\n" + "EPAM project",
                "To be flexible and" + "\n" + "customizable", "To be multiplatform",
                "Already have good base" + "\n" + "(about 20 internal and" + "\n" + "some external projects),"
                    + "\n" + "wish to get more…");
        softAssertions.assertThat(indexPage.getIndexPageTexts()).isEqualTo(expectedIndexPageTexts);

        //Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(indexPage.isIframeVisible()).isTrue();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToIframe();
        softAssertions.assertThat(indexPage.isFrameButtonExist()).isTrue();

        //Switch to original window back
        indexPage.switchToOriginalWindow();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        LeftSectionComponent leftSectionComponent = PageFactory.initElements(webDriver, LeftSectionComponent.class);
        softAssertions.assertThat(leftSectionComponent.isLeftSectionElementsDisplayed()).isTrue();
        List<String> expectedSideBarElements =
            Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssertions.assertThat(leftSectionComponent.getLeftSectionElements()).isEqualTo(expectedSideBarElements);
        softAssertions.assertAll();
    }
}
