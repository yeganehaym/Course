package com.google.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int i=getIntent().getIntExtra("pos",0);
        String animalName=Animal.GetList().get(i).getName();
        TextView textView=(TextView)findViewById(R.id.text);
        textView.setText(animalName);
    }
}
