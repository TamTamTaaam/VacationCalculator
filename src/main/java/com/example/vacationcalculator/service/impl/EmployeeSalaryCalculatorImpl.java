package com.example.vacationcalculator.service.impl;

import com.example.vacationcalculator.model.EmployeeSalary;
import com.example.vacationcalculator.service.EmployeeSalaryCalculator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class EmployeeSalaryCalculatorImpl implements EmployeeSalaryCalculator {

    private final double AVERAGE_NUMBER_OF_DAYS_IN_MONTH = 29.3;

    @Override
    public double calculation(EmployeeSalary employeeSalary) {
        double result = (employeeSalary.getAverageSalary() / AVERAGE_NUMBER_OF_DAYS_IN_MONTH) * employeeSalary.getVacationDays();
        double roundedResult = BigDecimal.valueOf(result)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        return roundedResult;
    }
}
