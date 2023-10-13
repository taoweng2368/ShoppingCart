package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    private Store walmart;
    private Grocery Banana;
    private Grocery Apple;
    private Grocery Pork;
    private Grocery Beef;
    private Grocery Milk;
    private Grocery Yogurt;

    @BeforeEach
    public void runBefore() {
        walmart = new Store("Walmart");
        Banana = new Grocery("Banana", "Produce", 0.69);
        Apple = new Grocery("Apple", "Produce", 1.20);
        Pork = new Grocery("Pork", "Deli", 5.99);
        Beef = new Grocery("Beef", "Deli", 5.99);
        Milk = new Grocery("Milk", "Dairy", 4.99);
        Yogurt = new Grocery("Yogurt","Dairy",6.99);
    }


    // Test for the constructor
    @Test
    public void testConstructor() {
        assertEquals("Walmart",walmart.getStoreName());
        assertEquals(0,walmart.getInventory().size());

    }


    // Test for adding Grocery to the store inventory
    @Test
    public void testAddGrocery() {
        walmart.addGrocery(Banana);
        assertEquals(1, walmart.getInventory().size());
    }

    // Test for adding Groceries to the store inventory
    @Test
    public void testAddGroceries() {
        walmart.addGrocery(Banana);
        assertEquals(1, walmart.getInventory().size());
        walmart.addGrocery(Apple);
        assertEquals(2, walmart.getInventory().size());
    }

    // Test for getting Groceries by type Produce
    @Test
    public void testGetGroceriesByProduceType() {
        walmart.addGrocery(Banana);
        walmart.addGrocery(Apple);
        List<Grocery> produceGroceries = walmart.getGroceriesByType("Produce");
        assertEquals(2, produceGroceries.size());


    }

    // Test for getting Groceries by type Deli
    @Test
    public void testGetGroceriesByDeliType() {
        walmart.addGrocery(Pork);
        walmart.addGrocery(Beef);
        List<Grocery> deliGroceries = walmart.getGroceriesByType("Deli");
        assertEquals(2, deliGroceries.size());
    }

    // Test for getting Groceries by type Dairy
    @Test
    public void testGetGroceriesByDairyType() {
        walmart.addGrocery(Milk);
        walmart.addGrocery(Yogurt);
        List<Grocery> dairyGroceries = walmart.getGroceriesByType("Dairy");
        assertEquals(2, dairyGroceries.size());


    }
}
