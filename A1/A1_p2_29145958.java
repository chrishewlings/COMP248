// -------------------------------------------------------
// Assignment 1, Question 2
// Written by: Chris Hewlings, #29145958
// For COMP 248 Section Q – Fall 2016
// --------------------------------------------------------

import java.util.Scanner;
import java.lang.Math;

public class A1_p2_29145958
{

    public static void main(String[] args) 
    {
        // print greeting

        String divider = "------------------------------------------------\n";
        String greeting = "Pick a number, any number...\n";

        System.out.println(divider + greeting + divider);

        Scanner read = new Scanner(System.in);

        //create a random number

        int numberToGuess = (int) (Math.random() * 100.0);

        int counter = 0;

        while(counter < 5) // loop 5 times or until guess == numberToGuess 
        {
          if (counter >= 1)
            System.out.print("Guess again: ");
          else
            System.out.print("Pick a number between 0 and 100 (you have 5 guesses!): ");

          int guess = read.nextInt();
          
          if (guess < numberToGuess)
          {
            System.out.println("Too low!");
            counter++;
          }

          if (guess > numberToGuess)
          {
            System.out.println("Too high!");
            counter++;
          }

          if (guess == numberToGuess)
          {
            System.out.println("You got it! it is indeed: " + numberToGuess);
            System.exit(0);
          }
        }
        System.out.println("Sorry you didn't guess the right number.  The correct number is: " + numberToGuess + ". Better luck next time!");
    }
}

