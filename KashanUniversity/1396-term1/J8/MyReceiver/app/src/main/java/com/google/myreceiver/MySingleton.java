package com.google.myreceiver;

import android.util.Log;

/**
 * Created by ali on 12/28/2017.
 */

public class MySingleton {

    public  String Test(){
        return "Test";
    }

    private static MySingleton object;

    public static   MySingleton GetInstance(){

        if(object==null)
        {
            Log.d("tag","created");
            object=new MySingleton();
            return  object;
        }
        Log.d("tag","used");
        return  object;
    }
}
