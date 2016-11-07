// -------------------------------------------------------
// Assignment 2, Question 1
// Written by: Chris Hewlings
// For COMP 248 Section Q – Fall 2016
// --------------------------------------------------------

import java.util.Scanner;

public class A2_p1_29145958 
{
	public static void main(String[] args)
	{
		
		// global variable initialization

		int int_numberInput;
		Boolean correctFlag = false;

		int digitOne, digitTwo, digitThree, digitFour;
		int digitOneTransformed, digitTwoTransformed, digitThreeTransformed, digitFourTransformed;

		//print a greeting

		System.out.printf("Encryption Machine\n");
		System.out.printf("------------------\n");
		
		
		
		System.out.printf("Enter a four-digit number:\n");
		Scanner read = new Scanner(System.in);

		int_numberInput = read.nextInt();
		String str_numberInput = "" + int_numberInput;
		
		if(str_numberInput.length() != 4) // loop again if length isn't 4 
		{
			System.out.printf("Wrong length, program will terminate.\n");
			System.exit(1);
		}
		// extract each digit individually

		digitOne = int_numberInput / 1000;
		digitTwo = int_numberInput / 100 % 10;
		digitThree = int_numberInput / 10 % 10;
		digitFour = int_numberInput % 10; 

		// transform the original digits based on the criteria given

		digitOneTransformed = (digitThree + 7) % 10;
		digitTwoTransformed = (digitFour + 7) % 10;
		digitThreeTransformed = (digitOne + 7) % 10;
		digitFourTransformed = (digitTwo + 7) % 10;
		
		// print out encrypted result

		System.out.printf("The encrypted version of your input is %d%d%d%d\n", digitOneTransformed,
																			 digitTwoTransformed,
																			 digitThreeTransformed,
																			 digitFourTransformed);

		System.out.printf("Thanks for using this encryption machine!\n");

	}
}