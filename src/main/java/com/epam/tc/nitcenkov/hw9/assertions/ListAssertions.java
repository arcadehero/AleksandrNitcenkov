package com.epam.tc.nitcenkov.hw9.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.nitcenkov.hw9.dto.ListDTO;

public class ListAssertions {

    public static void assertListName(ListDTO actualResult, String expectedResult) {
        assertThat(actualResult).as("List name does not match expected name").extracting("name")
                                .isEqualTo(expectedResult);
    }
}
