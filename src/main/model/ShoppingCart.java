package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a shopping cart having list of groceries in the cart
public class ShoppingCart implements Writable {
    private List<Grocery> items;
    private List<Store> stores;


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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        JSONArray itemsArray = new JSONArray();

        for (Grocery grocery : items) {
            itemsArray.put(grocery.toJson());
        }
        json.put("items", itemsArray);

        return json;
    }

    public List<Store> getStores() {
        return stores;
    }
}










