package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a grocery
public class Grocery implements Writable {

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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("type", type);
        json.put("price", price);
        return json;
    }

    @Override
    public void fromJson(JSONObject json) {
        this.name = json.getString("name");
        this.type = json.getString("type");
        this.price = json.getDouble("price");
    }


}
