package com.google.myapplication;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by ali on 12/14/2017.
 */

@Table(name = "students")
public class Student extends Model {

    @Column
    public  String Name;
    @Column
    public  int Age;
    @Column(name = "city")
    public  City City;

}
