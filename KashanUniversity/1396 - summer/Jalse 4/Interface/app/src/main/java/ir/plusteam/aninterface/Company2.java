package ir.plusteam.aninterface;

import android.util.Log;

/**
 * Created by Ali on 8/23/2017.
 */

public class Company2 implements SmsManager {
    @Override
    public void SendSms(String text) {
        Log.d("sms","sms sent by Company2: "+ text);

    }

    @Override
    public int GetCharge() {
        return 0;
    }
}
