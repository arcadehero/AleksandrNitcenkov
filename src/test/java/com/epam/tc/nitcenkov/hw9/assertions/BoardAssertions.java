package com.epam.tc.nitcenkov.hw9.assertions;

import org.assertj.core.api.SoftAssertions;

public class BoardAssertions {

    static SoftAssertions softAssertions = new SoftAssertions();

    public static void assertBoardName(String actualResult, String expectedResult) {
        softAssertions.assertThat(actualResult).isEqualTo(expectedResult);
        softAssertions.assertAll();
    }

    public static void assertBoardUpdated(String actualResult, String expectedResult) {
        softAssertions.assertThat(actualResult).isEqualTo(expectedResult);
        softAssertions.assertAll();
    }
}
