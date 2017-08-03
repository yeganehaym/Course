package topapplication.jalase6;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Bashir Rayaneh on 5/1/2017.
 */

public class MyAsyncTask2 extends AsyncTask<Void,Integer,Void> {

    public  static boolean IAmWorking=true;
    public static  int Percent=0;


    Context context;
    ProgressDialog progressBar;

    public MyAsyncTask2(Context context)
    {
        this.context=context;
        IAmWorking=true;
        Percent=0;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar=ProgressDialog.show(context,"Loading...","Please Wait");

    }

    @Override
    protected Void doInBackground(Void... params) {
        while (IAmWorking)
        {
            publishProgress(Percent);
        }
        return null;

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressBar.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setMessage(Percent +"%");
    }
}
