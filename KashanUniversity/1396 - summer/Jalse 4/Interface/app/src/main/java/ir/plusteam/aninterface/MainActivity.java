package ir.plusteam.aninterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmsManager smsManager=new TubaSms();
        smsManager.SendSms("Hi");

        SalaryManager salaryManager=new SalaryManager();
        salaryManager.firstName="ali";
        salaryManager.LastName="yeganeh";
        salaryManager.baseSalary=10;

        salaryManager.AddFilter(new Filter() {
            @Override
            public int RunFilter(int baseSalary) {
                return  baseSalary +5;

            }
        });

        salaryManager.AddFilter(new Filter() {
            @Override
            public int RunFilter(int baseSalary) {
                return baseSalary-5;

            }
        });
        salaryManager.AddFilter(new Filter4());
        salaryManager.AddFilter(new Filter() {
            @Override
            public int RunFilter(int baseSalary) {
                return baseSalary +8;
            }
        });
        int p=salaryManager.CalculateSalary();
        Log.d("sms",salaryManager.firstName + " "+ salaryManager.LastName + " :"+ p);

        TextView textView=new TextView(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
