public class Scale
{
	//constants

	final int OZ_PER_CUP = 8;
	final double KG_PER_LB = 1/2.2;
	final double LB_PER_KG = 2.2;

	// instance variables

	private double weight;
	private String unit;

	//constructor methods


	public Scale()
	{
		weight = 0;
		unit = "kg";
	}

	public Scale(double weight)
	{
		this.weight = weight;
		unit = "kg";
	}

	public Scale(double weight, String unit)
	{
		this.weight = weight;
		this.unit = unit;
	}

	//accessor methods

	public double getWeightInKg()
	{
		if(unit == "kg")
			return weight;
		else return (weight * KG_PER_LB);
	}

	public double getWeightInLbs()
	{
		if(unit == "lbs")
			return weight;
		else return (weight * LB_PER_KG);
	}

	// mutator methods

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public void setWeightAndUnit(double weight, String unit)
	{
		this.weight = weight;
		this.unit = unit;
	}

	// other methods

	public double waterIntake()
	{
		double waterIntake;
		double weightInLbs;

		if(unit == "lbs")
		{
			waterIntake = weight / 2 / OZ_PER_CUP;
			return waterIntake;
		}
		else
			weightInLbs = weight * LB_PER_KG;
			waterIntake = ((weightInLbs / 2) / OZ_PER_CUP);
			return waterIntake;
	}

	public double waterIntakeWithExercise(double minutesOfExercise)
	{
		double baseIntake = waterIntake();
		double additionalIntake = (12 * (minutesOfExercise / 30)) / OZ_PER_CUP ;

		return (baseIntake + additionalIntake);

	}

	// override methods -- overrides methods that would be inherited from other classes

	public String toString() // prints a stringified version of the instances variables
	{
		return (weight+unit);
	}

	public boolean equals(Scale secondObj) // compares two objects and returns true if they're equal
	{
		if(secondObj.getWeightInLbs() == this.getWeightInLbs())
			return true;
		else return false;
	}

	public boolean isLessThan(Scale secondObj) // compares two objects and returns true obj1 < obj2
	{
		if(this.getWeightInLbs() < secondObj.getWeightInLbs())
			return true;
		else return false;
	}

	public boolean isGreaterThan(Scale secondObj) // compares two objects and returns true obj 1 > obj2
	{
		if(this.getWeightInLbs() > secondObj.getWeightInLbs())
			return true;
		else return false;
	}
}
