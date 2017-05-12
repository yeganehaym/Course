package ir.plusteam.noti;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Ali on 5/8/2017.
 */

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        new Thread(new Runnable() {
            @Override
            public void run() {
                NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext());
                builder.setTicker("This is Ticker");
                builder.setContentTitle("This is Title");
                builder.setContentText("This is Content Text");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setAutoCancel(false);
                builder.setProgress(100,20,false);
                Intent intent2=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"));

                PendingIntent pendingIntent=
                        PendingIntent.getActivity(getApplicationContext(),
                                12,intent2,PendingIntent.FLAG_ONE_SHOT);

                builder.setContentIntent(pendingIntent);

                notificationManager.notify(1,builder.build());

                //stopSelf();
            }
        }).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
