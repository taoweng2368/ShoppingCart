package model;


import java.util.ArrayList;
import java.util.List;

// Represents a shopping cart having list of groceries in the cart
public class ShoppingCart {
    private List<Grocery> items;


    // EFFECTS: create a shopping cart
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }


    // EFFECTS: add item to the items list
    public void addItem(Grocery grocery) {
        items.add(grocery);
    }

    // EFFECTS: remove item from the items list
    public void removeItem(Grocery grocery) {
        items.remove(grocery);
    }


    public List<Grocery> getItems() {
        return items;
    }

}










