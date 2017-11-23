package ir.plusteam.jalse7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

public class Main3Activity extends AppCompatActivity {
ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView= (ImageView) findViewById(R.id.image);
        String path=Environment.getExternalStorageDirectory() +"/110.jpg";

        File file=new File(Environment.getExternalStorageDirectory(),"/kashanbartar/images/products/3.jpg");

        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        imageView.setImageBitmap(bitmap);
    }
}
