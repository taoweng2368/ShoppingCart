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
import java.util.List;
import java.util.stream.Stream;

// JSON application inspired by https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Represents a reader that reads ShoppingCart from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads shoppingcart from file and returns it;
    // throws IOException if an error occurs reading data from file
    public void read(ShoppingCart cart) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        loadShoppingCart(cart, jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: Parses the shopping cart from JSON object, For each grocery item, retrieve grocery details,
    // creates Grocery object with those details, adds them to the shopping cart.
    private void loadShoppingCart(ShoppingCart cart, JSONObject jsonObject) {
        JSONArray cartArray = jsonObject.getJSONArray("cart");
        for (Object json : cartArray) {
            JSONObject groceryObject = (JSONObject) json;
            String name = groceryObject.getString("name");
            double price = groceryObject.getDouble("price");
            String type = groceryObject.getString("type");
            JSONObject storeObject = groceryObject.getJSONObject("store");
            String storeName = storeObject.getString("name");
            Store store = new Store(storeName);
            Grocery grocery = new Grocery(name, type, price);
            grocery.setStore(store);
//
            cart.addItem(grocery);
        }
    }
}

