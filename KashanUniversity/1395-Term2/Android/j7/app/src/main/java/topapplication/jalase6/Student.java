package topapplication.jalase6;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Bashir Rayaneh on 5/1/2017.
 */
@Table(name = "Students")
public class Student extends Model {
    @Column(name = "name")
    public String Name;
    @Column(name = "lesson_name")
    public String LessonName;
    @Column(name = "score")
    public  int Score;

}
