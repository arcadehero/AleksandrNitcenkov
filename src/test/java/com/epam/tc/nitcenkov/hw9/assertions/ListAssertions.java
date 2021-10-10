package com.epam.tc.nitcenkov.hw9.assertions;

import org.assertj.core.api.SoftAssertions;

public class ListAssertions {

    public static SoftAssertions softAssertions = new SoftAssertions();

    public static void assertListName(String actualResult, String expectedResult) {
        softAssertions.assertThat(actualResult).isEqualTo(expectedResult);
        softAssertions.assertAll();
    }

    public static void assertListUpdated(String actualResult, String expectedResult) {
        softAssertions.assertThat(actualResult).isEqualTo(expectedResult);
        softAssertions.assertAll();
    }
}
