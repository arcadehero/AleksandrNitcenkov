package com.epam.tc.nitcenkov.hw1;

import org.testng.annotations.DataProvider;

public class TestsDataProvider {

    @DataProvider(name = "testAdditionDataProvider")
    public static Object[][] testAdditionDataProvider() {
        return new Object[][] {
            {4, 6, 10},
            {10, -10, 0}
        };
    }

    @DataProvider(name = "testSubtractionDataProvider")
    public static Object[][] testSubtractionDataProvider() {
        return new Object[][] {
            {4, 6, -2},
            {10, 10, 0}
        };
    }

    @DataProvider(name = "testMultiplicationDataProvider")
    public static Object[][] testMultiplicationDataProvider() {
        return new Object[][] {
            {4, 6, 24},
            {10, -10, -100}
        };
    }

    @DataProvider(name = "testSimpleDivisionDataProvider")
    public static Object[][] testSimpleDivisionDataProvider() {
        return new Object[][] {
            {0, 1, 0},
            {10, 2, 5}
        };
    }

    @DataProvider(name = "testDivisionByZeroDataProvider")
    public static Object[][] testDivisionByZeroDataProvider() {
        return new Object[][] {
            {1, 0}
        };
    }
}
