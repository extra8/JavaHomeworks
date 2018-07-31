package vehicleRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contract_Implementation.Contract;
import contract_Implementation.ContractsLogic;
import person_Implementation.Person;
import person_Implementation.PersonLogic;
import vehicle_Implementation.Vehicle;
import vehicle_Implementation.VehicleLogic;

public class Start 
{	
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("	1. View vehicles ");
		System.out.println("	2. View persons ");
		System.out.println("	3. New contract ");
		
		int option = sc.nextInt();
		
		if (option == 1) 
			vehicleOptions();
		else if (option == 2) 
			personOptions();
		else if (option == 3) 
			newContract();
		else
			System.out.println("Invalid option!");

		sc.close();	
	}
	
	public static void vehicleOptions()
	{
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();		
		VehicleLogic vl = new VehicleLogic();
		
		vehicleList = vl.getVehiclesFromSource();			
		
		System.out.println();
		System.out.println("Order by year or by brand?");
		System.out.println("   1. By year");
		System.out.println("   2. By brand");
		System.out.println("   3. By type");
		System.out.println("   4. Show all");
		
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();		
		switch(option)
		{
			case 1 : vehicleList = vl.viewSortVehiclesByYear(vehicleList); 
					 vl.viewVehicleList(vehicleList); 
					 break;
					 
			case 2 : vehicleList = vl.viewSortVehiclesByBrands(vehicleList); 
					 vl.viewVehicleList(vehicleList); 
					 break;
					 
			case 3 : vehicleList = vl.viewSortVehiclesByType(vehicleList);
					 vl.viewVehicleList(vehicleList); 
					 break;
					 
			case 4 : vl.viewVehicleList(vehicleList); 
					 break;
					 
			default : System.out.println();
					  System.out.println("Invalid option!");
					  break;
		}
		
		sc.close();
	}
	
	public static void personOptions()
	{
		List<Person>  personList = new ArrayList<Person>();		
		PersonLogic pl = new PersonLogic();
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Person options: ");
		System.out.println("   1. Display all persons");
		System.out.println("   2. Display eligible persons");
		

		int option = sc.nextInt();	
		personList = pl.getPersonsFromSource();	
		
		switch(option)
		{
			case 1: System.out.println();
					pl.viewPersonList(personList);
					break;
			case 2: for(Person p : personList)
					{
						if (pl.isEligible(p)) System.out.print(p.toString());
					}
					break;
			default : System.out.println();
			  		  System.out.println("Invalid option!");
			  		  break;
		}
		
		sc.close();
	}
	
	public static void newContract()
	{
		ContractsLogic cl = new ContractsLogic();
		Scanner sc = new Scanner(System.in);
		String dateStart , dateEnd , personalIdentificationNumber,registrationNumber;
		int mileage;
		
		System.out.println("Insert renting period start: ");
		dateStart = sc.next();
		
		System.out.println("Insert renting period end: ");
		dateEnd = sc.next();
		
		System.out.println("Insert current vehicle mileage: ");
		mileage = Integer.parseInt(sc.next());
		
		System.out.println("Insert clients personal identification number: ");
		personalIdentificationNumber = sc.next();
		
		System.out.println("Insert vehicle registration number: ");
		registrationNumber = sc.next();
		
		Contract c = new Contract(dateStart, dateEnd, mileage, personalIdentificationNumber, registrationNumber);
		cl.newContract(c);

		sc.close();
	}
	
}
