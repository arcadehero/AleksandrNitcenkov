package com.epam.tc.nitcenkov.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorTestMultiplication extends CalculatorGeneral {

    @Test(dataProviderClass = TestsDataProvider.class,
          dataProvider = "testMultiplicationDataProvider",
          groups = {"multdiv"})
    public void testMultiplication(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
