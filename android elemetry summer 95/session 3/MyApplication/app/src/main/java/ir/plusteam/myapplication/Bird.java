package ir.plusteam.myapplication;

/**
 * Created by ali on 8/11/2016.
 */
public class Bird extends Animal {

    private String ColorOfWings;

    public String getColorOfWings() {
        return ColorOfWings;
    }

    public Bird setColorOfWings(String colorOfWings) {
        ColorOfWings = colorOfWings;
        return this;
    }
}
