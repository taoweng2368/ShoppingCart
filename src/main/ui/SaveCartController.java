//package ui;
//
//import model.Grocery;
//import model.ShoppingCart;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//
//public class SaveCartController {
//    private GUI gui;
//    private ShoppingCart shoppingCart;
//    private MainMenuController mainMenuController;
//
//
//    public SaveCartController(GUI gui) {
//        this.gui = gui;
//        shoppingCart = new ShoppingCart();
//    }
//
//    public void initializeActions() {
//    }
//
//    public void saveCartAction() {
//        try {
//            JsonWriter jsonWriter = new JsonWriter("shopping_cart.json");
//            jsonWriter.open();
//            jsonWriter.write(shoppingCart);
//            jsonWriter.close();
//            JOptionPane.showMessageDialog(gui, "Shopping Cart saved successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(gui, "Error saving shopping cart!");
//        }
//    }
//}
