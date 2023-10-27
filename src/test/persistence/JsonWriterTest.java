package persistence;

import model.Grocery;
import model.ShoppingCart;
import model.Store;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            ShoppingCart cart = new ShoppingCart();
            List<Store> stores = new ArrayList<>();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            writer.write(cart);
            writer.close();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyShoppingCart() {
        try {
            ShoppingCart cart = new ShoppingCart();
            List<Store> stores = new ArrayList<>();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyShoppingCart.json");
            writer.open();
            writer.write(cart);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyShoppingCart.json");
            cart = new ShoppingCart();
            stores = new ArrayList<>();
            reader.read(cart);
            assertEquals(0, cart.getItems().size());
            assertEquals(0, stores.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralShoppingCart() {
        try {
            ShoppingCart cart = new ShoppingCart();
            List<Store> stores = new ArrayList<>();
            Store store = new Store("Walmart");
            Grocery grocery = new Grocery("Banana", "Produce", 0.69);
            grocery.setStore(store);
            cart.addItem(grocery);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralShoppingCart.json");
            writer.open();
            writer.write(cart);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralShoppingCart.json");
            cart = new ShoppingCart();
            stores = new ArrayList<>();
            reader.read(cart);


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


}

