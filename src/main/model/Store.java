package model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name; //name of the store
    private List<Grocery> inventory;  // inventory of the groceries in the store

    public Store(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void addGrocery(Grocery grocery) {
        inventory.add(grocery);
    }

    public List<Grocery> getGroceriesByType(String type) {
        List<Grocery> result = new ArrayList<>();
        for (Grocery grocery : inventory) {
            if (grocery.getType().equals(type)) {
                result.add(grocery);
            }
        }
        return result;
    }

    public List<Grocery> getInventory() {
        return inventory;
    }

    public String getStoreName() {
        return name;
    }



}

