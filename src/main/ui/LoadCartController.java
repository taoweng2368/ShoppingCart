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
//public class LoadCartController {
////    private GUI gui;
//    private ShoppingCart shoppingCart;
//    private MainMenuController mainMenuController;
//    private DefaultListModel<Grocery> cartListModel;
//
//
//    public LoadCartController(GUI gui) {
//        this.gui = gui;
//        shoppingCart = new ShoppingCart();
//        cartListModel = new DefaultListModel<>();
//    }
//
//    public void initializeActions() {
//
//    }
//
//    public void loadCartAction() {
//        try {
//            JsonReader jsonReader = new JsonReader("shopping_cart.json");
//            jsonReader.read(shoppingCart);
//            cartListModel.clear();
//            for (Grocery grocery : shoppingCart.getItems()) {
//                cartListModel.addElement(grocery);
//            }
//            JOptionPane.showMessageDialog(gui, "Shopping Cart loaded successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(gui, "Error loading shopping cart!");
//        }
//    }
//
//
//}
