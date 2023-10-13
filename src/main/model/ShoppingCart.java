package model;


import java.util.ArrayList;
import java.util.List;

// Represents a shopping cart having list of groceries added to the cart
public class ShoppingCart {
    private List<Grocery> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Grocery grocery) {
        items.add(grocery);
    }

    public void removeItem(Grocery grocery) {
        items.remove(grocery);
    }

    public List<Grocery> getItems() {
        return items;
    }

}










