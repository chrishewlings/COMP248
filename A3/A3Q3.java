public class A3Q3 
{

	// This program uses the Scale object found in Scale.java to represent the weight of different people
	// in this example, i'm using jim, michaael, and stanley as the objects
	// It constructs these objects then uses accessor methods to display their values
	// as well as mutators to modify their values and representations, and uses the built in Boolean 
	// comparison functions from the Scale class to compare the characteristics of different instances. 
	

	public static void main(String[] args)
	{
		// set up 3 objects of type Scale

		Scale jim = new Scale(176,"lbs");
		Scale michael = new Scale(86,"kg");
		Scale stanley = new Scale(105,"kg");

		
		// print their weights in KG

		System.out.printf("\nWEIGHTS IN KILOGRAMS:\n");
		System.out.printf("---------------------\n");

		System.out.printf("Jim weighs %.2fkg\n", jim.getWeightInKg());
		System.out.printf("Michael weighs %.2fkg\n", michael.getWeightInKg());
		System.out.printf("Stanley weighs %.2fkg\n", stanley.getWeightInKg());

		// print their weights in LB
		
		System.out.printf("\nWEIGHTS IN POUNDS:\n");
		System.out.printf("------------------\n");

		System.out.printf("Jim weighs %.2flbs\n", jim.getWeightInLbs());
		System.out.printf("Michael weighs %.2flbs\n", michael.getWeightInLbs());
		System.out.printf("Stanley weighs %.2flbs\n", stanley.getWeightInLbs());
		
		// Based on their daily exercise routines, display recommended water intake

		System.out.printf("\nRECOMMENDED WATER INTAKE:\n");
		System.out.printf("---------------------------\n");

		System.out.printf("Jim exercises 90 minutes a day, and should drink %.2f cups of water.\n", jim.waterIntakeWithExercise(90));
		System.out.printf("Michael exercises 30 minutes a day, and should drink %.2f cups of water.\n", michael.waterIntakeWithExercise(30));
		System.out.printf("Stanley doesn't exercise, and should drink %.2f cups of water.\n", stanley.waterIntake());


		System.out.printf("\n\n");

		// Using mutator method to increase weight of one of the Scale objects

		jim.setWeightAndUnit(jim.getWeightInKg() + 6.0, "kg");
		System.out.printf("Jim gained 6 kilograms.\n");

		// Using boolean methods to compare two instances of Scale object

		if(jim.equals(michael))
			System.out.printf("Jim now weighs the same as Michael.\n");
		if(michael.isLessThan(stanley))
			System.out.printf("Michael weighs less than Stanley.\n");
		if(stanley.isGreaterThan(jim))
			System.out.printf("Stanley weighs more than Jim.\n");



	}
}
