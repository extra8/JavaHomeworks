package Tema;

public class Circle 
{
	private Double radius;
	private String circleName;
	
	public Circle(Double radius,String circleName)
	{
		this.radius = radius;
		this.circleName = circleName;
	}
	
	public Double area()
	{
		return Math.PI * Math.pow(radius , 2);	
	}
	
	@Override
	public String toString()
	{
		return circleName + " : ";
	}	
}
