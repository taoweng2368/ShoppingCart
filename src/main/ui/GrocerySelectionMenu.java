//package ui;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class GrocerySelectionMenu extends JFrame {
//    private GUI gui;
//    private JButton mainMenuButton;
//    private JButton produceButton;
//    private JButton deliButton;
//    private JButton dairyButton;
//
//    private JPanel grocerySelectionMenu;
//
//    public GrocerySelectionMenu(GUI gui) {
//        this.gui = gui;
//        initializeGrocerySelectionMenu();
//    }
//
//    public void initializeActions() {
//        mainMenuAction();
//    }
//
//    public void initializeGrocerySelectionMenu() {
//        grocerySelectionMenu = new JPanel();
//        grocerySelectionMenu.setBackground(Color.lightGray);
//        add(grocerySelectionMenu);
//    }
//
//    public void initializeGrocerySelectionButton() {
//        mainMenuButton = new JButton("Return to Menu");
//        produceButton = new JButton("Produce");
//        deliButton = new JButton("deli");
//        dairyButton = new JButton("dairy");
//
//        gui.getGroceryPanel().add(mainMenuButton);
//        gui.getGroceryPanel().add(produceButton);
//        gui.getGroceryPanel().add(deliButton);
//        gui.getGroceryPanel().add(dairyButton);
//    }
//
//    public void mainMenuAction() {
//        mainMenuButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                returnToMainMenu();
//            }
//        });
//    }
//
//
//
//    public void returnToMainMenu() {
//        gui.getMainMenu().setVisible(true);
//        gui.getGroceryPanel().setVisible(false);
//    }
//}
