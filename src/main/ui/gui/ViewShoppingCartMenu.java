package ui.gui;

import model.Grocery;
import model.ShoppingCart;
import model.Store;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class ViewShoppingCartMenu extends JFrame implements ActionListener {

    private JLabel title;
    private ShoppingCart cart;
    private List<Store> stores = new ArrayList<>();

    private JButton removeButton;

    public ViewShoppingCartMenu() {
        super();
        setShoppingCartMenu();
    }

    //This is the method that is called when the JButton btn is clicked
    public void actionPerformed(ActionEvent ae) {
        removeAction(ae);
    }

    public void setShoppingCartMenu() {
        setTitle("Grocerlytics");
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.lightGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        setCartTitle();
        setButtons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setCartTitle() {
        title = new JLabel("Your Cart");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        add(title);
    }

    private void setButtons() {
        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        removeButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(removeButton);
    }

    private void removeAction(ActionEvent ae) {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //removeFromShoppingCart();
            }
        });
    }

    private void removeFromShoppingCart() {
        List<Grocery> items = cart.getItems();
    }
}
