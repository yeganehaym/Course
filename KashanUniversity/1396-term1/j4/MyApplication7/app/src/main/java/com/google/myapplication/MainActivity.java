package com.google.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView= (ListView) findViewById(R.id.list);
        AnimalAdapter animalAdapter=
                new AnimalAdapter(this,R.layout.item_row,Animal.GetList());
        listView.setAdapter(animalAdapter);

        animalAdapter.SetOnEventsListener(new AnimalAdapter.Events() {
            @Override
            public void OnClickImage(int pos) {
                Toast.makeText(MainActivity.this,Animal.GetList().get(pos).getName() , Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),
                        Main2Activity.class);
                intent.putExtra("pos",position);
                intent.putExtra("id",id);
                Toast.makeText(MainActivity.this,"" +
                        position,Toast.LENGTH_LONG).show();


                startActivity(intent);
            }
        });

    }
}
