 // -------------------------------------------------------
 // Assignment 1, Question 1
 // Written by: Chris Hewlings, #29145958
 // For COMP 248 Section Q – Fall 2016
 // --------------------------------------------------------

 // Program to collect information about makeup of student population in class.

import java.util.Scanner;

public class A1_p1_29145958 {
    public static void main(String[] args)
    {
        // print greeting message

        String divider = "------------------------------------------------\n";
        String greeting = "Student Stats -- Where are they coming from?\n";

        System.out.println(divider + greeting + divider);

        // take input from user three times for required information

        Scanner read = new Scanner(System.in);

        System.out.println("How many in-province students are there? ");
        int numInProvinceStudents = read.nextInt();

        System.out.println("How many out-of-province students are there? ");
        int numOutOfProvinceStudents = read.nextInt();

        System.out.println("How many international students are there? ");
        int numInternationalStudents = read.nextInt();

        // calculate total number of students

        int numTotalStudents = numInProvinceStudents + numInternationalStudents + numOutOfProvinceStudents;

        // using collected data and numTotalStudents, calculate percentages

        float percentInProvinceStudents = (float) numInProvinceStudents / (float) numTotalStudents;
        float percentOutOfProvinceStudents = (float) numOutOfProvinceStudents / (float) numTotalStudents;
        float percentInternationalStudents = (float) numInternationalStudents / (float) numTotalStudents;

        // print results of calculations

        System.out.println("Great! There are " + numTotalStudents + " students in the class.");
        System.out.println("\tIn-province students: " + percentInProvinceStudents + " or ~" + percentInProvinceStudents*100 + "%");
        System.out.println("\tOut of province students: " + percentOutOfProvinceStudents + " or ~" + percentOutOfProvinceStudents*100 + "%");
        System.out.println("\tInternational students: " + percentInternationalStudents + " or ~" + percentInternationalStudents*100 + "%");
    }
}
