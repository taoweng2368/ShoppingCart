package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroceryTest {

    private Grocery Banana;
    private Grocery Pork;
    private Grocery Milk;


    @BeforeEach
    public void runBefore() {
        Banana = new Grocery("Banana", "Produce", 0.69);
        Pork = new Grocery("Pork", "Deli", 5.99);
        Milk = new Grocery("Milk", "Dairy", 4.99);

    }


    // Test the constructor
    @Test
    public void testConstructor() {
        assertEquals("Banana",Banana.getName());
        assertEquals("Produce",Banana.getType());
        assertEquals(0.69,Banana.getPrice());

        assertEquals("Pork",Pork.getName());
        assertEquals("Deli",Pork.getType());
        assertEquals(5.99,Pork.getPrice());

        assertEquals("Milk",Milk.getName());
        assertEquals("Dairy",Milk.getType());
        assertEquals(4.99,Milk.getPrice());
    }

}
