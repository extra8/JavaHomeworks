package Tema;

public class Jeep extends LandVehicle
{	
	public void soundHorn()
	{
		System.out.println("Beep, beep!");
	}
	
	public void drive()
	{
		System.out.println("Vroom, vroom!");
	}
	
	public Jeep(String name, int maxSpeed, int maxPassengers, int numWheels)
	{
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.maxPassengers = maxPassengers;
		this.numWheels = numWheels;		
	}
	
	@Override
	public String toString() 
	{
		System.out.println(name);
		return "";
	}
}
