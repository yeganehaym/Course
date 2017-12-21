package com.google.myapplication;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by ali on 12/14/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);

       int count= new Select()
                .from(DbAnimal.class)
                .count();

       if(count>0)
           return;

        DbAnimal myAnimal=new DbAnimal();
        myAnimal.Name="Fish";
        myAnimal.setPictrue(R.drawable.fish);
        myAnimal.save();

        myAnimal.Color="red";
        myAnimal.save();


        DbAnimal animal2=new DbAnimal()
                .setName("Bear")
                .setPictrue(R.drawable.bear)
                .setColor("Brown");

        DbAnimal animal3=new DbAnimal()
                .setName("Fish")
                .setPictrue(R.drawable.fish)
                .setColor("Blue");

        DbAnimal animal4=new DbAnimal()
                .setName("Eagle")
                .setPictrue(R.drawable.eagle)
                .setColor("white");
        DbAnimal animal5=new DbAnimal()
                .setName("Crow")
                .setPictrue(R.drawable.crow)
                .setColor("Black");
        DbAnimal animal6=new DbAnimal()
                .setName("Rabbit")
                .setPictrue(R.drawable.rabbit)
                .setColor("white");

        animal2.save();
        animal3.save();
        animal4.save();
        animal5.save();
        animal6.save();

        City city=new City();
        city.Name="Kashan";
        city.save();

        Student student=new Student();
        student.Name="ali";
        student.Age=12;
        student.City=city;
        student.save();





        DbAnimal myanimal2=DbAnimal.load(DbAnimal.class,1);
        /*

       List<Student> cities =new Select("students.name","Age")
                .from(Student.class)
                .innerJoin(City.class)
                .on("cities.Id=student.city")
                .where("cities.Name=?","kashan")
                .offset(5)

                .limit(4)
                .execute();

        DbAnimal myanimal2=DbAnimal.load(DbAnimal.class,1);
        myanimal2.delete();
        DbAnimal.delete(DbAnimal.class,3);
        List<DbAnimal> animals= new Select()
                .from(DbAnimal.class)
                .where("animal_name=? and color=?","fish","blue")
                .execute();

        int count= new Select()
                .from(DbAnimal.class)
                .where("animal_name=? and color=?","fish","blue")
                .count();*/
    }
}
