package ir.plusteam.jalse;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by Ali on 8/21/2017.
 */

public class ProductListActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);

        listView= (ListView) findViewById(R.id.list);

        MyAdapter myAdapter=new MyAdapter(this,R.layout.row,MainActivity.products);

        listView.setAdapter(myAdapter);
    }
}
