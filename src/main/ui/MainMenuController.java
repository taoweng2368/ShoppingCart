//package ui;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainMenuController {
//    private GUI gui;
//    private JButton searchGroceriesButton;
//    private JButton viewCartButton;
//    private JButton saveButton;
//    private JButton loadButton;
//    private JButton exitButton;
//    private JPanel groceryPanel;
//
//    private SaveCartController saveCartController;
//    private LoadCartController loadCartController;
//    private GrocerySelectionMenu grocerySelectionController;
//
//    public MainMenuController(GUI gui) {
//        this.gui = gui;
//        saveCartController = new SaveCartController(gui);
//
//    }
//
//    public void initializeMainMenuButtons() {
//        searchGroceriesButton = new JButton("Search Groceries");
//        viewCartButton = new JButton("View Cart");
//        saveButton = new JButton("Save Cart");
//        loadButton = new JButton("Load Cart");
//        exitButton = new JButton("Exit Application");
//
//        gui.getMainMenu().add(searchGroceriesButton);
//        gui.getMainMenu().add(viewCartButton);
//        gui.getMainMenu().add(saveButton);
//        gui.getMainMenu().add(loadButton);
//        gui.getMainMenu().add(exitButton);
//    }
//
//
//
//    public void initializeActions() {
//        selectGroceriesAction();
//        viewCartAction();
//        saveAction();
//        loadAction();
//        exitAction();
//    }
//
//    private void exitAction() {
//        exitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//    }
//
//    private void loadAction() {
//        loadButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//    }
//
//    private void saveAction() {
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                saveCartController.saveCartAction();
//            }
//        });
//    }
//
//    private void viewCartAction() {
//        viewCartButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                loadCartController.loadCartAction();
//            }
//        });
//    }
//
//    private void selectGroceriesAction() {
//        searchGroceriesButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                gui.getGroceryPanel().setVisible(true);
//                gui.getMainMenu().setVisible(false);
//            }
//        });
//    }
//
//    public JButton getSearchGroceriesButton() {
//        return searchGroceriesButton;
//    }
//
//    public JButton getViewCartButton() {
//        return viewCartButton;
//    }
//
//    public JButton getSaveButton() {
//        return saveButton;
//    }
//
//    public JButton getLoadButton() {
//        return loadButton;
//    }
//
//    public JButton getExitButton() {
//        return exitButton;
//    }
//
//
//
//}
