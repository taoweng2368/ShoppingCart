//package ui;
//
//import model.Grocery;
//import model.Store;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class GUI extends JFrame implements ActionListener {
//    private GroceryLyticsApp groceryLyticsApp;
//
//    private JPanel mainPanel;
//    private JButton grocerySelectionButton;
//    private JButton viewCartButton;
//    private JButton removeItemButton;
//    private JButton saveCartButton;
//    private JButton loadCartButton;
//    private JButton quitButton;
//
//    public GUI(GroceryLyticsApp grocerylyticsapp) {
//        super("GroceryLytics");
//        this.groceryLyticsApp = grocerylyticsapp;
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 300);
//        setLocationRelativeTo(null);
//
//        initializeComponents();
//
//        setVisible(true);
//    }
//
//    private void initializeComponents() {
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//
//        grocerySelectionButton = createButton("Grocery Selection");
//        viewCartButton = createButton("View Shopping Cart");
//        removeItemButton = createButton("Remove Items from Shopping Cart");
//        saveCartButton = createButton("Save Shopping Cart to File");
//        loadCartButton = createButton("Load Shopping Cart from File");
//        quitButton = createButton("Quit App");
//
//        addButtonsToPanel(grocerySelectionButton, viewCartButton, removeItemButton,
//                saveCartButton, loadCartButton, quitButton);
//
//        add(mainPanel);
//    }
//
//    private JButton createButton(String label) {
//        JButton button = new JButton(label);
//        button.addActionListener(this);
//        return button;
//    }
//
//    private void addButtonsToPanel(JButton... buttons) {
//        for (JButton button : buttons) {
//            button.setAlignmentX(Component.CENTER_ALIGNMENT);
//            mainPanel.add(button);
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        JButton source = (JButton) e.getSource();
//
//        if (source == grocerySelectionButton) {
//            handleGrocerySelection();
//        } else if (source == viewCartButton) {
//            handleViewCart();
//        } else if (source == removeItemButton) {
//            handleRemoveItem();
//        } else if (source == saveCartButton) {
//            handleSaveCart();
//        } else if (source == loadCartButton) {
//            handleLoadCart();
//        } else if (source == quitButton) {
//            handleQuit();
//        }
//    }
//
//    private void handleGrocerySelection() {
//        String groceryType = JOptionPane.showInputDialog("Enter grocery type (Produce/Deli/Dairy):");
//        groceryLyticsApp.selectGroceries(groceryType);
//    }
//
//    private void handleViewCart() {
//        groceryLyticsApp.viewShoppingCart();
//    }
//
//    private void handleRemoveItem() {
//        groceryLyticsApp.removeFromShoppingCart();
//    }
//
//    private void handleSaveCart() {
//        groceryLyticsApp.saveShoppingCart();
//        JOptionPane.showMessageDialog(this, "Shopping cart saved successfully.");
//    }
//
//    private void handleLoadCart() {
//        groceryLyticsApp.loadShoppingCart();
//        JOptionPane.showMessageDialog(this, "Shopping cart loaded successfully.");
//    }
//
//    private void handleQuit() {
//        groceryLyticsApp.saveShoppingCart();
//        System.exit(0);
//    }
//}
