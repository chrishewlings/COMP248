class Scale
{
	double weight;
	String unit;

	double getWeightKg()
	{
		if(this.unit == "lbs")
			return (this.weight / 2.2);
		else return this.weight;
	}

	double getWeightLb()
	{
		if(this.unit == "lbs")
			return this.weight;
		else return (this.weight * 2.2);
	}

	void setWeight(double weight)
	{
		this.weight = weight;
	}

	void setWeightAndUnit(double weight, String unit)
	{
		this.weight = weight;
		this.unit = unit;
	}

	public Scale()
	{
		weight = 0.0;
		unit = "kg";
	}

	public Scale(double weight)
	{
		weight = this.weight;
		unit = "kg";
	}
	public Scale(double weight, String unit)
	{	
		weight = this.weight;
		unit = this.unit;
	}
	public int waterIntake()
	{
		if(this.unit == "kg")
			double weightInLbs = (this.weight * 2.2);
		else weightInLbs = this.weight;

		return ( (int) weightInLbs / 2)
		

		return ((int) weight / 2)
	}




}

public class A3Q3
{
	public static void main(String[] args)
	{

	}
}