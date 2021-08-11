package com.epam.tc.nitcenkov.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTestMultiplication {

    @Test(dataProvider = "testMultiplicationDataProvider", groups = {"multidiv"})
    public void testMultiplication(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider(name = "testMultiplicationDataProvider")
    public static Object[][] testMultiplicationDataProvider() {
        return new Object[][] {
            {4, 6, 24},
            {10, -10, -100}
        };
    }
}
