package ui.gui;

import model.Grocery;
import model.ShoppingCart;
import model.Store;

import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayGroceriesMenu extends JFrame implements ActionListener {

    private JLabel title;
    private JButton addButton;
    private JList<String> groceryList;
    private ShoppingCart cart = new ShoppingCart();
    private Store selectedstore;

    public DisplayGroceriesMenu(Store selectedStore) {
        super();
        this.selectedstore = selectedStore;
        setDisplayGroceriesMenu();

    }


    //This is the method that is called when the JButton btn is clicked
    public void actionPerformed(ActionEvent ae) {
        addAction(ae);
    }

    public void setDisplayGroceriesMenu() {
        setTitle("GrocerLytics");
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.lightGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        setDisplayGroceriesMenuTitle();
        setButtons();
        displayGroceries(getAvailableGroceries());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setDisplayGroceriesMenuTitle() {
        title = new JLabel("Here are the available groceries");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        add(title);
    }

    private void setButtons() {
        addButton = new JButton("Add Grocery");
        addButton.addActionListener(this);
        addButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(addButton);
    }

    private void addAction(ActionEvent ae) {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selection = Integer.parseInt(JOptionPane.showInputDialog("Please select the grocery to"
                            + " add to your cart:"));

                    if (selection >= 1 && selection <= getAvailableGroceries().size()) {
                        Grocery selectedGrocery = getAvailableGroceries().get(selection - 1);
                        // Assuming that cart and selectedstore are available in this context
                        cart.addItem(selectedGrocery);
                        selectedGrocery.setStore(selectedstore);
                        JOptionPane.showMessageDialog(DisplayGroceriesMenu.this,
                                selectedGrocery.getName() + " added to your shopping cart.");
                    } else if (selection != 0) {
                        JOptionPane.showMessageDialog(DisplayGroceriesMenu.this,
                                "Invalid selection. Please select again.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(DisplayGroceriesMenu.this,
                            "Invalid input. Please enter a number.");
                }
            }
        });
    }

    private void displayGroceries(List<Grocery> groceries) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        int i = 1;
        for (Grocery item : groceries) {
            listModel.addElement(i + ". " + item.getName() + "- $" + item.getPrice());
            i++;
        }

        groceryList.setModel(listModel);

    }

    private List<Grocery> getAvailableGroceries() {
        List<Grocery> availableGroceries = new ArrayList<>();


        availableGroceries.add(new Grocery("Banana", "Produce", 0.69));
        availableGroceries.add(new Grocery("Apple", "Produce", 1.50));
        availableGroceries.add(new Grocery("Cabbage", "Produce", 1.49));
        availableGroceries.add(new Grocery("Pork", "Deli", 5.99));
        availableGroceries.add(new Grocery("Beef", "Deli", 5.99));
        availableGroceries.add(new Grocery("Chicken", "Deli", 5.99));
        availableGroceries.add(new Grocery("Milk", "Dairy", 5.49));
        availableGroceries.add(new Grocery("Eggs", "Dairy", 11.49));
        availableGroceries.add(new Grocery("Yogurt", "Dairy", 6.59));

        return availableGroceries;
    }

}
