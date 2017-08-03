package topapplication.jalase6;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Bashir Rayaneh on 5/1/2017.
 */

public class MyAsynctask extends AsyncTask<Integer,Integer,Boolean> {

Context context;
    ProgressDialog progressBar;

    public MyAsynctask(Context context)
    {
        this.context=context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar=ProgressDialog.show(context,"Loading...","Please Wait");
        /*progressBar.setMax(100);
        progressBar.setIndeterminate(true);
        progressBar.setProgress(0);
        progressBar.show();*/
    }

    @Override
    protected Boolean doInBackground(Integer... params) {

       for(int i=0;i<100;i++)
       {
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           publishProgress(i);
       }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        progressBar.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int percent=values[0];
        progressBar.setMessage(percent + "%");
    }
}
