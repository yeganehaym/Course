package ir.plusteam.aninterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 8/23/2017.
 */

public class SalaryManager {

    String firstName;
    String LastName;
    int baseSalary;

    List<Filter> filters=new ArrayList<>();

    public void AddFilter(Filter filter)
    {
        filters.add(filter);
    }
    public int CalculateSalary(){

        for(Filter filter:filters)
        {
            baseSalary=filter.RunFilter(baseSalary);
        }
        return baseSalary;
    }
}
