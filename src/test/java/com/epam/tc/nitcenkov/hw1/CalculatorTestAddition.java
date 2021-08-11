package com.epam.tc.nitcenkov.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTestAddition {

    @Test(dataProvider = "testAdditionDataProvider", groups = {"addsub"})
    public void testAddition(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider(name = "testAdditionDataProvider")
    public static Object[][] testAdditionDataProvider() {
        return new Object[][] {
            {4, 6, 10},
            {10, -10, 0}
        };
    }
}
