package com.example.ali.myapplication;

/**
 * Created by ali on 11/23/2017.
 */

public class Salary3 implements SalaryCalculator {
    @Override
    public int Calculate(Employee salary) {
        return salary.baseSalary - (salary.offDays * 400);
    }
}
