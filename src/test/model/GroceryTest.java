package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroceryTest {

    private Grocery Banana;
    private Grocery Pork;
    private Grocery Milk;
    private Store walmart;


    @BeforeEach
    public void runBefore() {
        Banana = new Grocery("Banana", "Produce", 0.69);
        Pork = new Grocery("Pork", "Deli", 5.99);
        Milk = new Grocery("Milk", "Dairy", 4.99);
        walmart = new Store("Walmart");

    }


    // Test the constructor
    @Test
    public void testConstructor() {
        assertEquals("Banana",Banana.getName());
        assertEquals("Produce",Banana.getType());
        assertEquals(0.69,Banana.getPrice());
        Banana.setStore(walmart);
        assertEquals(walmart,Banana.getStore());

        assertEquals("Pork",Pork.getName());
        assertEquals("Deli",Pork.getType());
        assertEquals(5.99,Pork.getPrice());
        Pork.setStore(walmart);
        assertEquals(walmart,Pork.getStore());

        assertEquals("Milk",Milk.getName());
        assertEquals("Dairy",Milk.getType());
        assertEquals(4.99,Milk.getPrice());
        Milk.setStore(walmart);
        assertEquals(walmart,Milk.getStore());


    }

}
