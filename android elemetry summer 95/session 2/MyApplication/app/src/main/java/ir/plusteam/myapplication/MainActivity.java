package ir.plusteam.myapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // tarife ashya view
    EditText editText_num1;
    EditText editText_num2;
    Button button;
    TextView textView;

    //avalin rooydad ghable ejra dar activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //morefi layout baraye activity
        setContentView(R.layout.activity_main);

        //yaftan ashya bar asase id va cast kardane anha
        editText_num1= (EditText) findViewById(R.id.editText_numOne);
        editText_num2= (EditText) findViewById(R.id.editText_numTwo);
        button=(Button)findViewById(R.id.button_sum);
        textView=(TextView)findViewById(R.id.text_result);

        //tarefe rooydade click baraye dokme ya button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //tabdile reshte be int
                int n1=Integer.parseInt(editText_num1.getText().toString());
                int n2=Integer.parseInt(editText_num2.getText().toString());

                //jame 2 addad
                int result=n1+n2;

                //namayesh hasele jam
                textView.setText(result+"");
            }
        });

    }


}
