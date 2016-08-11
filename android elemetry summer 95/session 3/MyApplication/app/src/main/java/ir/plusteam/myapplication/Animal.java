package ir.plusteam.myapplication;

/**
 * Created by ali on 8/11/2016.
 */
public class Animal {
    private String name;
    private float weight;
    private int feets;
    private String place;
    private String food;

    
    public String getName() {
        return this.name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public Animal setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public int getFeets() {
        return feets;
    }

    public Animal setFeets(int feets) {
        this.feets = feets;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Animal setPlace(String place) {
        this.place = place;
        return this;
    }

    public String getFood() {
        return food;
    }

    public Animal setFood(String food) {
        this.food = food;
        return this;
    }


}
