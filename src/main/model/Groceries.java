package model;

// Represents a type of Grocery, with a name and a price.
public class Groceries {
    private double price;
    private String name;


    public Groceries(String groceryName, double groceryPrice) {
        name = groceryName;
        price = groceryPrice;
    }
}
