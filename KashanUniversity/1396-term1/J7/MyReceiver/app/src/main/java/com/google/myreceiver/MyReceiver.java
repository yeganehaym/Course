package com.google.myreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by ali on 12/28/2017.
 */

public class MyReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {


        String title="This is a Title";
        String content="This is a Content";
        boolean myFlag=false;
        if(intent.getAction()=="myReceiver")
        {
            myFlag=true;
            title=intent.getStringExtra("X");
            content=intent.getIntExtra("Y",0) +"";
        }

        NotificationCompat.Builder notificationBuilder=
                new NotificationCompat.Builder(context);
        notificationBuilder.setTicker("This is a Ticker");
        notificationBuilder.setContentTitle(title);
        notificationBuilder.setContentText(content);
        notificationBuilder
                .setAutoCancel(true);
        notificationBuilder.setSmallIcon(android.R.drawable.ic_dialog_email);
        Resources resources=context.getResources();
        Bitmap icon = BitmapFactory.decodeResource(resources,
                R.drawable.ic_launcher_background);
        notificationBuilder.setLargeIcon(icon);

        Intent intent1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:3344"));
        PendingIntent pendingIntent=PendingIntent.getActivity(context,
                1,intent1,PendingIntent.FLAG_ONE_SHOT);
        notificationBuilder.setContentIntent(pendingIntent);


        NotificationManager notificationManager= (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(myFlag)
        {
            Notification notification = notificationBuilder.build();
            notificationManager.notify(1,notification);
        }
        else{
            int max=100;
            for (int progress=0;progress<=max;progress++)
            {
                notificationBuilder.setProgress(max,progress,false);
                Notification notification = notificationBuilder.build();
                notificationManager.notify(1,notification);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
