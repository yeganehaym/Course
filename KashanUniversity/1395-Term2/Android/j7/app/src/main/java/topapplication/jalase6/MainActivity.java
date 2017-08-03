package topapplication.jalase6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new MyAsynctask(this).execute(2,3);

        //insert id == 0& update id>0
        Student student=new Student();
        student.Name="ali";
        student.LessonName="arabi";
        student.Score=5;
        student.save();

        ///select
        List<Student> studentList=new Select().from(Student.class)
                .where("score=?",5)
                .execute();


        //delete
        new Delete().from(Student.class)
                .execute();
        //delete
        new Update(Student.class)
                .set("score=?" , 10)
                .where("score>?",7)
                .where("score<?",10)

                .execute();


        new MyAsyncTask2(this).execute();

        new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i=0;i<100;i++)
               {
                   try {
                       Thread.sleep(4000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                  MyAsyncTask2.Percent=i;
               }
                MyAsyncTask2.IAmWorking=false;
            }
        }).start();
    }
}
