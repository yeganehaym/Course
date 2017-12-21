package com.google.myapplication;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "animals")
public class DbAnimal extends Model {

    @Column(name = "animal_name")
    public String Name;
    @Column
    public  String Color;

    public String Tozihat;

    public String getName() {
        return Name;
    }

    public DbAnimal setName(String name) {
        Name = name;
        return this;
    }

    public String getColor() {
        return Color;
    }

    @Column
    public  int Pictrue;

    public int getPictrue() {
        return Pictrue;
    }

    public DbAnimal setPictrue(int pictrue) {
        Pictrue = pictrue;
        return this;
    }

    public DbAnimal setColor(String color) {
        Color = color;
        return this;
    }
}
