package ir.plusteam.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list);

        ArrayList<String> cars=new ArrayList<>();
        cars.add("pekan");
        cars.add("pride");
        cars.add("benz");
        cars.add("bmw");
        cars.add("renualt");

        cars.add("pekan");
        cars.add("pride");
        cars.add("benz");
        cars.add("bmw");
        cars.add("renualt");
        cars.add("pekan");
        cars.add("pride");
        cars.add("benz");
        cars.add("bmw");
        cars.add("renualt");
        cars.add("pekan");
        cars.add("pride");
        cars.add("benz");
        cars.add("bmw");
        cars.add("renualt");
        cars.add("pekan");
        cars.add("pride");
        cars.add("benz");
        cars.add("bmw");
        cars.add("renualt");
        cars.add("pekan");
        cars.add("pride");
        cars.add("benz");
        cars.add("bmw");
        cars.add("renualt");

        MyAdapter myAdapter=new MyAdapter(this,R.layout.row_item,cars);
        listView.setAdapter(myAdapter);

    }
}
