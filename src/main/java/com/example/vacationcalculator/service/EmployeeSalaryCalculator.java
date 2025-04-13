package com.example.vacationcalculator.service;

import com.example.vacationcalculator.model.EmployeeSalary;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeSalaryCalculator {
    double calculation(EmployeeSalary employeeSalary);
}
