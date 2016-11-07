// -------------------------------------------------------
// Assignment 2, Question 2
// Written by: Chris Hewlings
// For COMP 248 Section Q – Fall 2016
// --------------------------------------------------------

import java.util.Scanner;

public class A2_p2_29145958 
{
	public static void main(String[] args)
	{
		// initialize variables

		String userInput = "";
		Scanner read = new Scanner(System.in);
		int counter = 0; 
		char[] revCharArray = new char[5];
		
		// greeting
		System.out.printf("Password Generator\n");
		System.out.printf("------------------\n");

		// ask for user input 

		System.out.printf("Please enter a 5 character word which will be used to generate a password:\n");
		userInput = read.next();

		// check if string is valid
		if(userInput.length() != 5)
		{	
			System.out.printf("Sorry, but that is not a 5-character string.  Program will terminate.\n\n");
			System.out.printf("Thank you for using Chris' Password Generator program.\n");
			System.exit(1);
		}
		else
		{

			// loop over user input and extract characters individually

			while(counter < userInput.length()) 
			{
				revCharArray[counter] = userInput.charAt(userInput.length() - counter - 1); // reverse the string char by char into an array
				int convertedToNumber = revCharArray[counter] - 7 ; // modify character ASCII value by subtracting 7, convert char to int to avoid lossy conversion
				revCharArray[counter] = (char) convertedToNumber; // cast back to char in same place in array
				counter++;
			}

			counter = 0;
			String finalOutput = "";
			while(counter < revCharArray.length) // convert character array to a new String finalOutput
			{
				finalOutput = finalOutput + revCharArray[counter];
				counter++;
			}

			System.out.printf("Your password is %s\n\n", finalOutput);
			System.out.printf("Thank you for using Chris' Password Generator program.\n");
		}
	}
}
