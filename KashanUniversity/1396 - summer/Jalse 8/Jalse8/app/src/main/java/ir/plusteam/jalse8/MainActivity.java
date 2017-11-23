package ir.plusteam.jalse8;

import android.app.job.JobScheduler;
import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NetworkUtilities networkUtilities;
    TextView textView;
    List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         posts=new ArrayList<>();
        networkUtilities=new NetworkUtilities();
        boolean isConnected=networkUtilities.isNetworkAvailable(this);
        textView= (TextView) findViewById(R.id.text);
        if(!isConnected)
            return;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ReturnedData returnedData=networkUtilities.HttpGetConnection("http://jsonplaceholder.typicode.com/posts");
                    final String json=returnedData.getContent();
                    JsonReader jsonReader=new JsonReader();
                    jsonReader.GetPosts(json);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String s="";
                            for(Post post:posts)
                            {
                                s+="title:" + post.getTitle() +"\n\n\n";
                            }
                            textView.setText(s);
                        }
                    });

                    ContentValues contentValues=new ContentValues();
                    contentValues.put("userId",5);
                    contentValues.put("title","my title");
                    contentValues.put("body","my body");

                    String s=networkUtilities.PostHttpData("http://jsonplaceholder.typicode.com/posts",
                            contentValues);

                    Log.d("json",s);

                } catch (IOException e) {

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }

    public class JsonReader{
        public void GetPosts(String json) throws JSONException {
            JSONArray jsonArray=new JSONArray(json);
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                int id=jsonObject.getInt("id");
                int userId=jsonObject.getInt("userId");
                String title=jsonObject.getString("title");
                String body=jsonObject.getString("body");

                Post post=new Post()
                        .setBody(body)
                        .setTitle(title)
                        .setId(id)
                        .setUserId(userId);
                posts.add(post);

            }
        }
    }

}
