package com.example.ali.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number1;
    EditText number2;
    Button btnSum;
    TextView text_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1=(EditText) findViewById(R.id.number1);
        number2= (EditText) findViewById(R.id.number2);
        btnSum= (Button) findViewById(R.id.btnSum);
        text_result= (TextView) findViewById(R.id.text_result);


        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1=Integer.parseInt(number1.getText().toString());
                int num2=Integer.parseInt(number2.getText().toString());
                text_result.setText(num1+num2+"");

            }
        });

        Car peykan=new Car();
        peykan.auto=false;
        peykan.dande=4;

        Car pride=new Car();
        pride.dande=5;
        pride.auto=true;

        peykan.Start();
        pride.Start("pride");

        Birds birds=new Birds();
        Eagle eagle=new Eagle();
        birds.A();
        eagle.A();

         myInterface sms=Creator.GetSms();
         sms.SendSms("123","salam");
         Employee ali=new Employee();
         ali.name="ali";
         ali.children=3;
         ali.hasWife=true;
         ali.baseSalary=100000;
         ali.family="yeganeh";
         ali.offDays=4;
       ali.AddSalaryCalculator(new Salary1());
       ali.AddSalaryCalculator(new Salary2());
        ali.AddSalaryCalculator(new SalaryCalculator() {
            @Override
            public int Calculate(Employee salary) {
                return salary.baseSalary - (salary.offDays * 600);
            }
        });
       int result=ali.FinalSalary();
        Log.d("employee",result+"");

        ChildMusic childMusic=new ChildMusic();
        childMusic.Play();

    }
}
