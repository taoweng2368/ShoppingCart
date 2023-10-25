package persistence;

import model.Grocery;
import model.ShoppingCart;
import model.Store;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;


public class JsonWriter {
    private String destination;
    private PrintWriter writer;

    public JsonWriter(String destination) {
        this.destination = destination;
    }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    public void close() {
        writer.close();
    }

    public void write(ShoppingCart cart, List<Store> stores) throws IOException {
        JSONObject jsonObject = new JSONObject();
        saveShoppingCart(cart, jsonObject);
        saveStores(stores, jsonObject);

        try (FileWriter fileWriter = new FileWriter(destination)) {
            fileWriter.write(jsonObject.toString(4));
        } catch (IOException e) {

            throw e;
        }
    }

    private void saveShoppingCart(ShoppingCart cart, JSONObject jsonObject) {
        JSONArray cartArray = new JSONArray();
        for (Grocery grocery : cart.getItems()) {
            JSONObject groceryObject = new JSONObject();
            groceryObject.put("name", grocery.getName());
            groceryObject.put("price", grocery.getPrice());
            groceryObject.put("type", grocery.getType());
            cartArray.put(groceryObject);
        }
        jsonObject.put("cart", cartArray);
    }

    private void saveStores(List<Store> stores, JSONObject jsonObject) {
        JSONArray storeArray = new JSONArray();
        for (Store store : stores) {
            JSONObject storeObject = new JSONObject();
            storeObject.put("name", store.getStoreName());

            JSONArray inventoryArray = new JSONArray();
            for (Grocery grocery : store.getInventory()) {
                JSONObject groceryObject = new JSONObject();
                groceryObject.put("name", grocery.getName());
                groceryObject.put("price", grocery.getPrice());
                groceryObject.put("type", grocery.getType());
                inventoryArray.put(groceryObject);
            }
            storeObject.put("inventory", inventoryArray);
            storeArray.put(storeObject);
        }
        jsonObject.put("stores", storeArray);
    }
}
