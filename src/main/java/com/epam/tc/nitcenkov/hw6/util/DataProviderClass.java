package com.epam.tc.nitcenkov.hw6.util;

import java.util.Arrays;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "DataProviderForIndexPageTest")
    public static Object[][] getDataProviderForIndexPageTest() {

        return new Object[][] {
            {
                Util.TITLE,
                Util.LOGIN,
                Util.PASSWORD,
                Util.USER_NAME,
                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"),
                Arrays.asList("To include good practices" + "\n" + "and ideas from successful" + "\n" + "EPAM project",
                    "To be flexible and" + "\n" + "customizable", "To be multiplatform",
                    "Already have good base" + "\n" + "(about 20 internal and" + "\n" + "some external projects),"
                        + "\n" + "wish to get more…"),
                Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs")
            }
        };
    }

    @DataProvider(name = "DataProviderForDifferentElementsPage")
    public static Object[][] getDataProviderForDifferentElementsPage() {
        return new Object[][] {
            {
                Util.TITLE,
                Util.LOGIN,
                Util.PASSWORD,
                Util.USER_NAME,
                Arrays
                    .asList("Colors value changed to Yellow", "metal value changed to Selen",
                    "Wind condition changed to true", "Water condition changed to true")
            }
        };
    }
}
