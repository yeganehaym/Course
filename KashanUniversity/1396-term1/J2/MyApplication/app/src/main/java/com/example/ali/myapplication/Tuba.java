package com.example.ali.myapplication;

import android.util.Log;

/**
 * Created by ali on 11/23/2017.
 */

public class Tuba implements myInterface {

    @Override
    public int SendSms(String number, String message) {
        Log.d("sms","sms is ent by tuba");
        return 1255;
    }

    public void  A(){

    }
}
