package ir.plusteam.jalse7;

import android.graphics.drawable.Drawable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by Ali on 9/4/2017.
 */

public class Animal extends Model{

    @Column
    private String Name;
    @Column
    private boolean Gender;
    @Column
    private String Category;
    @Column
    public int Picture;

    public String getName() {
        return Name;
    }

    public Animal setName(String name) {
        Name = name;
        return this;
    }

    public boolean isGender() {
        return Gender;
    }

    public Animal setGender(boolean gender) {
        Gender = gender;
        return this;
    }

    public String getCategory() {
        return Category;
    }

    public Animal setCategory(String category) {
        Category = category;
        return this;
    }
}
