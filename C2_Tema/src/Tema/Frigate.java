package Tema;

public class Frigate extends SeaVessel
{	
	public void fireGun()
	{
		System.out.println("Bombs away!");
	}
	
	public void launch()
	{
		System.out.println("Full speed ahead!");
	}
	
	public Frigate(String name, int maxSpeed, int maxPassengers, int displacement)
	{
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.maxPassengers = maxPassengers;
		this.displacement = displacement;		
	}
	
	@Override
	public String toString() 
	{
		System.out.println(name);
		return "";
	}	
}
