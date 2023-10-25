package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a Store having an inventory of stocked products
public class Store implements Writable {
    private String name; //name of the store
    private List<Grocery> inventory;  // inventory of the groceries in the store


    // EFFECTS: creates a store with the following arguments
    public Store(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add grocery to the store inventory
    public void addGrocery(Grocery grocery) {
        inventory.add(grocery);
    }

    // MODIFIES: this
    // EFFECTS: return a list of all groceries in the specific type from the store's inventory
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);

        JSONArray inventoryArray = new JSONArray();
        for (Grocery grocery : inventory) {
            inventoryArray.put(grocery.toJson());
        }
        json.put("inventory", inventoryArray);

        return json;
    }

    @Override
    public void fromJson(JSONObject json) {
        this.name = json.getString("name");

        JSONArray inventoryArray = json.getJSONArray("inventory");
        inventory.clear();
        for (Object inventoryJson : inventoryArray) {
            JSONObject groceryJson = (JSONObject) inventoryJson;
            Grocery grocery = new Grocery("", "", 0);
            grocery.fromJson(groceryJson);
            inventory.add(grocery);
        }
    }

}

