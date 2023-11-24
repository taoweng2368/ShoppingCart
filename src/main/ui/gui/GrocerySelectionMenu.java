package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrocerySelectionMenu extends JFrame implements ActionListener {

    private JLabel title;
    private JFrame mainMenu;

    private JButton returnToMainMenuButton;
    private JButton produceButton;
    private JButton deliButton;
    private JButton dairyButton;

    public GrocerySelectionMenu() {
        super();
        setGrocerySelectionMenu();
    }

    //This is the method that is called when the JButton btn is clicked
    public void actionPerformed(ActionEvent ae) {
        returnToMainMenuAction(ae);
        produceSelectionAction(ae);
        deliSelectionAction(ae);
        dairySelectionAction(ae);
    }

    public void setGrocerySelectionMenu() {
        setTitle("GrocerLytics");
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.lightGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        setGrocerySelectionMenuTitle();
        setButtons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setGrocerySelectionMenuTitle() {
        title = new JLabel("Choose your grocery types");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        add(title);
    }

    private void setButtons() {
        returnToMainMenuButton = new JButton("Return to Main Menu");
        returnToMainMenuButton.addActionListener(this);
        returnToMainMenuButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(returnToMainMenuButton);
        produceButton = new JButton("Produce");
        produceButton.addActionListener(this);
        produceButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(produceButton);
        deliButton = new JButton("Deli");
        deliButton.addActionListener(this);
        deliButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(deliButton);
        dairyButton = new JButton("Dairy");
        dairyButton.addActionListener(this);
        dairyButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(dairyButton);
    }

    private void returnToMainMenuAction(ActionEvent ae) {
        returnToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu = new GroceryStartMenu();
                mainMenu.setVisible(true);
                setVisible(false);
            }
        });
    }

    private void produceSelectionAction(ActionEvent ae) {
        produceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreMenu();
            }
        });
    }

    private void deliSelectionAction(ActionEvent ae) {
        deliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreMenu();
            }
        });
    }

    private void dairySelectionAction(ActionEvent ae) {
        dairyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreMenu();
            }
        });
    }

}
