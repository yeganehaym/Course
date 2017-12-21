package com.google.webservice;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    Button btnAlert;
    Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnAlert= (Button) findViewById(R.id.btnAlert);
btnDialog= (Button) findViewById(R.id.btnDialog);

btnDialog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final Dialog dialog=new Dialog(Main2Activity.this);
        dialog.setTitle("Titleeee");
         LayoutInflater layoutInflater=
                 (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
         View v=layoutInflater.inflate(R.layout._dialog,null);
         Button btn= (Button) v.findViewById(R.id.cancel);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 dialog.dismiss();
             }
         });
        dialog.setContentView(v);
        dialog.show();
    }
});
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Main2Activity.this)
                .setIcon(android.R.drawable.ic_delete)
                .setTitle("Are You sure?")
                        .setMessage("Your File will be Deleted Forever")
                        .setPositiveButton("Yesss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Main2Activity.this,
                                        "Yesss",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Noooo",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Main2Activity.this,
                                        "Noooo",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("Nothing",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Main2Activity.this,
                                        "Nothing",Toast.LENGTH_SHORT).show();
                            }
                        });

                /*
                .setNegativeButton("Noooo",null)
                */

                alertDialog.show();





            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetworkUtilities networkUtilities=
                        new NetworkUtilities();

                String title="title";
                String body="this is body";
                int userId=34;

                ContentValues contentValues=new ContentValues();
                contentValues.put("title",title);
                contentValues.put("body",body);
                contentValues.put("userId",userId);
                try {
                    //baraye kar kardan content type gheyre faal shavad
                    String s=networkUtilities.PostHttpData("https://jsonplaceholder.typicode.com/posts",contentValues);
                    Log.d("webservice",s);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
