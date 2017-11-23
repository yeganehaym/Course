package ir.plusteam.jalse5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Ali on 8/28/2017.
 */

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder=
                new NotificationCompat.Builder(context);

        Intent intent1=new Intent();
        intent1.setAction(Intent.ACTION_DIAL);
        intent1.setData(Uri.parse("tel:09123456789"));
        PendingIntent pendingIntent=PendingIntent.getActivity(context,
                1,intent1,0,null);

        builder.setTicker("This is Ticker")
                .setContentTitle("This is Title")
                .setContentText("You've got Sms")
                .setProgress(100,20,false)
                .setAutoCancel(false)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setLights(context.getResources().getColor(R.color.colorAccent),1000,3000)
        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher));


        NotificationManager notificationManager=
                (NotificationManager) context.getSystemService
                        (Context.NOTIFICATION_SERVICE);

        for(int i=0;i<=100;i++)
        {

            Notification notification=builder
                    .setProgress(100,i,false)
                    .build();
            notificationManager.notify(1,notification);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //notificationManager.cancel(1);





    }
}
