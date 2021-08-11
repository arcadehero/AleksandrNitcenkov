package com.epam.tc.nitcenkov.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTestDivision {

    @Test(dataProvider = "testDivisionByZeroDataProvider", groups = {"multidiv"})
    public void testDivisionByZero(double a, double b) {
        Calculator calculator = new Calculator();
        double actual = calculator.div(a, b);
        assertThat(actual).isInfinite();
    }

    @Test(dataProvider = "testSimpleDivisionDataProvider")
    public void testSimpleDivision(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
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
