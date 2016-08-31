package ir.plusteam.session8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView text=(TextView)findViewById(R.id.text);
        /* boolean a=false;
        Ali ali;
        if(a)
        {
            ali=new MD5();
        }
        else
        {
            ali=new SHA1();
        }
        text.setText(ali.Crypt(""));*/

        text.setText(MyApp.Key);
        MakeList();

    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView listView=(ListView)findViewById(R.id.list);
        CarAdapter adapter=new CarAdapter(this,android.R.layout.simple_list_item_2,cars);
        listView.setAdapter(adapter);
    }

    private void MakeList()
    {
        cars=new ArrayList<>();
        Car car1=new Car();
        car1.setName("Peykan")
                .setCompanyName("IranKhodro")
                .setWheelCount(4);

        Car car2=new Car();
        car2.setName("630i")
                .setCompanyName("BMW")
                .setWheelCount(4);

        Car car3=new Car();
        car3.setName("SG")
                .setCompanyName("Lamborghini")
                .setWheelCount(4);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }
}
