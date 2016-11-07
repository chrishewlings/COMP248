import java.util.Scanner;

public class A3Q2
{
	
	public static void intro()
	{
		System.out.println("------------------------------------------------");
		System.out.println("-------COMP 248 Concert IS BACK IN TOWN---------");
		System.out.println("        Hurry book your ticket Now!!            ");
		System.out.println("------------------------------------------------");
		System.out.println("");

		System.out.println("Rows 1 & 2 Gold  \t100 CAD/ticket");
		System.out.println("Rows 3 & 4 Silver\t70 CAD/ticket");
		System.out.println("Rows 5 & 6 Bronze\t40 CAD/ticket");
	}

	public static String askSeat()
	{
		Boolean inputValidation = false;

		do
		{

			System.out.println("Input your seat selection");
			System.out.println("Enter the row number and then the seat letter (example: 3B)");

			Scanner keyboardInput = new Scanner(System.in);
			String userResponse = keyboardInput.next();
			if(userResponse.length() == 0 || userResponse.length() > 2)
				System.out.println("Invalid seat assignment.");
			
			return userResponse;
		} while(inputValidation == false);

	}

	public static String askUser(String question)
	{
		// basic method to ask for user input and close the handle afterwards.

		Scanner keyboardInput = new Scanner(System.in);
		System.out.println(question);
		String userResponse = keyboardInput.next();
		return userResponse;
	}

	public static void seatsLeft(String[][] seats)
	{
		// calculates remaining seats based on how many are crossed out. 

		int remaining = (seats.length * seats[0].length); // assumes all rows are same length

		for(int rowCount = 0; rowCount < seats.length; rowCount++)
			for(int columnCount = 0; columnCount < seats[rowCount].length; columnCount++)
				if(seats[rowCount][columnCount] == "X")
					remaining--;
		System.out.println("Available seats " + remaining);
	} 
		
	public static void printRows(String[][] seats)
	{
		// prints out the (remaining) seats in a grid format.

		for(int rowCount = 0; rowCount < seats.length; rowCount++)
		{
			System.out.printf((rowCount+1)+" ");
			for(int columnCount = 0; columnCount < seats[rowCount].length; columnCount++)
				System.out.printf(seats[rowCount][columnCount] + " ");
			System.out.println("");
		}		
	}

	public static int getColumnIndex(String columnLetter)
	{
		// converts letter value to column number.

		columnLetter = columnLetter.toUpperCase();
		switch(columnLetter)
		{
			case "A":
				return 0;
				
			case "B":
				return 1;
				
			case "C":
				return 2;
				
			case "D":
				return 3;
				
			case "E":
				return 4;
				
			case "F":
				return 5;
				
			case "G":
				return 6;

			default:
				return -1; // error condition
		}
	}

	public static void main(String[] args)
	{
		
		// constants

		final int GOLD_TICKET_COST = 100;
		final int SILVER_TICKET_COST = 70;
		final int BRONZE_TICKET_COST = 40;


		// initializing global variables for main function

		String whichSeat, sWhichColumn = ""; // s prefix for String value;
		int numTickets, whichRow, iWhichColumn = 0; // i prefix for integer value
		
		int numGold = 0;
		int numSilver = 0;
		int numBronze = 0;
		
		double balance = 0.0;

		String[][] seats={ {"A","B","C","D","E","F","G"}, // make a 2d array of the seat chart
						   {"A","B","C","D","E","F","G"}, // n.b. spacing for readability 
						   {"A","B","C","D","E","F","G"}, 
						   {"A","B","C","D","E","F","G"},
						   {"A","B","C","D","E","F","G"},
						   {"A","B","C","D","E","F","G"} };
			
		intro();
		seatsLeft(seats);

		numTickets = Integer.parseInt(askUser("How many tickets do you need?"));

		for(int ticketNumber = 0 ; ticketNumber < numTickets ; ticketNumber++)
		{

			whichSeat = askSeat();
			whichRow = Integer.parseInt( whichSeat.substring(0,1) ); //grab first character as substring, convert to int, and use as row number

			switch(whichRow) // increment one of the three ticket types based on row input
			{
				case 1:
				case 2:
					numGold++;
					break;
				case 3:
				case 4:
					numSilver++;
					break;
				case 5:
				case 6:
					numBronze++;
					break;
				default: 
					System.out.println("Incorrectly formatted input, quitting...");
					System.exit(1);
			}

			sWhichColumn = whichSeat.substring(1,2); // grabs second character as a substring and 
			iWhichColumn = getColumnIndex(sWhichColumn); // converts it to an int
			
			seats[whichRow - 1][iWhichColumn] = "X"; // Crosses out the seat on the chart

			balance = (numGold * GOLD_TICKET_COST) + (numSilver * SILVER_TICKET_COST) + (numBronze * BRONZE_TICKET_COST);
			
			printRows(seats);
			System.out.printf("Your seat is reserved.  Your balance is %.1f\n", balance);
			
			

		}


	}
}