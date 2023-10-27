package persistence;

import model.Grocery;
import model.ShoppingCart;
import model.Store;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

    @Test
    void testReaderNonExistentFile(){
        JsonReader reader = new JsonReader("./data/NonExistentFile.json");
        try {
            ShoppingCart cart = new ShoppingCart();
            reader.read(cart);
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }
}


