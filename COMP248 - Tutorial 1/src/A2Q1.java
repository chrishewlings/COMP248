// -------------------------------------------------------
// Assignment 2, Question 1
// Written by: Chris Hewlings
// For COMP 248 Section Q – Fall 2016
// --------------------------------------------------------

import java.util.Scanner;

public class A2Q1 
{
	public static void main(String[] args)
	{
		//print a greeting

		System.out.printf("Encryption Machine\n");
		System.out.printf("------------------\n");
		
		Boolean correctFlag = false;
		
		System.out.printf("Enter a four-digit number: ");
		do
		{
			Scanner read = new Scanner(System.in);
			int int_numberInput = read.nextInt();
			String str_numberInput = "" + int_numberInput;
			
			if(str_numberInput.length() != 4)
			{
				System.out.printf("Wrong length, try again.\n");
			}
			if(str_numberInput.length() == 4)
			{
				System.out.printf("Input accepted.\n");
				correctFlag = true;
			}
		}
		while(correctFlag == false);
		
		
	}
}