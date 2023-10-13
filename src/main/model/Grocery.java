package model;

public class Grocery {

    private String name;
    private double price;
    private String type;
    private Store store;


    // EFFECTS: Creates a new Grocery with the following arguments
    public Grocery(String name, String type, double price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    // Method to get the price at a specific store
    public double getPrice() {
        return price;
    }


    public String getType() {
        return type;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }


}
