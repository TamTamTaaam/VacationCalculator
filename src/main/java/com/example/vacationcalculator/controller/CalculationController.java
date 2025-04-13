package com.example.vacationcalculator.controller;


import com.example.vacationcalculator.model.EmployeeSalary;
import com.example.vacationcalculator.service.EmployeeSalaryCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {
    private final EmployeeSalaryCalculator employeeSalaryCalculator;

    public CalculationController(EmployeeSalaryCalculator employeeSalaryCalculator) {
        this.employeeSalaryCalculator = employeeSalaryCalculator;
    }

    @GetMapping("/calculate")
    public ResponseEntity<Double> calculateVacationCompensation(@RequestBody EmployeeSalary employeeSalary) {
        double result = employeeSalaryCalculator.calculation(employeeSalary);
        return ResponseEntity.ok(result);
    }
}
