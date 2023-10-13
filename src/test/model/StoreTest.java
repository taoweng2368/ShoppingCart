package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    private Store store;
    private Grocery Banana;
    private Grocery Apple;
    private Grocery Pork;
    private Grocery Beef;
    private Grocery Milk;
    private Grocery Yogurt;

    @BeforeEach
    public void runBefore() {
        store = new Store("Walmart");
        Banana = new Grocery("Banana", "Produce", 0.69);
        Apple = new Grocery("Apple", "Produce", 1.20);
        Pork = new Grocery("Pork", "Deli", 5.99);
        Beef = new Grocery("Beef", "Deli", 5.99);
        Milk = new Grocery("Milk", "Dairy", 4.99);
        Yogurt = new Grocery("Yogurt","Dairy",6.99);
    }

    // Test for adding Grocery to the store inventory
    @Test
    public void testAddGrocery() {
        store.addGrocery(Banana);
        assertEquals(1, store.getInventory().size());
    }

    // Test for adding Groceries to the store inventory
    @Test
    public void testAddGroceries() {
        store.addGrocery(Banana);
        assertEquals(1, store.getInventory().size());
        store.addGrocery(Apple);
        assertEquals(2, store.getInventory().size());
    }

    // Test for getting Groceries by type Produce
    @Test
    public void testGetGroceriesByProduceType() {
        store.addGrocery(Banana);
        store.addGrocery(Apple);
        List<Grocery> produceGroceries = store.getGroceriesByType("Produce");
        assertEquals(2, produceGroceries.size());


    }

    // Test for getting Groceries by type Deli
    @Test
    public void testGetGroceriesByDeliType() {
        store.addGrocery(Pork);
        store.addGrocery(Beef);
        List<Grocery> deliGroceries = store.getGroceriesByType("Deli");
        assertEquals(2, deliGroceries.size());
    }

    // Test for getting Groceries by type Dairy
    @Test
    public void testGetGroceriesByDairyType() {
        store.addGrocery(Milk);
        store.addGrocery(Yogurt);
        List<Grocery> dairyGroceries = store.getGroceriesByType("Dairy");
        assertEquals(2, dairyGroceries.size());


    }
}
