package com.epam.tc.nitcenkov.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class CalculatorGeneral {

    Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void initializeCalculator() {
        calculator = new Calculator();
    }
}
