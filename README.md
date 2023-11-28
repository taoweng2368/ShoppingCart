# My Personal Project

## Grocerlytics 

*What will the application do?*

* My application will allow users to quickly search for their desired
groceries, and it will list all the available stores that have that type
of groceries, which has their prices, reviews (if available), location (from 
nearest to furthest), etc. 
* Users can compare their selected grocery between 2 stores in the list;
compare their prices, reviews, etc.

*Who will use it?*

* Family members
* Chefs 
* Restaurant Managers/Owners
* Students
* People in general

*Why is this project of interest to you?*
* As the prices for groceries are still rising at a very high annual pace. 
So it is even more crucial to save money and be smart on how we organize 
our spendings. Furthermore, food is something that is essential in our everyday 
living and finding affordable prices on food is very important. Especially for 
students who are on a tight budget but still need to provide for their food needs. 
However, this is not just for students, but for everybody. 



## User Stories

* As a user, I want to be able to click the desired grocery type that I want to buy.
* As a user, I want to be able to select the store I want that groceries from.
* As a user, I want to be able to see a list of groceries from the store, and select the one that I want to buy.
* As a user, I want to be able to see the store's price for that grocery.
* As a user, I want to be able to select my desired grocery and add it to my shopping cart
* As a user, I want to be able to view all my selected groceries in my shopping cart
* As a user, I want to be able to delete/remove selected groceries from my shopping cart

* As a user, I want to be able to save my shopping cart to file (if I so choose)
* As a user, I want to be able to load my shopping cart from file (if I so choose)


## Instructions for Grader


### Add Groceries:

* User can add groceries by clicking on the "select groceries" button. 
* Then User can choose desired Grocery type, desired Store.
* Then User can click on the "Show Available Groceries" button to display all the available groceries in the store 
at the moment.
* Then User can choose to Add Grocery by clicking the "Add Grocery" button. It will then take the user to a panel 
* choose their Grocery type, Store, and then are prompted to choose their grocery. If added, it will display a message
staying that "Grocery" has been added. 

### View Shopping Cart
* The added groceries can be viewed in the Shopping Cart. 
* User can click on the "View Cart" button to view their shopping cart.
* Once clicked, the User will see their add groceries list on the top left box. 

### Remove Groceries
* If desired, the User can choose to remove a grocery in the cart.
* The User can click on the "Remove Grocery" button, and it will prompt the User the choose the grocery that they
want to remove. 
* If there is no grocery in the cart, clicking the "Remove Grocery" button will display a message saying "No items
in the shopping cart to remove".


*Others*
* Visual Component (main screen cart image) is added in GUI constructor

* To save cart to file: press the save cart button
* To load cart to file: press the load cart button

## Phase 4: Task 2

### Sample representative of events:
Events logged since the application started:

* Mon Nov 27 18:48:32 PST 2023 
* User selected a grocery
* Mon Nov 27 18:48:36 PST 2023
* User added a grocery
* Mon Nov 27 18:48:36 PST 2023
* User returned to main menu
* Mon Nov 27 18:48:37 PST 2023
* User viewed cart
* Mon Nov 27 18:48:40 PST 2023
* User removed a grocery
* Mon Nov 27 18:48:40 PST 2023
* User returned to main menu
* Mon Nov 27 18:48:44 PST 2023
* Shopping cart data saved to file: ./data/shopping_cart.json
* Mon Nov 27 18:48:46 PST 2023
* Shopping cart data loaded from file: ./data/shopping_cart.json
* Mon Nov 27 18:48:47 PST 2023
* User has exited the App
  