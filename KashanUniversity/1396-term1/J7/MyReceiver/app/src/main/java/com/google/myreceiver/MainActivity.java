package com.google.myreceiver;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btnCancel;
    Button btnShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MySingleton mySingleton=MySingleton.GetInstance();
        String test=mySingleton.Test();
        Log.d("tag",test);

        setContentView(R.layout.activity_main);
        btnCancel= (Button) findViewById(R.id.btnCancel);
        btnShare= (Button) findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/*");
                intent.putExtra(Intent.EXTRA_TEXT,"sharedText");
                startActivity(intent);
            }
        });
     btn= (Button) findViewById(R.id.btn);
     btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent("myReceiver");
             intent.putExtra("X","Ali");
             intent.putExtra("Y",120);
             sendBroadcast(intent);
         }
     });

     btnCancel.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {


             NotificationManager notificationManager=
                     (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
             notificationManager.cancel(1);
         }
     });
    }
}
