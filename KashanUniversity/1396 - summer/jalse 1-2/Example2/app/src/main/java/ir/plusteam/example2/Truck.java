package ir.plusteam.example2;

import android.util.Log;

/**
 * Created by Ali on 8/2/2017.
 */

public class Truck extends Car {

    String MotorNumber;

    @Override
    public void Brake() {

        Log.d("mytag","this is brake from truck");
        super.Brake();
    }
}
