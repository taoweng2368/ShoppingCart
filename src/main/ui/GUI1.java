package ui;

import model.Grocery;
import model.ShoppingCart;
import model.Store;

import java.util.List;
import java.util.ArrayList;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI1 extends JFrame implements ActionListener {

    private static final String SHOPPINGCART_FILE = "./data/shopping_cart.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private ShoppingCart cart;
    private Store walmart;
    private Store tnt;
    private Store superstore;

    private Store selectedstore;



    private JPanel mainMenu;
    private JButton selectGroceriesbutton;
    private JButton viewCartButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton exitButton;
    private JLabel welcomeLabel;
    private JLabel mainScreenImage;


    private JPanel grocerySelectionMenu;
    private JButton addButton;

    private JPanel cartMenu;
    private JLabel items;
    private JButton removeButton;

    private JButton returnToMainMenuButton;

    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;


    @SuppressWarnings("methodlength")
    public GUI1() {
        super("Grocerlytics");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        setMenu();
        makeGrocerySelectionMenu();
        makeShoppingCartMenu();

        cart = new ShoppingCart();
        walmart = new Store("Walmart");
        tnt = new Store("T&T");
        superstore = new Store("Superstore");
        jsonWriter = new JsonWriter(SHOPPINGCART_FILE);
        jsonReader = new JsonReader(SHOPPINGCART_FILE);

        initWalmart();
        initTnt();
        initSuperstore();

        welcomeLabel = new JLabel("Welcome to Grocerlytics");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        mainScreenImage = new JLabel();
        mainScreenImage.setIcon(new ImageIcon("groceries.png"));
        mainScreenImage.setMinimumSize(new Dimension(20, 20));

        mainMenu.add(welcomeLabel);
        mainMenu.add(mainScreenImage);

        setButtons();
        addButtons();
        addActionToButtons();

        mainMenu.setVisible(true);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: this
    // EFFECTS: initialize Groceries in Walmart
    private void initWalmart() {

        walmart.addGrocery(new Grocery("Banana", "Produce", 0.69));
        walmart.addGrocery(new Grocery("Apple", "Produce", 1.50));
        walmart.addGrocery(new Grocery("Cabbage", "Produce", 1.49));
        walmart.addGrocery(new Grocery("Pork", "Deli", 5.99));
        walmart.addGrocery(new Grocery("Beef", "Deli", 5.99));
        walmart.addGrocery(new Grocery("Chicken", "Deli", 5.99));
        walmart.addGrocery(new Grocery("Milk", "Dairy", 5.49));
        walmart.addGrocery(new Grocery("Eggs", "Dairy", 11.49));
        walmart.addGrocery(new Grocery("Yogurt", "Dairy", 6.59));
    }

    // MODIFIES: this
    // EFFECTS: initialize Groceries in Tnt
    private void initTnt() {
        tnt.addGrocery(new Grocery("Banana", "Produce", 0.59));
        tnt.addGrocery(new Grocery("Apple", "Produce", 1.20));
        tnt.addGrocery(new Grocery("Cabbage", "Produce", 1.59));
    }

    // MODIFIES: this
    // EFFECTS: initialize Groceries in Superstore
    private void initSuperstore() {
        superstore.addGrocery(new Grocery("Pork", "Deli", 4.99));
        superstore.addGrocery(new Grocery("Beef", "Deli", 5.99));
        superstore.addGrocery(new Grocery("Chicken", "Deli", 6.99));
    }

    public void setMenu() {
        mainMenu = new JPanel();
        mainMenu.setBackground(Color.lightGray);
        add(mainMenu);
        items = new JLabel();

    }

    public void setButtons() {
        // For the main menu
        selectGroceriesbutton = new JButton("Select Groceries");
        viewCartButton = new JButton("View Cart");
        saveButton = new JButton("Save Cart");
        loadButton = new JButton("Load Cart");
        exitButton = new JButton("Exit App");

        // For the grocery selection menu
        addButton = new JButton("Add Grocery");

        // For the cart menu
        removeButton = new JButton("Remove Grocery");

        // In general
        returnToMainMenuButton = new JButton("Back");

    }

    // EFFECTS: add the button to main menu
    public void addButton(JButton button, JPanel panel) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(Color.white);
        panel.add(button);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // EFFECTS: calls the addbutton method on each argument
    public void addButtons() {

        addButton(selectGroceriesbutton, mainMenu);
        addButton(viewCartButton, mainMenu);
        addButton(saveButton, mainMenu);
        addButton(loadButton, mainMenu);
        addButton(exitButton, mainMenu);

        addButton(addButton, grocerySelectionMenu);

        addButton(removeButton, cartMenu);

        addButton(returnToMainMenuButton, grocerySelectionMenu);
        addButton(returnToMainMenuButton, cartMenu);
    }

    public void addActionToButtons() {

        selectGroceriesbutton.addActionListener(this);
        selectGroceriesbutton.setActionCommand("Select Groceries");
        viewCartButton.addActionListener(this);
        viewCartButton.setActionCommand("View Cart");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("Save Cart");
        loadButton.addActionListener(this);
        loadButton.setActionCommand("Load Cart");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Exit App");

        addButton.addActionListener(this);
        addButton.setActionCommand("Add Grocery");

        removeButton.addActionListener(this);
        removeButton.setActionCommand("Remove Grocery");

        returnToMainMenuButton.addActionListener(this);
        returnToMainMenuButton.setActionCommand("Return");
    }

    // EFFECTS: calls the given methods when a certain button is clicked on
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("Select Groceries")) {
            initializeGrocerySelectionMenu();
        } else if (ae.getActionCommand().equals("View Cart")) {
            initializeCartMenu();
        } else if (ae.getActionCommand().equals("Save Cart")) {
            saveCart();
        } else if (ae.getActionCommand().equals("Load Cart")) {
            loadCart();
        } else if (ae.getActionCommand().equals("Exit App")) {
            System.exit(0);
        } else if (ae.getActionCommand().equals("Add Grocery")) {
            addGroceryToCart();
        } else if (ae.getActionCommand().equals("Remove Grocery")) {
            removeGroceryFromCart();
        } else if (ae.getActionCommand().equals("Return")) {
            returnToMainMenu();
        }
    }

    // MODIFIES: this
