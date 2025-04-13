package com.example.vacationcalculator.service;

import com.example.vacationcalculator.model.EmployeeSalary;
import com.example.vacationcalculator.service.impl.EmployeeSalaryCalculatorImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeSalaryCalculatorImplTest {

    private final EmployeeSalaryCalculatorImpl calculator = new EmployeeSalaryCalculatorImpl();

    @Test
    void calculation_ShouldCalculateCorrectlyForNormalInput() {
        EmployeeSalary input = new EmployeeSalary(100000, 14);
        double expected = (100000 / 29.3) * 14;
        double result = calculator.calculation(input);
        assertEquals(expected, result, 0.01); // Allowing small delta for rounding
    }

    @Test
    void calculation_ShouldReturnZeroForZeroVacationDays() {
        EmployeeSalary input = new EmployeeSalary(50000, 0);
        double result = calculator.calculation(input);
        assertEquals(0.0, result);
    }

    @Test
    void calculation_ShouldHandleNegativeSalary() {
        EmployeeSalary input = new EmployeeSalary(-10000, 10);
        double expected = (-10000 / 29.3) * 10;
        double result = calculator.calculation(input);
        assertEquals(expected, result, 0.01);
    }

    @Test
    void calculation_ShouldRoundToTwoDecimalPlaces() {
        EmployeeSalary input = new EmployeeSalary(12345.67, 7);
        double unrounded = (12345.67 / 29.3) * 7;
        double result = calculator.calculation(input);
        assertNotEquals(unrounded, result); // Should be different due to rounding
        assertEquals(2949.48, result); // Expected rounded value
    }
}
