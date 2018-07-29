package vehicleRentalPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start 
{	

	public static void main(String[] args)
	{

		VehicleLogic vl = new VehicleLogic();
		
		Vehicle v1 = new Vehicle("Volvo", 2012, "B 01 VRV", "Blue", CarType.MASINA); 
		Vehicle v2 = new Vehicle("Dacia", 2008, "B 01 VRD", "White", CarType.SCOOTER); 
		Vehicle v3 = new Vehicle("Seat", 2000, "B 25 VRS", "Red", CarType.MASINA); 
		Vehicle v4 = new Vehicle("Dacia", 2015, "B 76 VRD", "Black", CarType.RULOTA); 
		Vehicle v5 = new Vehicle("BMW", 2000, "B 805 VRB", "White", CarType.MASINA); 
		
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		vehicleList.add(v1);
		vehicleList.add(v2);
		vehicleList.add(v3);
		vehicleList.add(v4);
		vehicleList.add(v5);
		
		
		System.out.println("Order by year or by brand?");
		System.out.println("   1. By year");
		System.out.println("   2. By brand");
		System.out.println("   3. By type");
		System.out.println("   4. Show all");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch(option)
		{
			case 1 : vl.viewSortVehiclesByYear(vehicleList); 
					 break;
			case 2 : vl.viewSortVehiclesByBrands(vehicleList); 
					 break;
			case 3 : vl.viewSortVehiclesByType(vehicleList);
					 break;
			case 4 : vl.viewAllVehicles(vehicleList); 
					 break;
			default : System.out.println("Invalid option!");
					  break;
		}
			
		sc.close();		
	}
	
}
