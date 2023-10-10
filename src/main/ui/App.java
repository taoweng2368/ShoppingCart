package ui;

import model.Groceries;
import model.ShoppingCart;
import model.Store;

import java.util.Scanner;

// Shopping cart application
public class App {
    // Shopping Cart
    private ShoppingCart cart;

    // Produce
    private Groceries banana;
    private Groceries apple;
    private Groceries cabbage;

    // Deli
    private Groceries pork;
    private Groceries beef;
    private Groceries chicken;

    // Dairy
    private Groceries milk;
    private Groceries eggs;
    private Groceries yogurt;

    // Store
    private Store walmart;
    private Store tnt;
    private Store superstore;

    // Inputs
    private Scanner input;



    // EFFECTS: run the Shopping cart application
    public App() {
        runApp();
    }

    private void runApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nHave a nice day!");
    }

    // MODIFIES: this
    // EFFECTS: initialize stores and groceries
    private void init() {

        // Inputs
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of grocery type options to user
    private void displayMenu() {
        System.out.println("\nplease select the following grocery options:");
        System.out.println("\ta -> Produce");
        System.out.println("\tb -> Deli");
        System.out.println("\tc -> Dairy");
        System.out.println("\tq -> quit");
    }


    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            doProduce();
        } else if (command.equals("b")) {
            doDeli();
        } else if (command.equals("c")) {
            doDairy();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: go into Produce selection of groceries
    private void doProduce() {
        selectProduce();
    }

    // EFFECTS: go into T&T's selection of groceries
    private void doDeli() {
        selectDeli();
    }

    // EFFECTS: go into Superstore's selection of groceries
    private void doDairy() {
        selectDairy();
    }

    private void doStore() {
        selectStore();
    }

    private Store selectStore() {
        String selection = "";

        while (!(selection.equals("a") || selection.equals("b") || selection.equals("c"))) {
            System.out.println("\nplease select one of the following stores:");
            System.out.println("\ta -> Walmart");
            System.out.println("\tb -> T&T");
            System.out.println("\tc -> Superstore");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("a")) {
            return walmart;
        } else if (selection.equals("b")) {
            return tnt;
        } else {
            return superstore;
        }
    }

    //EFFECTS: prompts user to select the following Produce groceries and return it
    private void selectProduce() {
        String selection = "";

        while (!(selection.equals("a") || selection.equals("b") || selection.equals("c"))) {
            System.out.println("\nplease select one of the following:");
            System.out.println("\ta -> banana");
            System.out.println("\tb -> apple");
            System.out.println("\tc -> cabbage");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("a")) {
            doStore();
        } else if (selection.equals("b")) {
            doStore();
        } else {
            doStore();
        }
    }



    //EFFECTS: prompts user to select the following Deli groceries and return it
    private void selectDeli() {
        String selection = "";

        while (!(selection.equals("a") || selection.equals("b") || selection.equals("c"))) {
            System.out.println("\nplease select one of the following:");
            System.out.println("\ta -> pork");
            System.out.println("\tb -> beef");
            System.out.println("\tc -> chicken");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("a")) {
            doStore();
        } else if (selection.equals("b")) {
            doStore();
        } else {
            doStore();
        }
    }

    //EFFECTS: prompts user to select the following Dairy groceries and return it
    private void selectDairy() {
        String selection = "";

        while (!(selection.equals("a") || selection.equals("b") || selection.equals("c"))) {
            System.out.println("\nplease select one of the following:");
            System.out.println("\ta -> milk");
            System.out.println("\tb -> eggs");
            System.out.println("\tc -> yogurt");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("a")) {
            doStore();
        } else if (selection.equals("b")) {
            doStore();
        } else {
            doStore();
        }
    }
}



