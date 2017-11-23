package ir.plusteam.jalse7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list);
        List<Animal> animals=new Select()
                .from(Animal.class)
                .orderBy("Name asc")
                .execute();
         myAdapter=new MyAdapter(this,R.layout.row,animals);

        myAdapter.SetEvents(new MyAdapter.AdapterAction() {
            @Override
            public void RemoveItem(long id) {
                Animal animal=Animal.load(Animal.class,id);
                myAdapter.remove(animal);
                myAdapter.notifyDataSetChanged();
                animal.delete();

            }
        });
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String s="pos: " + position+"- id: "+ id;
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
