package ir.plusteam.salavatshomar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ParentActivity {

    Button button_counter;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_counter= (Button) findViewById(R.id.button_counter);
        button_counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i++;
                button_counter.setText(i+"");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        i=0;
    }
}
