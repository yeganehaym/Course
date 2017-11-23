package com.example.ali.myapplication;

import android.util.Log;

/**
 * Created by ali on 11/23/2017.
 */

public class Magfa implements myInterface {
    @Override
    public int SendSms(String number, String message) {
        Log.d("sms","sms is sent by Magfa");
        return 324324;
    }
}
