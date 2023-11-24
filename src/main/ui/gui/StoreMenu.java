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

public class StoreMenu extends JFrame implements ActionListener {

    private JLabel title;

    private Store walmart;
    private Store tnt;
    private Store superstore;

    private JButton walmartButton;
    private JButton tntButton;
    private JButton superstoreButton;

    public StoreMenu() {
        super();
        setStoreMenu();
    }

    //This is the method that is called when the JButton btn is clicked
    public void actionPerformed(ActionEvent ae) {
        walmartAction(ae);
        tntAction(ae);
        superStoreAction(ae);
    }

    public void setStoreMenu() {
        setTitle("GrocerLytics");
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.lightGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        setStoreMenuTitle();
        setButtons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setStoreMenuTitle() {
        title = new JLabel("Choose your store");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        add(title);
    }

    private void setButtons() {
        walmartButton = new JButton("Walmart");
        walmartButton.addActionListener(this);
        walmartButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(walmartButton);
        tntButton = new JButton("TNT");
        tntButton.addActionListener(this);
        tntButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(tntButton);
        superstoreButton = new JButton("Superstore");
        superstoreButton.addActionListener(this);
        superstoreButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(superstoreButton);
    }

    private void walmartAction(ActionEvent ae) {
        walmartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Store selectedStore = walmart;
                new DisplayGroceriesMenu(selectedStore);
            }
        });
    }

    private void tntAction(ActionEvent ae) {
        tntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Store selectedStore = tnt;
                new DisplayGroceriesMenu(selectedStore);
            }
        });
    }

    private void superStoreAction(ActionEvent ae) {
        superstoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Store selectedStore = superstore;
                new DisplayGroceriesMenu(selectedStore);

            }
        });
    }
}




