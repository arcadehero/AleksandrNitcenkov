package com.epam.tc.nitcenkov.hw7;

import static com.epam.tc.nitcenkov.hw7.Site.homePage;
import static com.epam.tc.nitcenkov.hw7.Site.login;
import static com.epam.tc.nitcenkov.hw7.Site.metalsAndColorsPage;
import static com.epam.tc.nitcenkov.hw7.Site.openHomePage;
import static com.epam.tc.nitcenkov.hw7.Site.openMetalsAndColorsPage;
import static com.epam.tc.nitcenkov.hw7.entities.User.ROMAN;
import static org.testng.Assert.assertEquals;

import com.epam.tc.nitcenkov.hw7.entities.MetalAndColors;
import com.epam.tc.nitcenkov.hw7.util.DataParser;
import org.testng.annotations.Test;

public class SiteTest implements TestInit {

    @Test(dataProvider = "metalsAndColorsData", dataProviderClass = DataParser.class)
    public void metalsAndColorsPageTest(MetalAndColors metalAndColors) {

        openHomePage();
        login(ROMAN);
        homePage.userName.is().text(ROMAN.getFullName());

        openMetalsAndColorsPage();
        metalsAndColorsPage.checkOpened();

        MetalsAndColorsPage.metalsAndColorsForm.fill(metalAndColors);
        MetalsAndColorsPage.metalsAndColorsForm.submit();

        assertEquals(MetalsAndColorsPage.getActualResult(), MetalsAndColorsPage.getExpectedResult(metalAndColors));

        Site.logout();
    }
}


