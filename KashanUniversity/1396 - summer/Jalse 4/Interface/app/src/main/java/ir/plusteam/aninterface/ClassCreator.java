package ir.plusteam.aninterface;

/**
 * Created by Ali on 8/23/2017.
 */

public class ClassCreator {
    public static SmsManager GetSmsManager(){
        return new MagfaSms();
    }
}
