package vehicleRental;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contract_Implementation.Contract;
import contract_Implementation.ContractLogic;
import person_Implementation.Person;
import person_Implementation.PersonLogic;
import vehicle_Implementation.Vehicle;
import vehicle_Implementation.VehicleLogic;

public class Start 
{	
	public static void main(String[] args) throws SQLException
	{		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("	1. View vehicles ");
		System.out.println("	2. View customers ");
		System.out.println("	3. View contracts ");
		System.out.println("	4. New contract ");
		
		int option = sc.nextInt();
		
		if (option == 1) 
			vehicleOptions();
		else if (option == 2) 
			personOptions();
		else if (option == 3) 
			contractOptions();
		else if (option == 4) 
			newContract();
		else
			System.out.println("Invalid option!");

		sc.close();	
	}
	
	public static void vehicleOptions() throws SQLException
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
			case 1 : vehicleList = vl.SortVehiclesByYear(vehicleList); 
					 vl.viewVehicleList(vehicleList); 
					 break;
					 
			case 2 : vehicleList = vl.SortVehiclesByBrands(vehicleList); 
					 vl.viewVehicleList(vehicleList); 
					 break;
					 
			case 3 : vehicleList = vl.SortVehiclesByType(vehicleList);
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
	
	public static void personOptions() throws SQLException
	{
		List<Person>  personList = new ArrayList<Person>();		
		PersonLogic pl = new PersonLogic();
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Person options: ");
		System.out.println("   1. Display all customers");
		System.out.println("   2. Display eligible customers");
		

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
	
	public static void newContract() throws SQLException
	{
		ContractLogic cl = new ContractLogic();
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
	
	public static void contractOptions() throws SQLException
	{
		List<Contract>  contractList = new ArrayList<Contract>();		
		ContractLogic cl = new ContractLogic();
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Contract options: ");
		System.out.println("   1. Display all contracts");
		System.out.println("   2. Display contracts of user");
		

		int option = sc.nextInt();	
		
		switch(option)
		{
			case 1: System.out.println();
					contractList = cl.getContractsFromSource();
					cl.viewContracts(contractList);
					break;
			case 2: System.out.println();
					System.out.println("Insert customer personal identification number: ");
					String personalIdentificationNumber = sc.next();
					contractList = cl.getContractsOfUser(personalIdentificationNumber);
					cl.viewContracts(contractList);
					break;
			default : System.out.println();
			  		  System.out.println("Invalid option!");
			  		  break;
		}
		
		sc.close();
	}
	
}