// EFFECTS: Creates the shopping cart panel
    private void makeShoppingCartMenu() {
        cartMenu = new JPanel(new BorderLayout());
        DefaultListModel<Grocery> cartListModel = new DefaultListModel<>();
        JList<Grocery> cartList = new JList<>(cartListModel);
        JScrollPane scrollPane = new JScrollPane(cartList);

        cartMenu.add(new JLabel("Shopping Cart"), BorderLayout.NORTH);
        cartMenu.add(scrollPane, BorderLayout.CENTER);

        JButton removeButton = new JButton("Remove Grocery");
        cartMenu.add(removeButton, BorderLayout.SOUTH);

        removeButton.addActionListener(e -> {
            List<Grocery> cartItems = cart.getItems();
            if (cartItems.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cart is empty.");
                return;
            }

            int selectedIndex = cartList.getSelectedIndex();
            if (selectedIndex != -1) {
                Grocery selectedGrocery = cartItems.get(selectedIndex);
                cart.removeItem(selectedGrocery);
                cartListModel.removeElement(selectedGrocery);
                JOptionPane.showMessageDialog(this, selectedGrocery.getName() + " removed from cart!");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a grocery to remove.");
            }
        });
    }

    // EFFECTS: Add the shopping cart menu to the screen
    public void initializeCartMenu() {
        add(cartMenu);
        cartMenu.setVisible(true);
        mainMenu.setVisible(false);
        grocerySelectionMenu.setVisible(false);

    }

    // MODIFIES: this
// EFFECTS: Prompts the user to choose a grocery from the cart and removes it
    private void removeGroceryFromCart() {
        List<Grocery> cartItems = cart.getItems();
        if (cartItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cart is empty.");
            return;
        }

        JComboBox<Grocery> groceryComboBox = new JComboBox<>(cartItems.toArray(new Grocery[0]));
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Choose Grocery to Remove:"));
        panel.add(groceryComboBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Remove Grocery",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            Grocery selectedGrocery = (Grocery) groceryComboBox.getSelectedItem();
            cart.removeItem(selectedGrocery);
            JOptionPane.showMessageDialog(this, selectedGrocery.getName() + " removed from cart!");
        }
    }


    // MODIFIES: this
