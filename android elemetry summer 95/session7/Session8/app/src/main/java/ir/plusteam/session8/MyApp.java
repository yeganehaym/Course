package ir.plusteam.session8;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.activeandroid.ActiveAndroid;

/**
 * Created by ali on 8/31/2016.
 */
public class MyApp extends com.activeandroid.app.Application {

    SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences= PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

       Read();
        Write();

    }
    public static int Font=0;
    public static String Key="";
    public static boolean Active=false;

    private void Read()
    {
       Font= sharedPreferences.getInt("font",0);
        Key=sharedPreferences.getString("key","ali");
        Active=sharedPreferences.getBoolean("active",false);
    }

    private void Write()
    {
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("font",4);
        editor.putString("key","fdfsdfffd");
        editor.putBoolean("active",true);
        editor.commit();
    }

}
