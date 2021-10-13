package com.epam.tc.nitcenkov.hw9.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.nitcenkov.hw9.dto.BoardDTO;

public class BoardAssertions {

    public static void assertBoardName(BoardDTO actualResult, String expectedResult) {
        assertThat(actualResult).as("Board name does not match expected name").extracting("name")
                                .isEqualTo(expectedResult);
    }
}
