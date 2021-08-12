package com.epam.tc.nitcenkov.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorTestAddition extends CalculatorGeneral {

    @Test(dataProviderClass = TestsDataProvider.class,
          dataProvider = "testAdditionDataProvider",
          groups = {"addsub"})
    public void testAddition(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
