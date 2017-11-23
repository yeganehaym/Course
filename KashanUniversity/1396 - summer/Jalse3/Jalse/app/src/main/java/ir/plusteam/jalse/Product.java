package ir.plusteam.jalse;

/**
 * Created by Ali on 8/21/2017.
 */

public class Product {

    private String Name;
    private int Price;

    public Product setName(String name){
        Name=name;
        return this;
    }

    public String getName(){
        return Name;
    }

    public int getPrice() {
        return Price;
    }

    public Product setPrice(int price) {
        Price = price;
        return this;
    }
}
