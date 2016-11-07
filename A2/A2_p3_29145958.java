// -------------------------------------------------------
// Assignment 2, Question 3
// Written by: Chris Hewlings
// For COMP 248 Section Q – Fall 2016
// --------------------------------------------------------

import java.lang.Math;

/* -----------------
   class definitions
   ----------------- */

// defines a class Player to represent Player 1, Player 2, etc.
// holds the players' scores and win/lose status
class Player
{

	public String name; 

	Boolean hasBody = false;
	Boolean hasHead = false;
	Boolean hasTrunk = false;
	Boolean hasTail = false;

	int numEars = 0;
	int numLegs = 0;

	Boolean winFlag = false;

	public Player(String playerName)
	{
		name = playerName;
	}

	//class method to show Player score in format shown in assignment instructions
	void printScore() 
	{
		String trunkStr = hasTrunk ? "a" : "no";
		String headStr = hasHead ? "a" : "no";
		String bodyStr = hasBody ? "a" : "no";
		String tailStr = hasTail ? "a" : "no";
		String earStr = (numEars > 0) ? String.valueOf(numEars) : "no";
		String legStr = (numLegs > 0) ? String.valueOf(numLegs) : "no";
		
		System.out.printf("%s's elephant has %s body, %s head, %s ear(s), %s trunk, %s tail, and %s leg(s).\n",
					   name, bodyStr, headStr, earStr, trunkStr, tailStr, legStr);
	}

	Boolean isWinner()
	{
		if(hasBody && hasHead && hasTrunk && hasTail && (numEars == 2) && (numLegs == 4))
			winFlag = true;
	return winFlag;
	}
}



public class A2_p3_29145958 
{

	/* --------------------
	   function definitions
	   -------------------- */

	// generates a random number between 1 and 6
	public static int rollDice()
	{
			int diceRoll = (int) (Math.random() * 6) + 1;
			return diceRoll;
	}

	// takes a number from 1 - 6 and assigns the player a body part based on conditions
	public static void whichBodyPart(int rolledNumber, Player player)  
	{
		switch(rolledNumber)
		{
			case 1: // trunk
				if(player.hasHead == true) // only add trunk if head (and body) are present
					player.hasTrunk = true;
				break;

			case 2: // head
				if(player.hasBody == true) // only add head if body is present
					player.hasHead = true;
				break;

			case 3: //body
				player.hasBody = true; 
				break;

				case 4: //tail
				if(player.hasBody = true) // only add tail if body is present
					player.hasTail = true;
				break;

			case 5: //leg
				if(player.hasBody = true) // only add legs if body is present
					if(player.numLegs < 4)  // if Player already has 4 legs, discard result and move on
						player.numLegs++;
				break;

			case 6: //ear
				if(player.hasHead == true) // only add ears if head (and body) are present
					if(player.numEars < 2) // if Player already has 2 ears, discard result and move on
						player.numEars++;
				break;

			default: 
				System.out.printf("Something went wrong. Terminating program...\n");
				System.exit(1);
		} 
	}

	/* ----------------------
	   start of main function
	   ---------------------- */

	public static void main(String[] args)
	{

	// initialize variables and objects used in main function

		int counter = 1; 
		String winningPlayer = ""; 

		Player playerOne = new Player("Player 1");
		Player playerTwo = new Player("Player 2");

		// print greeting
		System.out.printf("-----------------------------------------\n");
		System.out.printf("     Chris' Elephant Drawing Game\n"     );
		System.out.printf("-----------------------------------------\n");

		// main game loop, runs until one player fulfills win condition described in assignment, i.e. all body parts present

		while( (playerOne.isWinner() == false) && (playerTwo.isWinner() == false) )
		{
			int playerOneRoll = rollDice();
			int playerTwoRoll = rollDice();

			whichBodyPart(playerOneRoll, playerOne);
			whichBodyPart(playerTwoRoll, playerTwo);

			System.out.printf("Status after round %d:\n", counter);
			System.out.printf("\tPlayer 1 rolled a %d while Player 2 rolled a %d.\n", playerOneRoll, playerTwoRoll);

			playerOne.printScore();
			playerTwo.printScore();
			System.out.printf("\n");

			counter++;
		}

		if(playerOne.isWinner() && playerTwo.isWinner())
		{
			winningPlayer = "";
			System.out.printf("It's a tie! Neither player wins!\n");
			System.exit(0);
		}
		else if(playerOne.isWinner())
			winningPlayer = playerOne.name;
		else if(playerTwo.isWinner())
			winningPlayer = playerTwo.name;
		else 
		{
			System.out.printf("An error has occurred.  Terminating program...\n");
			System.exit(1);
		}

		System.out.printf(">>>>>   Congratulations to %s !!! Your elephant is complete! <<<<<\n\n", winningPlayer);
		System.out.printf("Hope you enjoyed drawing elephants!\n");
		
	}
}
