// -------------------------------------------------------
// Assignment 1, Question 2
// Written by: Chris Hewlings, #29145958
// For COMP 248 Section Q – Fall 2016
// --------------------------------------------------------

import java.util.Scanner;
import java.lang.Math;

public class A1_p3_29145958
{
  public static void main(String[] args)
  {

    // initializing constants 
    final double ppvCostPerShow = 0.99;
    final double ppvCostPerMovie = 3.99;
    final double unlimitedPlanCost = 25.99;

    // initializing variables

    int showsPerWeek;
    int showsPerMonth;
    int moviesPerMonth;
    
    double totalPpvCost;
    double limitedPackageCost;
    double additionalMovieCharge = 0.0;
    double additionalShowCharge = 0.0;

    // print greeting banner

    String divider = "------------------------------------------------\n";
    String greeting = "CineShow's Package Calculator\n";
    System.out.println(divider + greeting + divider);

    // set up a Scanner object to read in from the keyboard, and prompt the user for input

    Scanner read = new Scanner(System.in);
    
    System.out.print("How many shows a week do you watch (whole number please): ");
    showsPerWeek = read.nextInt();
    System.out.print("How many movies a month do you watch (whole number please): ");
    moviesPerMonth = read.nextInt();

    // calculate costs for Pay Per View plan

    showsPerMonth = showsPerWeek * 4;
    totalPpvCost = showsPerMonth * ppvCostPerShow + moviesPerMonth * ppvCostPerMovie;

    System.out.println("The cost of Pay-per-view would be: $" + totalPpvCost + "/month");

    // determine if Unlimited plan is better

    if((showsPerMonth <= 20) && (moviesPerMonth <= 2)){
        limitedPackageCost = 15.95;    
    }
    else
    {
        // calculate the cost of the Limited package

        if(showsPerMonth > 20)
            additionalShowCharge = (showsPerMonth - 20) * 1.99;
        if(moviesPerMonth > 2)
            additionalMovieCharge = (moviesPerMonth - 2) * 3.99;
        limitedPackageCost = 15.95 + additionalMovieCharge + additionalShowCharge;
    }

    if(limitedPackageCost < totalPpvCost)
    {
        System.out.println("Based on your viewing, the cost of the Limited package would be: $" + limitedPackageCost + "/month");
    }

    // print out recommendation based on calculated totals

    if((limitedPackageCost < totalPpvCost) && (limitedPackageCost < unlimitedPlanCost))
        System.out.println("\n\n**We recommend getting the Limited package.**");

    if((limitedPackageCost > unlimitedPlanCost ) && (totalPpvCost > unlimitedPlanCost) )
        System.out.println("\n\n**We recommend getting the Unlimited package.**");
        
    // say goodbye!

    System.out.println("Thank you for using CineShow's package calculator program.  Happy watching! :-)");

    }
}

