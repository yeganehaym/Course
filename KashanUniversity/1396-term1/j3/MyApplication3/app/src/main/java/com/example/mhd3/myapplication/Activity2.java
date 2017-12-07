package com.example.mhd3.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Mhd3 on 11/30/2017.
 */
public class Activity2 extends Activity {

    public  static  final String Extra_Int_Id="id";
    public  static  final String Extra_Long_Code="Code";
    public  static  final String Extra_String_Key="Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        int id=getIntent().getIntExtra(Extra_Int_Id,0);
        long code=getIntent().getLongExtra(Extra_Long_Code,0);
        String s=getIntent().getStringExtra(Extra_String_Key);

        TextView textView=(TextView) findViewById(R.id.txt);
        textView.setText(s + ":" + id +":"+ code);
    }
}
