package com.google.myapplication;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by ali on 12/14/2017.
 */

@Table(name = "cities")
public class City  extends Model{
    @Column
    public  String Name;

}
