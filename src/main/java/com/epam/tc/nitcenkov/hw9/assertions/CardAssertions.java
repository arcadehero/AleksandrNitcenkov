package com.epam.tc.nitcenkov.hw9.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.nitcenkov.hw9.dto.CardDTO;

public class CardAssertions {

    public static void assertCardName(CardDTO actualResult, String expectedResult) {
        assertThat(actualResult).as("Card name does not match expected name").extracting("name")
                                .isEqualTo(expectedResult);
    }
}
