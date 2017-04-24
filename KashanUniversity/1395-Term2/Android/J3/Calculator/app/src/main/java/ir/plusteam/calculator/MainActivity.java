package ir.plusteam.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    EditText editText_num1;
    EditText editText_num2;

    Button button_sum;
    Button button_substract;
    Button button_multiple;
    Button button_divide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editText_num1= (EditText) findViewById(R.id.edit_num1);
        editText_num2= (EditText) findViewById(R.id.edit_num2);

        button_sum=(Button)findViewById(R.id.sum);
        button_substract=(Button)findViewById(R.id.substract);
        button_multiple=(Button)findViewById(R.id.multiple);
        button_divide=(Button)findViewById(R.id.divde);


        button_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1= Integer.parseInt(editText_num1.getText().toString());
                int num2= Integer.parseInt(editText_num2.getText().toString());
                int result=num1
                        + num2;
                Toast.makeText(MainActivity.this,"Result:"+ result,Toast.LENGTH_LONG).show();
            }
        });

        button_substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1= Integer.parseInt(editText_num1.getText().toString());
                int num2= Integer.parseInt(editText_num2.getText().toString());
                int result=num1
                        - num2;
                Toast.makeText(MainActivity.this,"Result:"+ result,Toast.LENGTH_LONG).show();
            }
        });

        button_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1= Integer.parseInt(editText_num1.getText().toString());
                int num2= Integer.parseInt(editText_num2.getText().toString());
                int result=num1
                        * num2;
                Toast.makeText(MainActivity.this,"Result:"+ result,Toast.LENGTH_LONG).show();
            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int num1= Integer.parseInt(editText_num1.getText().toString());
                    int num2= Integer.parseInt(editText_num2.getText().toString());
                    int result=num1
                            /num2;
                    Toast.makeText(MainActivity.this,"Result:"+ result,Toast.LENGTH_LONG).show();
                    throw new ArrayIndexOutOfBoundsException();


                }
                catch (NumberFormatException ex)
                {
                    Toast.makeText(MainActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();

                }
                catch (Exception ex)
                {
                    Toast.makeText(MainActivity.this,ex.getMessage()+" general",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
