package ir.plusteam.session8;

/**
 * Created by ali on 8/31/2016.
 */
public class Car {

    public String name;
    public int wheelCount;
    public String CompanyName;

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public Car setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
        return this;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public Car setCompanyName(String companyName) {
        CompanyName = companyName;
        return this;
    }
}
