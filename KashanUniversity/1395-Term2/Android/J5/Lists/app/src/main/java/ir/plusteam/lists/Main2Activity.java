package ir.plusteam.lists;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class Main2Activity extends AppCompatActivity {

    public static  String Extra_Name="name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String value=getIntent().getStringExtra(Extra_Name);
        final TextView textView= (TextView) findViewById(R.id.mytext);
        textView.setText(value);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent=new Intent
                        (Intent.ACTION_VIEW,Uri.parse("http://www.google.com/search?q="+textView.getText()));

                Intent intent1=new Intent(Intent.,Uri.parse("tel:09123456789"));
                startActivity(intent1);

            }
        });
    }
}
