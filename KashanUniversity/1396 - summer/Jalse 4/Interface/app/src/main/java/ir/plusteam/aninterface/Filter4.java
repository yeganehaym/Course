package ir.plusteam.aninterface;

/**
 * Created by Ali on 8/23/2017.
 */

public class Filter4 implements Filter {
    @Override
    public int RunFilter(int baseSalary) {
        return baseSalary+3;
    }
}
