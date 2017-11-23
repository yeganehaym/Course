package ir.plusteam.jalse6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText lname;
    Button btnInsert;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= (EditText) findViewById(R.id.name);
        lname= (EditText) findViewById(R.id.lname);
        btnInsert= (Button) findViewById(R.id.btnInsert);
        textView= (TextView) findViewById(R.id.records);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student=new Student();
                student.firstname=name.getText().toString();
                student.lastName=lname.getText().toString();
                student.age=10;
                student.city="tehran";
                student.country="iran";

                student.save();

                List<Student> students=new Select()
                                            .from(Student.class)
                                            .execute();

                String records="";
                for (Student s:students)
                {
                    records+= +s.getId() +":"+s.firstname + " "+ s.lastName+ "is "+ s.age + "years old" + "\n";

                }
                textView.setText(records);

                Student student1=Student.load(Student.class,4);

                if(student1!=null)
                    student1.delete();

                new Delete().from(Student.class)
                        .where("Id>=? and Id<=?",6,8).execute();
                new Update(Student.class)
                        .set("age=?",30)
                        .where("age=27")
                        .execute();
                Student student2=Student.load(Student.class,10);
                if(student2!=null)
                {
                    student2.age=35;
                    student2.save();
                }

            }
        });


    }
}
