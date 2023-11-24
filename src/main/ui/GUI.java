//package ui;
//
//import model.Grocery;
//import model.ShoppingCart;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class GUI extends JFrame implements ActionListener {
//    private MainMenuController mainMenuController;
//    private GrocerySelectionMenu grocerySelectionController;
//    private SaveCartController saveCartController;
//    private LoadCartController loadCartController;
//
//
//    private JPanel mainMenu;
//
//    private ShoppingCart shoppingCart;
//    private DefaultListModel<Grocery> cartListModel;
//    private JPanel groceryPanel;
//    private JPanel groceriesPanel;
//
//
//
//    public GUI() {
//        super("Grocerlytics");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setPreferredSize(new Dimension(600, 600));
//
//        initializeMenu();
//        initializeActions();
//        initializeControllers();
//        initializeComponents();
//
//
//        mainMenu.setVisible(true);
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setResizable(false);
//    }
//
//    private void initializeMenu() {
//        mainMenu = new JPanel();
//        mainMenu.setBackground(Color.lightGray);
//        add(mainMenu);
//    }
//
//
//
//    private void initializeControllers() {
//        mainMenuController = new MainMenuController(this);
//        grocerySelectionController = new GrocerySelectionMenu(this);
//        saveCartController = new SaveCartController(this);
//        loadCartController = new LoadCartController(this);
//    }
//
//    private void initializeComponents() {
//        JLabel welcomelabel = new JLabel("Welcome to Grocerlytics!");
//        welcomelabel.setIcon(new ImageIcon("groceries.png"));
//        addLabel(welcomelabel);
//
//
//        mainMenuController.initializeMainMenuButtons();
//        grocerySelectionController.initializeGrocerySelectionButton();
//    }
//
//    private void initializeActions() {
//        mainMenuController.initializeActions();
//        grocerySelectionController.initializeActions();
//        saveCartController.initializeActions();
//        loadCartController.initializeActions();
//    }
//
////    public void initializeMenuButtons() {
////        button1 = new JButton("Search Groceries");
////        button2 = new JButton("View Cart");
////        button3 = new JButton("Save Cart");
////        button4 = new JButton("Load Cart");
////        button5 = new JButton("Exit Application");
////    }
//
////    public void addButton(JButton button, JPanel panel) {
////        button.setFont(new Font("Arial", Font.BOLD, 12));
////        button.setBackground(Color.white);
////        panel.add(button);
////        pack();
////        setLocationRelativeTo(null);
////        setVisible(true);
////        setResizable(false);
////    }
////
////    // EFFECTS: Calls the addButton method for each argument
////    public void addButtons(JButton button1, JButton button2, JButton button3, JButton button4,
////                           JButton button5) {
////
////        addButton(button1, mainMenu);
////        addButton(button2, mainMenu);
////        addButton(button3, mainMenu);
////        addButton(button4, mainMenu);
////        addButton(button5, mainMenu);
////    }
//
//
//    public void addLabel(JLabel label) {
//        label.setFont(new Font("Ariel", Font.BOLD, 30));
//        mainMenu.add(label);
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: Sets each button to their respective action
//    public void addActionToButton() {
//
////        searchGroceryAction();
////        viewCartAction();
////        saveAction();
////        loadAction();
////        exitAction();
//    }
//
//    public void addMenuButton(JButton button, JPanel panel) {
//        button.setFont(new Font("Arial", Font.BOLD, 12));
//        button.setBackground(Color.white);
//        panel.add(button);
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setResizable(false);
//    }
//
//    public ShoppingCart getShoppingCart() {
//        // Assuming you have a method to get the shopping cart
//        return shoppingCart;
//    }
//
//    public JPanel getMainMenu() {
//        return mainMenu;
//    }
//
//    public JPanel getGroceryPanel() {
//        return groceryPanel;
//    }
//
//    public DefaultListModel<Grocery> getCartListModel() {
//        return cartListModel;
//    }
//
//    // EFFECTS: Sets all panels' visibility to false except for the main menu
//    public void returnToMainMenu() {
//        mainMenu.setVisible(true);
//        groceryPanel.setVisible(false);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//
//    }
//
////    public void saveCartAction() {
////        try {
////            JsonWriter jsonWriter = new JsonWriter("shopping_cart.json");
////            jsonWriter.open();
////            jsonWriter.write(shoppingCart);
////            jsonWriter.close();
////            JOptionPane.showMessageDialog(this, "Shopping Cart saved successfully!");
////        } catch (IOException e) {
////            e.printStackTrace();
////            JOptionPane.showMessageDialog(this, "Error saving shopping cart!");
////        }
////    }
//}
