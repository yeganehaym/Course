package ir.plusteam.jalse5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        int i=bundle.getInt("id",0);
        mytext= (TextView) findViewById(R.id.mytext);
        mytext.setText(i+"");
    }
}
