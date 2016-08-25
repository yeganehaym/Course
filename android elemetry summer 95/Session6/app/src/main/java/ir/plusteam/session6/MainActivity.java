package ir.plusteam.session6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview=(ListView) findViewById(R.id.list);

        Animal snake=new Animal();
        snake.Name="snake";
        snake.Image=R.drawable.snake;
        snake.Type=AnimalType.Reptile;

        Animal eagle=new Animal();
        eagle.Name="eagle";
        eagle.Image=R.drawable.eagle;
        eagle.Type=AnimalType.Birds;

        Animal cat=new Animal();
        cat.Name="cat";
        cat.Image=R.drawable.cat;
        cat.Type=AnimalType.Mamal;

        List<Animal> animals=new ArrayList<>();
        animals.add(snake);
        animals.add(eagle);
        animals.add(cat);

        AnimalAdapter animalAdapter=
                new AnimalAdapter(this,R.layout.animal_layout,animals);
        listview.setAdapter(animalAdapter);

    }
}
