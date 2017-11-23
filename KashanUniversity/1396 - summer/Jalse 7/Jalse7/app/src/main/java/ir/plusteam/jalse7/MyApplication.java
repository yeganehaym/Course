package ir.plusteam.jalse7;

import android.app.Application;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 9/4/2017.
 */

public class MyApplication extends com.activeandroid.app.Application {

    public static List<Animal> animals;

    @Override
    public void onCreate() {
        super.onCreate();
        animals=new ArrayList<>();
        Animal animal=new Animal();
        animal.setName("Cat").setGender(false).setCategory("Mamals");
        Animal animal1=new Animal();
        animal1.setName("Snake").setGender(true).setCategory("Reptiles");
        Animal animal2=new Animal().setName("Fish").setGender(false)
                .setCategory("Aquatics");
        Animal animal3=new Animal().setName("Eagle").setGender(true)
                .setCategory("Birds");

        Animal animal4=new Animal()
                .setName("Owl").setCategory("Birds")
                .setGender(true);
        Animal animal5=new Animal()
                .setName("Shark").setGender(true)
                .setCategory("Aquatics");

        animals.add(animal1);
        animals.add(animal);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);


        animal.Picture= (R.drawable.p1);
        animal1.Picture= (R.drawable.p2);

        animal2.Picture= (R.drawable.p3);

        animal3.Picture= (R.drawable.p4);
        animal4.Picture=(R.drawable.p2);
        animal5.Picture= (R.drawable.p3);

        List<Animal> dbAnimals=new Select().from(Animal.class).execute();
        if(dbAnimals==null|| dbAnimals.size()==0)
        {
            animal.save();
            animal1.save();
            animal2.save();
            animal3.save();
            animal4.save();
            animal5.save();

        }
    }
}
