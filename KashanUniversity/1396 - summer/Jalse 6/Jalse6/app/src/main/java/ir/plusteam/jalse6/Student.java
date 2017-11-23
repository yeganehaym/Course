package ir.plusteam.jalse6;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Ali on 8/30/2017.
 */

@Table(name = "students")
public class Student extends Model {

    @Column(name = "fname")
    String firstname;
    @Column
    String lastName;
    @Column
    int age;
    @Column(name = "city",notNull = true,length = 50,index = true)
    String city;
    @Column
    String country;

}
