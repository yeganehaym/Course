package com.example.ali.myapplication;

import java.util.ArrayList;

/**
 * Created by ali on 11/23/2017.
 */

public class Employee {

    int children;
    boolean hasWife;
    int baseSalary;
    int offDays;
    String name;
    String family;
    ArrayList<SalaryCalculator> list=new ArrayList<>();

    public void  AddSalaryCalculator(SalaryCalculator salaryCalculator)
    {
        list.add(salaryCalculator);
    }
    public int FinalSalary()
    {
        for (SalaryCalculator item:list)
        {
            baseSalary=item.Calculate(this);
        }
        return baseSalary;
    }
}
