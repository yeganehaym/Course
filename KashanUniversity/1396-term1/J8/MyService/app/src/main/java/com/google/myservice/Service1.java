package com.google.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ali on 1/4/2018.
 */

public class Service1 extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyService","OnBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("MyService","OnCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","OnStartCommand" + startId);

        new Thread(new Runnable() {
           @Override
           public void run() {

               for(int i=0;i<50;i++)
               {
                   if(i>12)
                   {
                       //stopSelf();
                       break;
                   }
                   Log.d("MyService","Index:" + i);
                   try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d("MyService","Onrebind");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService","OnDestroy");
        super.onDestroy();
    }
}
