package com.epam.tc.nitcenkov.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.nitcenkov.hw7.entities.User;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class Site {

    @Url("/index.html")
    public static HomePage homePage;
    @Url("/metals-colors")
    public static MetalsAndColorsPage metalsAndColorsPage;


    public static void openHomePage() {
        homePage.open();
    }

    public static void openMetalsAndColorsPage() {
        metalsAndColorsPage.open();
    }

    public static void login(User user) {
        homePage.login(user);
    }

    public static void logout() {
        metalsAndColorsPage.userIcon.click();
        metalsAndColorsPage.logOut.click();
    }
}
