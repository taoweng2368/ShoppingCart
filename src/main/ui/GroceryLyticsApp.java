package ui;

import model.Grocery;
import model.ShoppingCart;
import model.Store;
import java.util.List;
import java.util.Scanner;


// Shopping cart application inspired by TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp
public class GroceryLyticsApp {
    // Shopping Cart
    private ShoppingCart cart;
    // stores
    private Store walmart;
    private Store tnt;
    private Store superstore;
    // Inputs
    private Scanner input;


    private Store selectedstore;


    // EFFECTS: run the Shopping cart application
    public GroceryLyticsApp() {
        cart = new ShoppingCart();
        walmart = new Store("Walmart");
        tnt = new Store("T&T");
        superstore = new Store("Superstore");
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: complements the App method to start cart application
    private void runApp() {
        boolean keepGoing = true;
        String command = null;

        initOverall();

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
    // EFFECTS: initialize the scanner and all store's groceries
    private void initOverall() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
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


    // MODIFIES: this
    // EFFECTS: displays menu of grocery type options to user
    private void displayMenu() {
        System.out.println("\nplease select the following grocery options:");
        System.out.println("\ta -> Produce");
        System.out.println("\tb -> Deli");
        System.out.println("\tc -> Dairy");
        System.out.println("\tv -> View Shopping Cart");
        System.out.println("\tr -> Remove Items from Shopping Cart");
        System.out.println("\tq -> Quit App");
    }


    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        switch (command) {
            case "a":
                selectGroceries("Produce");
                break;
            case "b":
                selectGroceries("Deli");
                break;
            case "c":
                selectGroceries("Dairy");
                break;
            case "v":
                viewShoppingCart();
                break;
            case "r":
                removeFromShoppingCart();
                break;
            default:
                System.out.println("Invalid selection. Please select again. ");
                break;
        }
    }


    // MODIFIES: this
    // EFFECTS: Allow users to select groceries from the selected store and add them to their cart
    //              - if a store is selected correctly, it will give back a list of groceries available in that store
    //              - user is then given the option to add the selected grocery to the cart
    //              - if the store does not have the item in stock, it will prompt a message saying so
    //              - otherwise say "invalid selection and please select again"
    private void selectGroceries(String grocerytype) {
        selectedstore = selectStore();

        if (selectedstore != null) {
            List<Grocery> availableGroceries = selectedstore.getGroceriesByType(grocerytype);
            if (availableGroceries.isEmpty()) {
                System.out.println("No " + grocerytype + " items are in stock in "
                        + selectedstore.getStoreName() + " at the moment. Sorry for your inconvenience");
            } else {
                displayGroceries(availableGroceries);
                addToShoppingCart(availableGroceries);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Allow the user to select a desired store to buy groceries from
    private Store selectStore() {
        String selection = "";

        while (!(selection.equals("a") || selection.equals("b") || selection.equals("c"))) {
            System.out.println("Please select a store");
            System.out.println("\ta -> Walmart");
            System.out.println("\tb -> T&T");
            System.out.println("\tc -> Superstore");
            selection = input.next();
            selection = selection.toLowerCase();

            switch (selection) {
                case "a":
                    return walmart;
                case "b":
                    return tnt;
                case "c":
                    return superstore;
                default:
                    System.out.println("Invalid selection. Please select again.");
            }
        }
        return selectStore();
    }


    // MODIFIES: this
    // EFFECTS: To display all the available groceries in the selected store
    private void displayGroceries(List<Grocery> groceries) {
        System.out.println("Here are the available groceries in " + selectedstore.getStoreName());
        int i = 1;
        for (Grocery item : groceries) {
            System.out.println(i + ". " + item.getName() + "- $" + item.getPrice());
            i++;
        }
    }


    // REQUIRES: input = int
    // MODIFIES: this
    // EFFECTS: To add the selected item into the shopping cart
    //         - if user select an item, adds item to cart, providing confirmation text
    //         - otherwise, prompt the user to try again
    private void addToShoppingCart(List<Grocery> groceries) {
        System.out.println("Please select the grocery to add to your cart:");
        int selection = input.nextInt();
        if (selection >= 1 && selection <= groceries.size()) {
            Grocery selectedGrocery = groceries.get(selection - 1);
            cart.addItem(selectedGrocery);
            selectedGrocery.setStore(selectedstore);
            System.out.println(selectedGrocery.getName() + " added to your shopping cart.");
        } else if (selection != 0) {
            System.out.println("Invalid selection. Please select again.");
        }

    }

    // MODIFIES: this
    // EFFECTS: To view the items in the shopping cart
    private void viewShoppingCart() {

        List<Grocery> items = cart.getItems();

        if (items.isEmpty()) {
            System.out.println("Your shopping cart is empty");
        } else {
            System.out.println("Items in your shopping cart:");
            int i = 1;
            for (Grocery item : items) {
                System.out.println(i + ". " + item.getName() + " - $" + item.getPrice() + " from "
                        + item.getStore().getStoreName());
                i++;
            }
        }

    }

    // REQUIRES: input = int
    // MODIFIES: this
    // EFFECTS: Remove a selected item from the shopping cart
    //         - if the cart is empty, say "the cart is empty" and prompt the user to buy
    //         - if the cart is not empty, user chooses the grocery to remove
    //         - otherwise, say "no item found in cart" and user try again
    private void removeFromShoppingCart() {
        List<Grocery> items = cart.getItems();
        System.out.println("Select the item you wish to remove from your cart:");
        viewShoppingCart();
        int selection = input.nextInt();
        if (selection >= 1 && selection <= items.size()) {
            Grocery selectedGrocery = items.get(selection - 1);
            cart.removeItem(selectedGrocery);
            System.out.println(selectedGrocery.getName() + " is removed from your shopping cart.");
        } else {
            System.out.println("Item not found in your cart.");
            removeFromShoppingCart();

        }
    }

}



