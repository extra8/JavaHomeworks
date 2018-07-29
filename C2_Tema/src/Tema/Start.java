package Tema;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

public class Start 
{
	public static void main(String[] args)
	{
		
		Vector<Vehicle> V = new Vector<Vehicle>(10);
		
		Jeep j1 = new Jeep("Jeep #1", 100, 5, 4);
		Frigate f1 = new Frigate("Frigate #1", 30, 300, 1000);
		V.add(j1);
		V.add(f1);
		
		Jeep j2 = new Jeep("Jeep #2", 120, 4, 4);
		Frigate f2 = new Frigate("Frigate #2", 28, 450, 1500);
		V.add(j2);
		V.add(f2);
		
		Jeep j3 = new Jeep("Jeep #3", 110, 5, 4);
		Frigate f3 = new Frigate("Frigate #3", 25, 350, 2000);
		V.add(j3);
		V.add(f3);
		
		Jeep j4 = new Jeep("Jeep #4", 115, 2, 4);
		Frigate f4 = new Frigate("Frigate #4", 20, 325, 1250);
		V.add(j4);
		V.add(f4);
		
		Jeep j5 = new Jeep("Jeep #5", 105, 4, 4);
		Frigate f5 = new Frigate("Frigate #5", 24, 375, 1750);
		V.add(j5);
		V.add(f5);
		
		for (int i = 0; i < V.size(); i++)
		{
			if (V.get(i) instanceof Jeep)
			{
				Jeep j = (Jeep)V.get(i);
				j.drive();
			}
			else
			{
				Frigate f = (Frigate)V.get(i);
				f.launch();
			}
		}	
		
		DisplaySortedVehicles(V);
	}	
	
	public static void DisplaySortedVehicles(Vector<Vehicle> V)
	{		
		SortedMap<String, Vehicle> vehicles = new TreeMap<>();
		
		for (int i = 0 ; i < V.size() ; i++)
		{
			vehicles.put(V.get(i).name,V.get(i));
		}
		System.out.println();;
		System.out.println(vehicles.values());	
	}
}
