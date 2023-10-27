package persistence;

import model.Grocery;
import model.ShoppingCart;
import model.Store;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.List;

// JSON application inspired by https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Represents a writer that writes JSON representation of shoppingcart to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(ShoppingCart cart) {
        JSONObject json = new JSONObject();
        JSONArray cartArray = new JSONArray();
        for (Grocery grocery : cart.getItems()) {
            cartArray.put(grocery.toJson());
        }
        json.put("cart", cartArray);

        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
