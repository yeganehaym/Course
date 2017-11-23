package com.example.ali.myapplication;

import android.util.Log;

/**
 * Created by ali on 11/23/2017.
 */

public abstract class MusicPlayer {

    public void Play(){
        Log.d("music","music Started : " + GetName());
    }
    public abstract String GetName();

}
