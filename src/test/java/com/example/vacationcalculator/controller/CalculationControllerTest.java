package com.example.vacationcalculator.controller;

import com.example.vacationcalculator.model.EmployeeSalary;
import com.example.vacationcalculator.service.EmployeeSalaryCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculationControllerTest {

    @Mock
    private EmployeeSalaryCalculator employeeSalaryCalculator;

    @InjectMocks
    private CalculationController calculationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculateVacationCompensation_ShouldReturnCorrectValue() {
        EmployeeSalary input = new EmployeeSalary(100000, 14);
        double expectedResult = 47781.57;
        when(employeeSalaryCalculator.calculation(input)).thenReturn(expectedResult);
        ResponseEntity<Double> response = calculationController.calculateVacationCompensation(input);
        assertEquals(expectedResult, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        verify(employeeSalaryCalculator, times(1)).calculation(input);
    }

    @Test
    void calculateVacationCompensation_ShouldHandleZeroVacationDays() {
        EmployeeSalary input = new EmployeeSalary(50000, 0);
        double expectedResult = 0.0;
        when(employeeSalaryCalculator.calculation(input)).thenReturn(expectedResult);
        ResponseEntity<Double> response = calculationController.calculateVacationCompensation(input);
        assertEquals(expectedResult, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void calculateVacationCompensation_ShouldHandleNegativeSalary() {
        EmployeeSalary input = new EmployeeSalary(-10000, 10);
        double expectedResult = -3412.97;
        when(employeeSalaryCalculator.calculation(input)).thenReturn(expectedResult);
        ResponseEntity<Double> response = calculationController.calculateVacationCompensation(input);
        assertEquals(expectedResult, response.getBody());
    }
}
