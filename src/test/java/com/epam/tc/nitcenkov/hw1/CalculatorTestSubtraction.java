package com.epam.tc.nitcenkov.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTestSubtraction {

    @Test(dataProvider = "testSubtractionDataProvider", groups = {"addsub"})
    public void testSubtraction(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider(name = "testSubtractionDataProvider")
    public static Object[][] testSubtractionDataProvider() {
        return new Object[][] {
            {4, 6, -2},
            {10, 10, 0}
        };
    }
}
