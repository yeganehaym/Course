package com.google.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 12/7/2017.
 */

public class Animal {

    private String Name;
    private  String Color;

    public String getName() {
        return Name;
    }

    public Animal setName(String name) {
        Name = name;
        return this;
    }

    public String getColor() {
        return Color;
    }

    public Animal setColor(String color) {
        Color = color;
        return this;
    }

    public static List<Animal> GetList(){
        List<Animal> animals=new ArrayList<>();
        Animal animal1=new Animal();
        animal1.setName("Lion")
                .setColor("brown");
        Animal animal2=new Animal();
        animal2.setName("Deer")
                .setColor("brown");
        Animal animal3=new Animal();
        animal3.setName("Duck")
                .setColor("brown");
        Animal animal4=new Animal();
        animal4.setName("Dog")
                .setColor("Black");
        Animal animal5=new Animal();
        animal5.setName("Cat")
                .setColor("Yellow");

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);
        animal3.setName("Fish")
                .setColor("Blue");
        return  animals;
    }
}