// EFFECTS: Creates a panel that displays the option for the user to choose their groceries
    private void makeGrocerySelectionMenu() {
        grocerySelectionMenu = new JPanel(new GridLayout(4, 2));

        grocerySelectionMenu.add(new JLabel("Choose Grocery Type:"));
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Produce", "Deli", "Dairy"});
        grocerySelectionMenu.add(typeComboBox);

        grocerySelectionMenu.add(new JLabel("Choose Store:"));
        JComboBox<String> storeComboBox = new JComboBox<>(new String[]{"Walmart", "T&T", "Superstore"});
        grocerySelectionMenu.add(storeComboBox);

        JButton showAvailableGroceriesButton = new JButton("Show Available Groceries");
        grocerySelectionMenu.add(showAvailableGroceriesButton);

        showAvailableGroceriesButton.addActionListener(e -> {
            String selectedType = (String) typeComboBox.getSelectedItem();
            String selectedStoreName = (String) storeComboBox.getSelectedItem();

            // Fetch the selected store based on the name
            selectedstore = getStoreByName(selectedStoreName);

            // Fetch and display available groceries based on selected type and store
            List<Grocery> availableGroceries = getAvailableGroceries(selectedType, selectedstore);

            // Display available groceries in a new dialog
            StringBuilder message = new StringBuilder("Available Groceries:\n");
            for (Grocery grocery : availableGroceries) {
                message.append(grocery.getName()).append(" - $").append(grocery.getPrice()).append("\n");
            }
            JOptionPane.showMessageDialog(this, message.toString());
        });
    }

    // MODIFIES: this
    // EFFECTS: Add the grocery selection menu to the screen
    public void initializeGrocerySelectionMenu() {
        add(grocerySelectionMenu);
        grocerySelectionMenu.setVisible(true);
        mainMenu.setVisible(false);
        cartMenu.setVisible(false);

    }

    // MODIFIES: this
    // EFFECTS: Prompts the user to choose a grocery type, store, and then add a grocery to the shopping cart
    private void addGroceryToCart() {
        String[] groceryTypes = {"Produce", "Deli", "Dairy"}; // Add more types as needed
        String[] storeNames = {"Walmart", "T&T", "Superstore"}; // Add more stores as needed

        JComboBox<String> typeComboBox = new JComboBox<>(groceryTypes);
        JComboBox<String> storeComboBox = new JComboBox<>(storeNames);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Choose Grocery Type:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Choose Store:"));
        panel.add(storeComboBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Select Grocery and Store",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String selectedType = (String) typeComboBox.getSelectedItem();
            String selectedStoreName = (String) storeComboBox.getSelectedItem();

            // Fetch the selected store based on the name
            selectedstore = getStoreByName(selectedStoreName);

            // Fetch and display available groceries based on selected type and store
            List<Grocery> availableGroceries = getAvailableGroceries(selectedType, selectedstore);

            JComboBox<Grocery> groceryComboBox = new JComboBox<>(availableGroceries.toArray(new Grocery[0]));
            panel.removeAll();
            panel.add(new JLabel("Choose Grocery:"));
            panel.add(groceryComboBox);

            result = JOptionPane.showConfirmDialog(null, panel, "Select Grocery",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                Grocery selectedGrocery = (Grocery) groceryComboBox.getSelectedItem();
                cart.addItem(selectedGrocery);
                JOptionPane.showMessageDialog(this, selectedGrocery.getName() + " added to cart!");
            }
        }
    }





    // SAVE AND LOAD METHODS:

    // MODIFIES: this
    // EFFECTS: save the cart file if it exists
    private void saveCart() {
        try {
            jsonWriter.open();
            jsonWriter.write(cart);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Shopping Cart saved successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + SHOPPINGCART_FILE);

        }
    }

    // MODIFIES: this
    // EFFECTS: load the cart file if it exists
    // otherwise, error
    private void loadCart() {
        try {
            jsonReader.read(cart);
            JOptionPane.showMessageDialog(this, "Shopping Cart loaded successfully!");
        } catch (IOException e) {
            items.setText("No items added");
        }
    }

    // Inside your GUI1 class:

    // EFFECTS: Returns the Store object with the given name, or null if not found
    private Store getStoreByName(String storeName) {
        switch (storeName) {
            case "Walmart":
                return walmart;
            case "T&T":
                return tnt;
            case "Superstore":
                return superstore;
            default:
                return null;
        }
    }

    // EFFECTS: Returns a list of available groceries based on the selected type and store
    private List<Grocery> getAvailableGroceries(String selectedType, Store selectedstore) {
        List<Grocery> availableGroceries = new ArrayList<>();

        if (selectedstore != null) {
            List<Grocery> groceriesInStore = selectedstore.getGroceriesByType(selectedType);
            for (Grocery grocery : groceriesInStore) {
                // Check if the grocery is not already in the cart
                if (!cart.getItems().contains(grocery)) {
                    availableGroceries.add(grocery);
                }
            }
        }

        return availableGroceries;
    }

    // EFFECTS: Sets all panels' visibility to false except for the main menu
    public void returnToMainMenu() {
        mainMenu.setVisible(true);
        grocerySelectionMenu.setVisible(false);
        cartMenu.setVisible(false);
    }










}
