package com.example.ali.myapplication;

/**
 * Created by ali on 11/23/2017.
 */

public class Salary1 implements SalaryCalculator {


    @Override
    public int Calculate(Employee salary) {
        if(salary.hasWife)
            return salary.baseSalary +15000;
            return salary.baseSalary;
    }
}
