package ui;

import model.Grocery;
import model.ShoppingCart;
import model.Store;

import java.util.Arrays;
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
    private JButton returnButton;

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
        } else if (ae.getActionCommand().equals("Back")) {
            returnToMainMenu();
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates the shopping cart panel
    public void makeShoppingCartMenu() {
        cartMenu = new JPanel(new GridLayout(2, 2));

        JButton goBackButton = new JButton("Go Back to Main Menu");
        JButton removeGroceryButton = new JButton("Remove Grocery");

        cartMenu.add(new JLabel());
        cartMenu.add(goBackButton);
        cartMenu.add(new JLabel());
        cartMenu.add(removeGroceryButton);

        goBackButton.addActionListener(e -> setMenu());
        removeGroceryButton.addActionListener(e -> removeGroceryFromCart());
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

        if (!cartItems.isEmpty()) {
            String[] cartOptions = new String[cartItems.size()];
            for (int i = 0; i < cartItems.size(); i++) {
                Grocery grocery = cartItems.get(i);
                cartOptions[i] = grocery.getName() + " - $" + grocery.getPrice() + " (" + grocery.getStore().getStoreName() + ")";
            }

            String selectedCartItem = (String) JOptionPane.showInputDialog(this,
                    "Choose Grocery to Remove:", "Remove Grocery", JOptionPane.QUESTION_MESSAGE, null,
                    cartOptions, cartOptions[0]);

            if (selectedCartItem != null) {
                int selectedIndex = Arrays.asList(cartOptions).indexOf(selectedCartItem);
                Grocery removedGrocery = cartItems.remove(selectedIndex);
                JOptionPane.showMessageDialog(this, "Removed " + removedGrocery.getName() + " from the shopping cart!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No items in the shopping cart to remove.");
        }
    }



    // MODIFIES: this
    // EFFECTS: Creates a panel that displays the option for the user to choose their groceries
    public void makeGrocerySelectionMenu() {
        grocerySelectionMenu = new JPanel(new GridLayout(4, 2));

        JLabel chooseGroceryTypeLabel = new JLabel("Choose Grocery Type:");
        JComboBox<String> groceryTypeComboBox = new JComboBox<>(new String[]{"Produce", "Deli", "Dairy"});

        JLabel chooseStoreLabel = new JLabel("Choose Store:");
        JComboBox<String> storeComboBox = new JComboBox<>(new String[]{"Walmart", "T&T", "Superstore"});

        JButton showAvailableGroceriesButton = new JButton("Show Available Groceries");

        grocerySelectionMenu.add(chooseGroceryTypeLabel);
        grocerySelectionMenu.add(groceryTypeComboBox);
        grocerySelectionMenu.add(chooseStoreLabel);
        grocerySelectionMenu.add(storeComboBox);
        grocerySelectionMenu.add(showAvailableGroceriesButton);

        showAvailableGroceriesButton.addActionListener(e -> showAvailableGroceries(groceryTypeComboBox, storeComboBox));

        returnButton = new JButton("Back");
        grocerySelectionMenu.add(returnButton);

        returnButton.addActionListener(this);
        returnButton.setActionCommand("Back");
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
        String groceryType = (String) JOptionPane.showInputDialog(this, "Choose Grocery Type:",
                "Grocery Type Selection", JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"Produce", "Deli", "Dairy"}, "Produce");

        String[] storeNames = {"Walmart", "T&T", "Superstore"};
        String selectedStoreName = (String) JOptionPane.showInputDialog(this, "Choose Store:",
                "Store Selection", JOptionPane.QUESTION_MESSAGE, null,
                storeNames, "Walmart");

        Store selectedStore = getStoreByName(selectedStoreName);
        if (selectedStore != null) {
            List<Grocery> availableGroceries = selectedStore.getGroceriesByType(groceryType);

            if (!availableGroceries.isEmpty()) {
                String[] groceryOptions = new String[availableGroceries.size()];
                for (int i = 0; i < availableGroceries.size(); i++) {
                    Grocery grocery = availableGroceries.get(i);
                    groceryOptions[i] = grocery.getName() + " - $" + grocery.getPrice();
                }

                String selectedGroceryOption = (String) JOptionPane.showInputDialog(this,
                        "Choose Grocery:", "Grocery Selection", JOptionPane.QUESTION_MESSAGE, null,
                        groceryOptions, groceryOptions[0]);

                if (selectedGroceryOption != null) {
                    int selectedIndex = Arrays.asList(groceryOptions).indexOf(selectedGroceryOption);
                    Grocery selectedGrocery = availableGroceries.get(selectedIndex);
                    cart.addItem(selectedGrocery);
                    JOptionPane.showMessageDialog(this, "Added " + selectedGrocery.getName() + " to the shopping cart!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sorry, the groceries are not in stock at the moment.");
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

    // EFFECTS: available groceries based on the selected type and store
    private void showAvailableGroceries(JComboBox<String> groceryTypeComboBox, JComboBox<String> storeComboBox) {
        String selectedGroceryType = (String) groceryTypeComboBox.getSelectedItem();
        String selectedStoreName = (String) storeComboBox.getSelectedItem();

        Store selectedStore = getStoreByName(selectedStoreName);
        if (selectedStore != null) {
            List<Grocery> availableGroceries = selectedStore.getGroceriesByType(selectedGroceryType);

            if (!availableGroceries.isEmpty()) {
                JPanel availableGroceriesPanel = new JPanel(new GridLayout(availableGroceries.size(), 1));
                for (Grocery grocery : availableGroceries) {
                    JLabel groceryLabel = new JLabel(grocery.getName() + " - $" + grocery.getPrice());
                    availableGroceriesPanel.add(groceryLabel);
                }

                JOptionPane.showMessageDialog(this, availableGroceriesPanel, "Available Groceries",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Sorry, the groceries are not in stock at the moment.");
            }
        }
    }

    // EFFECTS: Sets all panels' visibility to false except for the main menu
    public void returnToMainMenu() {
        mainMenu.setVisible(true);
        grocerySelectionMenu.setVisible(false);
        cartMenu.setVisible(false);
    }










}
