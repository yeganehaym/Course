package com.google.myservice;

import android.app.IntentService;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Dictionary;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gson
        //String json="{'firstName':'ali','lastName':'Rezayee'}";
        //Person p=Gson.fromJson(json,Person.class);

        btnLogin= (Button) findViewById(R.id.btnLogin);
        Intent intent=new Intent(this,Service1.class);
        //startService(intent);
        //startService(intent);
        //stopService(intent);

        Intent intentService=new Intent(this,IntentService1.class);
        startService(intentService);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginTask loginTask=new LoginTask(MainActivity.this);
                loginTask.execute();


            }
        });


        //=== Conditions without If

        Dictionary<Integer,ITest> dictionaries=new Hashtable<>();
        dictionaries.put(1, new ITest() {

            @Override
            public void Do() {
                Log.d("Dictionary","One");
            }
        });
        dictionaries.put(2,new ITest() {

            @Override
            public void Do() {
                Log.d("Dictionary","Two");
            }
        });
        dictionaries.put(3,new ITest() {

            @Override
            public void Do() {
                Log.d("Dictionary","three");
            }
        });
        dictionaries.put(4,new ITest() {

            @Override
            public void Do() {
                Log.d("Dictionary","Four");
            }
        });
        dictionaries.put(5,new ITest() {

            @Override
            public void Do() {
                Log.d("Dictionary","Five");
            }
        });


        ITest test=dictionaries.get(4);
        test.Do();
    }

    public interface  ITest{
        void  Do();

    }

    public class LoginTask extends AsyncTask<Void,Integer,String>
    {
        Context context;
        public LoginTask(Context context){
            this.context=context;
        }
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(context);
            progressDialog.setMessage("Loading Started");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setProgress(0);
            progressDialog.setMax(100);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {

            for(int i=0;i<=100;i++)
            {
                publishProgress(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
        }

        //============


        @Override
        protected void onProgressUpdate(Integer... values) {

            super.onProgressUpdate(values);
            progressDialog.setMessage("Doing Login... %"+ values[0] );
            progressDialog.setProgress(values[0]);
        }
    }
}
