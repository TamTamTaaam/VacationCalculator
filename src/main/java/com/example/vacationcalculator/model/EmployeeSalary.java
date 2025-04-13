package com.example.vacationcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeSalary {
    private double averageSalary;
    private int vacationDays;
}
