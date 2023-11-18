package ui;

import model.Grocery;
import model.ShoppingCart;
import model.Store;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class GrocerLyticsGUI extends JFrame {

    private ShoppingCart shoppingCart;
    private DefaultListModel<Grocery> cartListModel;
    private JComboBox<String> groceryTypeComboBox;
    private JComboBox<String> storeComboBox;
    private JList<Grocery> groceryList;
    private JButton addToCartButton;
    private JButton viewCartButton;
    private JButton removeItemButton;
    private JButton saveCartButton;
    private JButton loadCartButton;

    private Store walmart;
    private Store tnt;
    private Store superstore;

    public GrocerLyticsGUI() {
        shoppingCart = new ShoppingCart();
        cartListModel = new DefaultListModel<>();

        walmart = new Store("Walmart");
        tnt = new Store("Tnt");
        superstore = new Store("Superstore");

        initWalmart();
        initTnt();
        initSuperstore();

        initializeUI();
        populateStores(); // You need to implement this method to populate the storeComboBox
    }

    @SuppressWarnings("methodlength")
    private void initializeUI() {
        setTitle("Grocery Shopping App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        groceryTypeComboBox = new JComboBox<>(new String[]{"Fruits", "Vegetables", "Dairy"});
        storeComboBox = new JComboBox<>();
        groceryList = new JList<>();
        addToCartButton = new JButton("Add to Cart");
        viewCartButton = new JButton("View Cart");
        removeItemButton = new JButton("Remove Item");
        saveCartButton = new JButton("Save Cart");
        loadCartButton = new JButton("Load Cart");

        addToCartAction();

        viewCartAction();

        displayGroceriesAction();

        removeAction();

        saveAction();

        loadAction();

        add(new JLabel("Select Grocery Type:"));
        add(groceryTypeComboBox);
        add(new JLabel("Select Store:"));
        add(storeComboBox);
        add(new JLabel("Available Groceries:"));
        add(new JScrollPane(groceryList));
        add(addToCartButton);
        add(viewCartButton);
        add(removeItemButton);
        add(saveCartButton);
        add(loadCartButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadAction() {
        loadCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadCart();
            }
        });
    }

    private void saveAction() {
        saveCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCart();
            }
        });
    }

    private void removeAction() {
        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }
        });
    }

    private void displayGroceriesAction() {
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStoreGroceries();
            }
        });
    }

    private void viewCartAction() {
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCart();
            }
        });
    }

    private void addToCartAction() {
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });
    }

    private void populateStores() {
        // Assuming you have a list of stores, replace it with your actual list
        List<Store> stores = List.of(walmart,tnt,superstore); // Implement this method to get your list of stores

        // Clear existing items in the storeComboBox
        storeComboBox.removeAllItems();

        // Add store names to the storeComboBox
        for (Store store : stores) {
            storeComboBox.addItem(store.getStoreName());
        }
    }

//    // Implement this method to get your list of stores
//    private List<Store> getAvailableStores() {
//        List<Store> stores = new ArrayList<>();
//        // Add your actual stores to the list
//        // Example:
//        stores.add(new Store("Store1"));
//        stores.add(new Store("Store2"));
//        stores.add(new Store("Store3"));
//        return stores;
//    }

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

    private void initTnt() {
        tnt.addGrocery(new Grocery("Banana", "Produce", 0.59));
        tnt.addGrocery(new Grocery("Apple", "Produce", 1.20));
        tnt.addGrocery(new Grocery("Cabbage", "Produce", 1.59));
    }

    private void initSuperstore() {
        superstore.addGrocery(new Grocery("Pork", "Deli", 4.99));
        superstore.addGrocery(new Grocery("Beef", "Deli", 5.99));
        superstore.addGrocery(new Grocery("Chicken", "Deli", 6.99));
    }


    private void addToCart() {
        Grocery selectedGrocery = groceryList.getSelectedValue();
        if (selectedGrocery != null) {
            shoppingCart.addItem(selectedGrocery);
            cartListModel.addElement(selectedGrocery);
        }
    }

    private void viewCart() {
        JOptionPane.showMessageDialog(this, "Shopping Cart:\n" + shoppingCart.getItems());
    }

    private void removeItem() {
        int selectedIndex = groceryList.getSelectedIndex();
        if (selectedIndex != -1) {
            Grocery removedGrocery = cartListModel.remove(selectedIndex);
            shoppingCart.removeItem(removedGrocery);
        }
    }

    private void saveCart() {
        try {
            JsonWriter jsonWriter = new JsonWriter("shopping_cart.json");
            jsonWriter.open();
            jsonWriter.write(shoppingCart);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Shopping Cart saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving shopping cart!");
        }
    }

    private void loadCart() {
        try {
            JsonReader jsonReader = new JsonReader("shopping_cart.json");
            jsonReader.read(shoppingCart);
            cartListModel.clear();
            for (Grocery grocery : shoppingCart.getItems()) {
                cartListModel.addElement(grocery);
            }
            JOptionPane.showMessageDialog(this, "Shopping Cart loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading shopping cart!");
        }
    }

    private void displayStoreGroceries() {
        String selectedStoreName = (String) storeComboBox.getSelectedItem();
        Store selectedStore = getStoreByName(selectedStoreName);

        if (selectedStore != null) {
            List<Grocery> groceries = selectedStore.getInventory();
            populateGroceryList(groceries);
        }
    }

    private void populateGroceryList(List<Grocery> groceries) {
        DefaultListModel<Grocery> groceryListModel = new DefaultListModel<>();
        for (Grocery grocery : groceries) {
            groceryListModel.addElement(grocery);
        }
        groceryList.setModel(groceryListModel);
    }

    private Store getStoreByName(String storeName) {
        switch (storeName) {
            case "Walmart":
                return walmart;
            case "Tnt":
                return tnt;
            case "Superstore":
                return superstore;
            // Add cases for other stores if needed
            default:
                return null;
        }
    }
}