package ir.plusteam.example2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    EditText number1;
    EditText number2;
    Button btnSum;
    TextView txtResult;
    Button btnOpenActivity2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1=(EditText) findViewById(R.id.number1);
        number2= (EditText) findViewById(R.id.number2);
        btnSum= (Button) findViewById(R.id.btnSum);
        txtResult= (TextView) findViewById(R.id.txtResult);


        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strNumber1=number1.getText().toString();
                String strNumber2=number2.getText().toString();
                int num1=Integer.parseInt(strNumber1);
                int num2=Integer.parseInt(strNumber2);
                int result=num1+num2;
               // txtResult.setText(String.valueOf(result));
                txtResult.setText(result + "");
            }
        });

        ///================================================
        btnOpenActivity2=(Button)findViewById(R.id.btnActivity2);
        btnOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });


       /* Car car;
        car=new Car();
        car.bodyNumber=4343;
        car.maxSpeed=180;
        car.wheels=4;
        car.spareWheel=1;
        car.Brake();
        Truck truck=new Truck();
        truck.MotorNumber="e3432432";
        truck.Brake();*/




    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
