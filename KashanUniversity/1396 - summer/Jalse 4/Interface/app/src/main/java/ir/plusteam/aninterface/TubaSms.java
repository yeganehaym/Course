package ir.plusteam.aninterface;

import android.util.Log;

/**
 * Created by Ali on 8/23/2017.
 */

public class TubaSms implements SmsManager {
    @Override
    public void SendSms(String text) {
        Log.d("sms", "sms sent by Tuba: " + text);
    }

    @Override
    public int GetCharge() {
        return 0;
    }

    public int GetDelivery(int code){
        return 0;

    }
}
