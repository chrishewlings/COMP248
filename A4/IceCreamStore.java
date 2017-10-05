class IceCreamStore
{
	ShoppingCart cart = new ShoppingCart();
	final int MAX_ITEMS = 5; 

	void placeOrder() // adds an order to the cart.
	{
		if(this.cart.isFull())
			System.out.println("\nCart full! Can't add any more items.\n");
		else
			this.cart.add(new IceCreamOrder());
	}

	void deleteOrder() 
	{ 
		/* removes an order from the cart
		   or errors out and returns to the main menu
		   if index is not found. */

		// get cart contents
		String s_cartContents = cart.toString();
		// split cart contents to list
		String[] arr_cartContents = s_cartContents.split("\n");
		// create menu and get user input
		// but break if cart is empty.
		if(cart.isEmpty())
		{
			System.out.println("No items in cart to delete! Choose another option.");
		}
		else
		{
			Menu deletionMenu = new Menu(arr_cartContents);
			int indexToDelete = ( deletionMenu.getOptionNumber() - 1);
			cart.remove(indexToDelete);
			System.out.println("\nThe order you selected was deleted.\n");
		}
	}

	double computeTotalPrice() // computes and returns the price of items in the cart.
	{
		double totalAmount = 0.0;
		// loop over cart, skipping empty entries.
		for(int order = 0; order < MAX_ITEMS; order++)
		{
			if(cart.get(order) == null)
				continue;
			else
				totalAmount += ( cart.get(order).getUnitPrice() * cart.get(order).getQuantity() );
		}
		return totalAmount;
	}

	void printTotalPrice() // calls computeTotalPrice(), formats it, and prints to screen.
	{
		System.out.printf("$%.2f\n",computeTotalPrice());
	}

	void reviewOrders() // prints cart contents to screen. 
	{
		System.out.println(cart.toString());
	}

	void checkout() // prints cart contents and total price to screen.
	{
		reviewOrders();
		printTotalPrice();
	}

	void run() // shows the main menu and handles logic for moving from one submenu to another. 
	{
		String[] mainMenuOptions = {"Place an order",
									"Delete an order",
									"Price the cart",
									"List the cart",
									"Proceed to checkout",
									"Exit this menu"}; 

		Menu mainMenu = new Menu(mainMenuOptions);
		int userChoice;

		while(true)
		{
			/* show only relevant options,
			   depending on whether cart is empty, full, or neither. */

			if(cart.isEmpty()) 
			{
				mainMenu.setTopMessage("Your Shopping Cart is empty.");
				mainMenu.setTopPrompt("You have only two options: 1 or 6");
				mainMenu.setBottomMessage("Please enter 1 or 6");
			}
			else if(cart.isFull()) 
			{
				mainMenu.setTopMessage("Your Shopping Cart is full with 5 ice cream orders.");
				mainMenu.setTopPrompt("Cannot place orders! what would you like to do?");
				mainMenu.setBottomMessage("Please select option 2,3,4,5 or 6");
			}
			else
			{
				String topMessage = String.format("Your Shopping Cart contains %d ice cream orders", cart.size());
				mainMenu.setTopMessage(topMessage);
				mainMenu.setTopPrompt("What would you like to do?");
				mainMenu.setBottomMessage(null);
			}

			userChoice = mainMenu.getOptionNumber();
			switch(userChoice)
			{
				case 1:
					placeOrder();
					break;
				case 2:
					deleteOrder();
					break;
				case 3:
					printTotalPrice();
					break;	
				case 4:
					reviewOrders();
					break;
				case 5:
					checkout();
					break;
				case 6:
					System.exit(0);
					break;
			}

		}
	}

}