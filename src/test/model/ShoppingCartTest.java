package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    private ShoppingCart cart1;
    private Store walmart;
    private Store tnt;
    private Grocery Banana;
    private Grocery Apple;
    private Grocery Pork;
    private Grocery Milk;


    @BeforeEach
    public void runBefore() {
        cart1 = new ShoppingCart();
        Banana = new Grocery("Banana","Produce",0.69);
        Apple = new Grocery("Apple","Produce",1.20);
        Pork = new Grocery("Pork","Deli",5.99);
        Milk = new Grocery("Milk","Dairy",4.99);
        walmart = new Store("Walmart");
        tnt = new Store("T&T");
    }

    // Test for the constructor
    @Test
    public void testConstructor() {
        assertEquals(0, cart1.getItems().size());
    }


    // Test for adding one item
    @Test
    public void testAddItem() {
        cart1.addItem(Banana);
        assertEquals(1,cart1.getItems().size());
    }

    // Test for adding multiple items
    @Test
    public void testAddItems() {
        cart1.addItem(Banana);
        assertEquals(1,cart1.getItems().size());
        cart1.addItem(Apple);
        assertEquals(2,cart1.getItems().size());
    }

    // Test for removing an item
    @Test
    public void testRemoveItem() {
        cart1.addItem(Banana);
        cart1.removeItem(Banana);
        assertEquals(0,cart1.getItems().size());
    }

    // Test for removing multiple items
    @Test
    public void testRemoveItems() {
        cart1.addItem(Banana);
        cart1.addItem(Apple);
        cart1.removeItem(Banana);
        assertEquals(1,cart1.getItems().size());
        cart1.removeItem(Apple);
        assertEquals(0,cart1.getItems().size());
    }

}