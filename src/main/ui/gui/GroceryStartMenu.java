package ui.gui;

import model.Grocery;
import model.ShoppingCart;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GroceryStartMenu extends JFrame implements ActionListener {

    private JLabel title;

    private JButton selectGroceriesButton;
    private JButton viewCartButton;
    private JButton saveCartButton;
    private JButton loadCartButton;
    private JButton exitButton;

    private ShoppingCart cart;
    private DefaultListModel<Grocery> cartListModel;

    public GroceryStartMenu() {
        super();
        setMenu();
        cart = new ShoppingCart();
        cartListModel = new DefaultListModel<>();


    }


    //This is the method that is called when the JButton btn is clicked
    public void actionPerformed(ActionEvent ae) {
        grocerySelectionAction(ae);
        viewCartAction(ae);
        saveCartAction(ae);
        loadCartAction(ae);
        exitAction(ae);
    }

    public void setMenu() {
        setTitle("GrocerLytics");
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.lightGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        setStartTitle();
        setButtons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setStartTitle() {
        title = new JLabel("Welcome to Grocerlytics");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        add(title);

    }

    public void setButtons() {
        selectGroceriesButton = new JButton("Select Groceries");
        selectGroceriesButton.addActionListener(this);
        selectGroceriesButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(selectGroceriesButton);
        viewCartButton = new JButton("View Cart");
        viewCartButton.addActionListener(this);
        viewCartButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(viewCartButton);
        saveCartButton = new JButton("Save");
        saveCartButton.addActionListener(this);
        saveCartButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(saveCartButton);
        loadCartButton = new JButton("Load");
        loadCartButton.addActionListener(this);
        loadCartButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(loadCartButton);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(exitButton);
    }

    private void grocerySelectionAction(ActionEvent ae) {
        selectGroceriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GrocerySelectionMenu();
            }
        });
    }

    private void viewCartAction(ActionEvent ae) {
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewShoppingCartMenu();
            }
        });
    }

    private void saveCartAction(ActionEvent ae) {
        saveCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCart();
            }
        });
    }

    private void loadCartAction(ActionEvent ae) {
        loadCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadCart();
            }
        });
    }

    private void exitAction(ActionEvent ae) {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void saveCart() {
        try {
            JsonWriter jsonWriter = new JsonWriter("shopping_cart.json");
            jsonWriter.open();
            jsonWriter.write(cart);
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
            jsonReader.read(cart);
            cartListModel.clear();
            for (Grocery grocery : cart.getItems()) {
                cartListModel.addElement(grocery);
            }
            JOptionPane.showMessageDialog(this, "Shopping Cart loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading shopping cart!");
        }
    }
}

