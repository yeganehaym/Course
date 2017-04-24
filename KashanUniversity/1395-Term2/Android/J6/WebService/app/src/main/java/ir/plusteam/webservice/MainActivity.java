package ir.plusteam.webservice;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       Thread thread=new Thread(new Runnable() {
           @Override
           public void run() {



               NetworkUtilities networkUtilities=new NetworkUtilities();
               try {

                   ContentValues contentValues=new ContentValues();
                   contentValues.put("userId",3);
                   contentValues.put("title","my title");
                   contentValues.put("body","my body");

                   final String result=networkUtilities.PostHttpData(
                           "http://jsonplaceholder.typicode.com/posts",
                           contentValues);

                   Log.d("myapp2",result);

                   ReturnedData data=networkUtilities.HttpGetConnection("http://jsonplaceholder.typicode.com/posts");
                   final String json=data.getContent();

                   JSONArray jsonArray=new JSONArray(json);

                   List<Post> posts=new ArrayList<>();

                   if(jsonArray==null || jsonArray.length()==0)
                       return;

                   for (int i=0;i<jsonArray.length();i++)
                   {
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                       Post post=new Post();

                        post.UserId=jsonObject.getInt("userId");
                       post.Id=jsonObject.getInt("id");
                       post.Title=jsonObject.getString("title");
                       post.Body=jsonObject.getString("body");
                       posts.add(post);
                       //Log.d("myapp",postId +":"+userId+":"+ title +"="+ body);

                       Log.d("myapp" , "len="+posts.size());

                   }
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           TextView textView= (TextView) findViewById(R.id.txt);
                           textView.setText(result);
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
}
