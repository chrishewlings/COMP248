class ShoppingCart
{
	final int MAX_ITEMS = 5; // constant to define maximum number of orders
	int filledSlots = 0; // index to keep track of how many slots are filled

	IceCreamOrder[] cart = new IceCreamOrder[MAX_ITEMS];

	public ShoppingCart()
	{
		IceCreamOrder[] cart = new IceCreamOrder[MAX_ITEMS];
	}

	// methods to manipulate cart contents

	void add(IceCreamOrder order)
	{
		// error condition, but shouldn't ever run, 
		// due to checking in calling class.  
		if(filledSlots >= MAX_ITEMS)
			System.out.println("Error");
		else // if no error, add to cart and increment index.
		{
			cart[filledSlots] = order;
			filledSlots++; 
		}
	}

	void remove(int position)
	{
		// check for range errors
		if( (position < 0) || (position > MAX_ITEMS ) ) 
			System.out.println("Error");
		if( this.isEmpty() )
			System.out.println("Error");
		else // and proceed if no errors found.
			this.cart[position] = null;
			filledSlots--;
	}

	IceCreamOrder get(int position)
	{
		if( (position < 0 ) || ( position > MAX_ITEMS ) )
		{
			System.out.println("Error");
			return null;
		}
		else return this.cart[position];
	}


	// methods to display contents of cart and check object attributes

	public String toString()
	{
		String contentsString = "";
		
		for(int index = 0; index < MAX_ITEMS; index++ )
			if(cart[index] != null)
				contentsString += cart[index].toString() + "\n";
		
		return contentsString;
	}

	boolean isEmpty()
	{
		if(filledSlots == 0)
			return true;
		else return false;		
	}

	boolean isFull()
	{
		if(filledSlots == MAX_ITEMS)
			return true;
		else return false;
	}

	int size()
	{
		int count = 0;
		for(int i = 0; i < MAX_ITEMS; i++)
		{
			if(this.cart[i] != null)
				count++;
		}
		return count;
	}

}