import java.util.Scanner;
import java.util.regex.*;

// This program simulates a ticket reservation system for a concert or theatre.


public class A3Q2
{

	static void intro() 
	{	// prints out an introductory text and explains the prices
		System.out.println("------------------------------------------------");
		System.out.println("-------COMP 248 Concert IS BACK IN TOWN---------");
		System.out.println("        Hurry book your ticket Now!!            ");
		System.out.println("------------------------------------------------");
		System.out.println("");

		System.out.println("Rows 1 & 2 Gold  \t100 CAD/ticket");
		System.out.println("Rows 3 & 4 Silver\t70 CAD/ticket");
		System.out.println("Rows 5 & 6 Bronze\t40 CAD/ticket");
	}

	static void printRows(String[][] seats)
	{
		// prints out the seat chart in a grid format.

		for(int rowCount = 0; rowCount < seats.length; rowCount++)
		{
			System.out.printf((rowCount+1)+" ");
			for(int columnCount = 0; columnCount < seats[rowCount].length; columnCount++)
				System.out.printf(seats[rowCount][columnCount] + " ");
			System.out.println("");
		}		
	}

	static Boolean isInputValid(String whatSeat)
	{ 

	  // using the builtin regex engine to validate input
	  // without long switch/case and/or nested ifs
	 
		String pattern = "[1-6][a-gA-G]";
		Pattern regex = Pattern.compile(pattern);
		Matcher match = regex.matcher(whatSeat);

		if(match.matches())
			return true;
		else return false;
	}

	static int seatsLeft(String[][] seats)
	{
		// calculates, prints, and returns remaining seats, based on how many are crossed out. 

		int remaining = (seats.length * seats[0].length); // assumes all rows are same length

		for(int rowCount = 0; rowCount < seats.length; rowCount++)
			for(int columnCount = 0; columnCount < seats[rowCount].length; columnCount++)
				if(seats[rowCount][columnCount] == "X")
					remaining--;
		System.out.println("Available seats " + remaining);
		return remaining;
	} 
	
	static int getColumnIndex(String columnLetter)
	{
		// subtracting UPPERCASE_ASCII_TRANSLATE from an (uppercase) alphabetic value gives
		// between 0-25 so this translates the ASCII decimal value into an index to
		// the Latin alphabet, by casting it to an int.
		
		final int UPPERCASE_ASCII_TRANSLATE = 65; 

		columnLetter = columnLetter.toUpperCase();
		char c = columnLetter.charAt(0);
		return ((int) c - UPPERCASE_ASCII_TRANSLATE);
	}

	static String[][] reserveSeat(String[][] seats, String userInput)
	{ 
		// does the actual reservation of the seat.
		// Splits the users validated input into row and column and 
		// checks it off (or not) in the seat chart, depending
		// if it's still available or not.

		int row = Integer.parseInt(userInput.substring(0,1));
		int column = getColumnIndex(userInput.substring(1,2));

		if( seats[row - 1][column] == "X" ) // checks if seat is already crossed off
		{
			System.out.println("Sorry seat is not available\n");
			printRows(seats);
			return seats;
		} else 
		{
			seats[row - 1][column] = "X"; // Crosses out the seat on the chart
			System.out.printf("Your seat is reserved. Your balance is $%.2f\n", calcBalance(seats));
			printRows(seats);
			return seats;	
		}
	}

	static double calcBalance(String[][] seats)
	{
	// calculates current balance based on the seats that have been selected. 

		final int GOLD_TICKET_COST = 100;
		final int SILVER_TICKET_COST = 70;
		final int BRONZE_TICKET_COST = 40;

		int numGold = 0;
		int numSilver = 0; 
		int numBronze = 0;
		double balance = 0.0;


		for(int rowCount = 0; rowCount < 2; rowCount++)
			for(int columnCount = 0; columnCount < seats[rowCount].length; columnCount++)
				if(seats[rowCount][columnCount] == "X")
					numGold++;

		for(int rowCount = 2; rowCount < 4; rowCount++)
			for(int columnCount = 0; columnCount < seats[rowCount].length; columnCount++)
				if(seats[rowCount][columnCount] == "X")
					numSilver++;

		for(int rowCount = 4; rowCount < seats.length ; rowCount++)
			for(int columnCount = 0; columnCount < seats[rowCount].length; columnCount++)
				if(seats[rowCount][columnCount] == "X")
					numBronze++;

			balance = (numGold * GOLD_TICKET_COST) + (numSilver * SILVER_TICKET_COST) + (numBronze * BRONZE_TICKET_COST);
			return balance;
	}


	public static void main(String[] args)
	{				

		// variables for main function

		int howManySeats,innerLoopCounter = 0;
		String whatSeat, continueResponse = "";
		double balance = 0.0;
		Boolean continueFlag = true;

		String[][] seats={ {"A","B","C","D","E","F","G"}, // make a 2d array of the seat chart
						   {"A","B","C","D","E","F","G"}, // the spacing is for readability 
						   {"A","B","C","D","E","F","G"}, 
						   {"A","B","C","D","E","F","G"},
						   {"A","B","C","D","E","F","G"},
						   {"A","B","C","D","E","F","G"} };	


		intro();
		seatsLeft(seats);

		Scanner input = new Scanner(System.in);

		while(continueFlag == true) // loop responsible for asking the user to continue booking after first booking is complete
		{

			innerLoopCounter = 0;

			System.out.printf("How many tickets do you need?\n");
			howManySeats = input.nextInt();

			if(howManySeats > seatsLeft(seats)) 
			{
				// tests to see if the user has requested more seats than what are available
				// and quits if there won't be enough. 
				System.out.printf("Sorry, cannot process your request\nNot enough seats are available\nThank you for choosing our reservation system!!\n");
				System.exit(1);
			}

			while(innerLoopCounter < howManySeats)
			{
				System.out.printf("Input your seat selection?\n");
				System.out.printf("Enter the row number and then the seat letter (example: 3B)\n");
				whatSeat = input.next();

				if(isInputValid(whatSeat) == true)
				{
					reserveSeat(seats, whatSeat);
					innerLoopCounter++;
				} else 
					System.out.printf("Invalid seat selection, please try again.\n");
			}

		System.out.printf("Reservation complete! Please proceed to payment\n");
		

		// ask user to continue and parse their response.
		System.out.printf("Do you wish to start a new booking? (y/n) ");
		continueResponse = input.next();
		continueResponse = continueResponse.toUpperCase();

		switch(continueResponse)
		{
			case "Y":
			case "YES":
				continueFlag = true;
				break;
			case "N":
			case "NO":
				continueFlag = false;
				break;
			default:
				System.out.printf("Invalid input, quitting...");
				System.exit(1);
		}

		}


	}

}