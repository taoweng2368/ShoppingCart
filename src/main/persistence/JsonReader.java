package persistence;

import model.Grocery;
import model.ShoppingCart;
import model.Store;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.List;

public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    public void read(ShoppingCart cart, List<Store> stores) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        loadShoppingCart(cart, jsonObject);
        loadStores(stores, jsonObject);
    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private void loadShoppingCart(ShoppingCart cart, JSONObject jsonObject) {
        JSONArray cartArray = jsonObject.getJSONArray("cart");
        for (Object json : cartArray) {
            JSONObject groceryObject = (JSONObject) json;
            String name = groceryObject.getString("name");
            double price = groceryObject.getDouble("price");
            String type = groceryObject.getString("type");
            Grocery grocery = new Grocery(name, type, price);
            cart.addItem(grocery);
        }
    }

    private void loadStores(List<Store> stores, JSONObject jsonObject) {
        JSONArray storeArray = jsonObject.getJSONArray("stores");
        for (Object json : storeArray) {
            JSONObject storeObject = (JSONObject) json;
            String name = storeObject.getString("name");
            Store store = new Store(name);
            JSONArray inventoryArray = storeObject.getJSONArray("inventory");
            for (Object inventoryJson : inventoryArray) {
                JSONObject groceryObject = (JSONObject) inventoryJson;
                String groceryName = groceryObject.getString("name");
                double price = groceryObject.getDouble("price");
                String type = groceryObject.getString("type");
                Grocery grocery = new Grocery(groceryName, type, price);
                store.addGrocery(grocery);
            }
            stores.add(store);
        }
    }
}