package com.google.webservice;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.Permission;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int result = ContextCompat.
                checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        if(result!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.RECORD_AUDIO,Manifest.permission.ADD_VOICEMAIL
            },12);
        }

        list= (ListView) findViewById(R.id.list);
      Thread thread=new Thread(new Runnable() {
          @Override
          public void run() {
              NetworkUtilities networkUtilities=
                      new NetworkUtilities();
              try {

                  ReturnedData data=networkUtilities
                          .HttpGetConnection("https://jsonplaceholder.typicode.com/posts");
                  Log.d("webservice",data.getResponseCode() + "" );
                  Log.d("webservice",data.getContent());

                  JSONArray jsonArray =new JSONArray(data.getContent());
                  List<Post> posts=new ArrayList<>(jsonArray.length());
                  List<String> strings=new ArrayList<>(jsonArray.length());
                  for (int i=0;i<jsonArray.length();i++)
                  {
                      JSONObject jsonObject=jsonArray.getJSONObject(i);
                      int id=jsonObject.getInt("id");
                      int userId=jsonObject.getInt("userId");
                      String title=jsonObject.getString("title");
                      String body=jsonObject.getString("body");

                      Post post=new Post();
                      post.setBody(body);
                      post.setId(id);
                      post.setUserId(userId);
                      post.setTitle(title);
                      posts.add(post);
                      strings.add(title);


                  }

                  Log.d("webservice",posts.size()+"");
                  final ArrayAdapter<String> adapter=
                          new ArrayAdapter<String>(MainActivity.this,
                                  android.R.layout.simple_list_item_1,
                                  android.R.id.text1,strings);
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          list.setAdapter(adapter);
                      }
                  });

              } catch (IOException e) {
                  e.printStackTrace();
              } catch (JSONException e) {
                  e.printStackTrace();
              }
          }
      });

      thread.start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==12)
        {
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                //do something
            }
        }
    }
}
