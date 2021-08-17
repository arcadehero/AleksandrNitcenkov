package com.epam.tc.nitcenkov.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorTestDivision extends CalculatorGeneral {

    @Test(dataProviderClass = TestsDataProvider.class,
          dataProvider = "testDivisionByZeroDataProvider",
          groups = {"multdiv"})
    public void testDivisionByZero(double a, double b) {
        double actual = calculator.div(a, b);
        assertThat(actual).isInfinite();
    }

    @Test(dataProviderClass = TestsDataProvider.class,
          dataProvider = "testSimpleDivisionDataProvider",
          groups = {"multdiv"})
    public void testSimpleDivision(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
