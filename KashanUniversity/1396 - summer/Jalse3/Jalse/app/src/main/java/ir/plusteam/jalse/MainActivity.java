package ir.plusteam.jalse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtPrice;
    Button btnSubmit;
    static ArrayList<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      txtName=(EditText)findViewById(R.id.txtName);
    txtPrice= (EditText) findViewById(R.id.txtPrice);
    btnSubmit= (Button) findViewById(R.id.btnSubmit);
    products=new ArrayList<>();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txtName.getText().toString();
                int price=Integer.parseInt(txtPrice.getText().toString());
                Product product=new Product();
                product.setName(name).setPrice(price);
                products.add(product);
                Toast
                        .makeText(MainActivity.this,"Product Has Added",Toast.LENGTH_LONG)
                        .show();

                /*for(Product p:products)
                {
                    Log.d("mytag",p.getName() + ":"+ p.getPrice());
                }*/
                for(int i=0;i<products.size();i++)
                {
                    Product p=products.get(i);
                    Log.d("mytag",p.getName() + ":"+ p.getPrice());
                }
                Log.d("mytag","=========");
            }
        });
    }
}
