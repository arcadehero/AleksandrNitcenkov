package com.epam.tc.nitcenkov.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorTestSubtraction extends CalculatorGeneral {

    @Test(dataProviderClass = TestsDataProvider.class,
          dataProvider = "testSubtractionDataProvider",
          groups = {"addsub"})
    public void testSubtraction(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
