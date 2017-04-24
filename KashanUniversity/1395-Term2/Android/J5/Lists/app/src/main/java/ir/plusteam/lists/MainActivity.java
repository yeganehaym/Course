package ir.plusteam.lists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list);

        List<Animal> animals=GetAnimals();
        AnimalsAdapter animalsAdapter=new AnimalsAdapter(this,R.layout.row,animals);

        listView.setAdapter(animalsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,""+ position,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                //List<Animal> animals1=GetAnimals();
                String value=GetAnimals().get(position).Name;
                intent.putExtra(Main2Activity.Extra_Name,value);
                startActivity(intent);
            }
        });
    }

    private List<Animal> GetAnimals(){
        Animal animal1=new Animal();
        animal1.Name="Cat";
        animal1.Image=R.drawable.cat;

        Animal animal2=new Animal();
        animal2.Name="Dog";
        animal2.Image=R.drawable.dog;

        Animal animal3=new Animal();
        animal3.Name="Scorp";
        animal3.Image=R.drawable.scorp;

        Animal animal4=new Animal();
        animal4.Name="fish";
        animal4.Image=R.drawable.fish;

        Animal animal5=new Animal();
        animal5.Name="shark";
        animal5.Image=R.drawable.shark;

        Animal animal6=new Animal();
        animal6.Name="shark";
        animal6.Image=R.drawable.shark;


        Animal animal7=new Animal();
        animal7.Name="shark";
        animal7.Image=R.drawable.shark;



        Animal animal8=new Animal();
        animal8.Name="shark";
        animal8.Image=R.drawable.shark;
        Animal animal9=new Animal();
        animal9.Name="shark";
        animal9.Image=R.drawable.shark;

        List<Animal> animals=new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);

        animals.add(animal6);
        animals.add(animal7);
        animals.add(animal8);
        animals.add(animal9);

        return animals;


    }
}
