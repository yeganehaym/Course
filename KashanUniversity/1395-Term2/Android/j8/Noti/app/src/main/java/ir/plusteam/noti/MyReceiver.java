package ir.plusteam.noti;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by Ali on 5/8/2017.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("ir.plusteam.myapp.music.myaction"))
        {
            String v=intent.getStringExtra("key");
            Toast.makeText(context,"My Action is called : " + v,Toast.LENGTH_LONG).show();
            return;
        }
        String phonenumber="";
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            phonenumber=intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context,"Ringing State Number is -"+phonenumber,Toast.LENGTH_SHORT).show();
        }
        if ((state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))){
            Toast.makeText(context,"Received State", Toast.LENGTH_SHORT).show();
        }
        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
            Toast.makeText(context,"Idle State",Toast.LENGTH_SHORT).show();
        }


        NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
        builder.setTicker("You have a phone Call");
        builder.setContentTitle("Answer it");
        builder.setContentText("the number is " + phonenumber);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setAutoCancel(false);
        builder.setProgress(100,20,false);
        Intent intent2=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"));

        PendingIntent pendingIntent=
                PendingIntent.getActivity(context,
                        12,intent2,PendingIntent.FLAG_ONE_SHOT);

        builder.setContentIntent(pendingIntent);

        notificationManager.notify(1,builder.build());
    }
}
