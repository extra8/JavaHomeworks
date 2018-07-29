package Tema;

import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;


public class Start 
{	
	private double maxRadius = 10;
	private double minRadius = 1;
	
	SortedMap<Double,Circle> circles = new TreeMap<>();
	
	public static void main(String[] args)
	{
		Start s = new Start();
		s.generate();
		s.displayRadius();
		s.displayArea();
	}
	
	public void generate()
	{
		Random random = new Random();
		Double radius = null;
		boolean ok = true;
		int counter = 1;
		
		while(ok)
		{
			String circleName = "Circle" + counter;
			radius = random.nextDouble()*(maxRadius-minRadius) + minRadius;
			Circle c =  new Circle(radius, circleName);
			if (radius >= 2) circles.put(radius,c);
			else ok = false;
			counter++;
		}
	}
	
	private void displayArea()
	{
		System.out.println("Displaying the area of each generated circle:");
		for(Map.Entry<Double,Circle> entry : circles.entrySet()) 
		{
			  //double key = entry.getKey();
			  Circle value = entry.getValue();
			  System.out.println(value.toString() + "	" + value.area() + " units^2");
		}
		System.out.println();
	}	
	
	private void displayRadius()
	{
		System.out.println("Displaying the radius of each generated circle:");
		for(Map.Entry<Double,Circle> entry : circles.entrySet()) 
		{
			  double key = entry.getKey();
			  Circle value = entry.getValue();
			  System.out.println(value.toString() + "	" + key + " units");
		}
		System.out.println();
	}
}