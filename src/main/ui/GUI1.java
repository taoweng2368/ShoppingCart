package ui;

import model.EventLog;
import model.Grocery;
import model.ShoppingCart;
import model.Store;

import java.util.List;
import java.util.ArrayList;

import model.exception.LogException;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.SystemColor.desktop;


// Represent the GUI class for the Grocery App
public class GUI1 extends JFrame implements ActionListener {

    private static final String SHOPPINGCART_FILE = "./data/shopping_cart.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private ShoppingCart cart;
    private Store walmart;
    private Store tnt;
    private Store superstore;

    JComboBox<String> cartComboBox = new JComboBox<>();



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



    // Make a new JFrame for GroceryApp
    public GUI1() {
        super("Grocerlytics");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        cart = new ShoppingCart();

        jsonWriter = new JsonWriter(SHOPPINGCART_FILE);
        jsonReader = new JsonReader(SHOPPINGCART_FILE);
        initStores();

        initPanels();




        welcomeLabel = new JLabel("Welcome to Grocerlytics");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        mainScreenImage = new JLabel();
        // Cart img from https://www.freeiconspng.com/img/28356
        mainScreenImage.setIcon(new ImageIcon("cart.png"));
        mainScreenImage.setMinimumSize(new Dimension(2, 5));

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

    // EFFECTS: initialize menus
    private void initPanels() {
        setMenu();
        makeGrocerySelectionMenu();
        makeShoppingCartMenu();
    }

    // MODIFIES: this
    // EFFECTS: initialize Stores in general
    private void initStores() {
        walmart = new Store("Walmart");
        tnt = new Store("T&T");
        superstore = new Store("Superstore");
        initWalmart();
        initTnt();
        initSuperstore();
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

    // EFFECTS: Make the main menu panel
    public void setMenu() {
        mainMenu = new JPanel();
        mainMenu.setBackground(Color.LIGHT_GRAY);
        add(mainMenu);
        items = new JLabel();

    }

    // EFFECTS: set the buttons
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

        // EventLog


    }

    // MODIFIES: this
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

    // EFFECTS: calls the addbutton method on each parameter
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

    // MODIFIES: this
    // EFFECTS: Sets each button to an action
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
            logEvent("User selected groceries");
        } else if (ae.getActionCommand().equals("View Cart")) {
            initializeCartMenu();
            logEvent("User selected groceries");
        } else if (ae.getActionCommand().equals("Save Cart")) {
            saveCart();
            logEvent("User selected groceries");
        } else if (ae.getActionCommand().equals("Load Cart")) {
            loadCart();
            logEvent("User selected groceries");
        } else if (ae.getActionCommand().equals("Exit App")) {
            printLoggedEvents();
            System.exit(0);
        } else if (ae.getActionCommand().equals("Add Grocery")) {
            addGroceryToCart();
            logEvent("User selected groceries");
        } else if (ae.getActionCommand().equals("Remove Grocery")) {
            removeGroceryFromCart();
            logEvent("User selected groceries");
        } else if (ae.getActionCommand().equals("Return")) {
            returnToMainMenu();
            logEvent("User selected groceries");
        } else if (ae.getActionCommand().equals("Back")) {
            returnToMainMenu();
            logEvent("User selected groceries");
        }
    }

    private void logEvent(String description) {
        EventLog.getInstance().logEvent(new Event(description));
    }

    // MODIFIES: this
    // EFFECTS: Creates the shopping cart panel
    public void makeShoppingCartMenu() {
        cartMenu = new JPanel(new GridLayout(2, 1));

        cartComboBox.setFont(new Font("Arial", Font.BOLD, 12));

        updateCartComboBox(cartComboBox);

        cartMenu.add(cartComboBox);
    }

    // EFFECTS: to update the text in the cartTextArea based on the contents of the cart
    private void updateCartComboBox(JComboBox<String> cartComboBox) {

        cartComboBox.removeAllItems();

        List<Grocery> cartItems = cart.getItems();

        if (cartItems.isEmpty()) {
            cartComboBox.addItem("No items in the cart");
        } else {
            for (Grocery item : cartItems) {
                String itemText = String.format("%s - $%.2f - %s", item.getName(), item.getPrice(),
                        item.getStore().getStoreName());
                cartComboBox.addItem(itemText);
            }
        }
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
            List<String> cartOptions = new ArrayList<>();
            for (Grocery grocery : cartItems) {
                cartOptions.add(grocery.getName() + " - $" + grocery.getPrice() + " ("
                        + grocery.getStore().getStoreName() + ")");
            }

            String selectedCartItem = (String) JOptionPane.showInputDialog(this,
                    "Choose Grocery to Remove:", "Remove Grocery", JOptionPane.QUESTION_MESSAGE, null,
                    cartOptions.toArray(new String[0]), cartOptions.get(0));

            if (selectedCartItem != null) {
                int selectedIndex = cartOptions.indexOf(selectedCartItem);
                Grocery removedGrocery = cartItems.remove(selectedIndex);
                JOptionPane.showMessageDialog(this, "Removed " + removedGrocery.getName()
                        + " from the shopping cart!");

                updateCartComboBox(cartComboBox);
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
        String groceryType = promptUserForInput("Choose Grocery Type:",
                "Grocery Type Selection", "Produce", "Deli", "Dairy");
        String selectedStoreName = promptUserForInput("Choose Store:",
                "Store Selection", "Walmart", "T&T", "Superstore");

        Store selectedStore = getStoreByName(selectedStoreName);
        if (selectedStore != null) {
            List<Grocery> availableGroceries = selectedStore.getGroceriesByType(groceryType);

            if (!availableGroceries.isEmpty()) {
                Grocery selectedGrocery = promptUserForGrocerySelection("Choose Grocery:",
                        "Grocery Selection", availableGroceries);

                if (selectedGrocery != null) {
                    cart.addItem(selectedGrocery);
                    selectedGrocery.setStore(selectedStore);
                    updateCartComboBox(cartComboBox);
                    JOptionPane.showMessageDialog(this, "Added "
                            + selectedGrocery.getName() + " to the shopping cart!");
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sorry, the groceries are not in stock at the moment.");
            }
        }
    }

    // EFFECTS: Return a Grocery from user selection
    private Grocery promptUserForGrocerySelection(String message, String title, List<Grocery> groceries) {
        List<String> groceryOptions = createGroceryOptions(groceries);
        String selectedGroceryOption = promptUserForInput(message, title, groceryOptions.toArray(new String[0]));

        if (selectedGroceryOption != null) {
            int selectedIndex = groceryOptions.indexOf(selectedGroceryOption);
            return groceries.get(selectedIndex);
        }

        return null;
    }

    // EFFECTS: Return a list of grocery options
    private List<String> createGroceryOptions(List<Grocery> groceries) {
        List<String> groceryOptions = new ArrayList<>();
        for (Grocery grocery : groceries) {
            groceryOptions.add(grocery.getName() + " - $" + grocery.getPrice());
        }
        return groceryOptions;
    }

    // EFFECTS: Return a string for showing input dialog
    private String promptUserForInput(String message, String title, String... options) {
        return (String) JOptionPane.showInputDialog(this, message, title,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }


    // SAVE AND LOAD METHODS:

    // MODIFIES: this
    // EFFECTS: save the cart file if it exists
    // otherwise, error message
    private void saveCart() {
        try {
            jsonWriter.open();
            jsonWriter.write(cart);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Shopping cart data saved to file: "
                    + SHOPPINGCART_FILE);
            logEvent("Shopping cart data saved to file: " + SHOPPINGCART_FILE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Unable to write to file: "
                    + SHOPPINGCART_FILE);
            logEvent("Unable to write to file: " + SHOPPINGCART_FILE);
        }
    }

    // MODIFIES: this
    // EFFECTS: load the cart file if it exists
    // otherwise, error message
    private void loadCart() {
        try {
            jsonReader.read(cart);
            JOptionPane.showMessageDialog(this, "Shopping cart data loaded from file: "
                    + SHOPPINGCART_FILE);
            logEvent("Shopping cart data loaded from file: " + SHOPPINGCART_FILE);
            updateCartComboBox(cartComboBox);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading shopping cart data: "
                    + SHOPPINGCART_FILE);
            logEvent("Error loading shopping cart data: " + SHOPPINGCART_FILE);
        }
    }

    // Add a method to print logged events when the application is exited
    private void printLoggedEvents() {
        System.out.println("Events logged since the application started:");
        for (Event event : EventLog.getInstance()) {
            System.out.println(event);
        }
    }

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

    // EFFECTS: show available groceries based on the selected type and store
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
                JOptionPane.showMessageDialog(this,
                        "Sorry, the groceries are not in stock at the moment.");
            }
        }
    }

    // EFFECTS: Sets all panels visibility to false except for the main menu
    public void returnToMainMenu() {
        mainMenu.setVisible(true);
        grocerySelectionMenu.setVisible(false);
        cartMenu.setVisible(false);
    }










}
