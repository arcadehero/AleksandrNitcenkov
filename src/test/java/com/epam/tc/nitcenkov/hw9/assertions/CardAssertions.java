package com.epam.tc.nitcenkov.hw9.assertions;

import org.assertj.core.api.SoftAssertions;

public class CardAssertions {

    public static SoftAssertions softAssertions = new SoftAssertions();

    public static void assertCardName(String actualResult, String expectedResult) {
        softAssertions.assertThat(actualResult).isEqualTo(expectedResult);
        softAssertions.assertAll();
    }
}
