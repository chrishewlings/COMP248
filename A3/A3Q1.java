import java.util.Scanner;
import java.lang.Math;

// This program asks the user for a variable length list of nouns and adjectives
// and then randomizes them, and outputs a poem mixing the nouns and adjectives together
// once each to a line. 

public class A3Q1
{
	static String[] shuffleArray(String[] arrayToRandomize) //array shuffle function
	{
		
		for(int i = arrayToRandomize.length - 1; i > 0 ; i--) 
		// start from the top of the array, count down, and grab an index between 0 and i
		// then swap current index with the random one
		// and return a shuffled copy of the original array
		{
			int randomRemainingIndex = (int) ((Math.random() * i));
			String temp = arrayToRandomize[i];
			arrayToRandomize[i] = arrayToRandomize[randomRemainingIndex];
			arrayToRandomize[randomRemainingIndex] = temp;
		}
		
		return arrayToRandomize;
	}

	static String[] capitalizeArray(String[] arrayToCapitalize) // function to capitalize all strings in a String[] array
	{
		for(int j = 0; j < arrayToCapitalize.length; j++)
		{
			arrayToCapitalize[j] = arrayToCapitalize[j].toUpperCase();
		}
		return arrayToCapitalize;
	}

	static void printPoem(String[] nounArray, String[] adjArray) // does the actual printing of the poem content
	{
		// print <adjective> <noun> in all caps, like in example

		System.out.printf("\n\n");
		
		System.out.printf("%s %s\n", adjArray[0], nounArray[0]); // It just grabs the 
		System.out.printf("\t%s %s\n", adjArray[1], nounArray[1]); // first three indices, 
		System.out.printf("\t\t%s %s\n", adjArray[2], nounArray[2]); // as they're already randomized

		System.out.printf("\n\n");
	}

	public static void main(String[] args)
	{

		//defining constants and global variables

		final int MIN_NOUNS = 3;
		final int MIN_ADJECTIVES = 3;

		int nounCount = 0;
		int adjCount = 0;

		
		Scanner input = new Scanner(System.in);
		
		// ask for nouns

		System.out.printf("How many nouns? min %d\n", MIN_NOUNS);
		nounCount = input.nextInt();
		String[] nouns = new String[nounCount];

		System.out.printf("Enter %d nouns\n", nounCount);
		for(int i = 0; i < nouns.length; ++i)
		{
			nouns[i] = input.next();
		}

		// ask for adjectives

		System.out.printf("How many adjectives? min %d\n", MIN_ADJECTIVES);
		
		adjCount = input.nextInt();
		String[] adjectives = new String[adjCount];

		System.out.printf("Enter %d adjectives\n", adjCount);
		for(int j = 0; j < adjectives.length; j++)
		{
			adjectives[j] = input.next();
		}
		
		// print banner

		System.out.printf("----------------------------\n");
		System.out.printf("   Here is my Java POEM!!   \n");
		System.out.printf("   ****LOOK AROUND****\n");
		System.out.printf("----------------------------\n");

		

		String[] nounsShuffled = capitalizeArray(shuffleArray(nouns));
		String[] adjShuffled = capitalizeArray(shuffleArray(adjectives));

		//String[] upperCase_nounsShuffled = shuffleArray(nouns);
		//String[] upperCase_adjShuffled = shuffleArray(adjectives);

		printPoem(nounsShuffled, adjShuffled);

		
		// prints a goodbye message!

		System.out.printf("Thank you for using our JAVA POEM GENERATOR\n");

	}
}
