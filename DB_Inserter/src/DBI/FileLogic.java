package DBI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataTypes.CarType;
import dataTypes.Contract;
import dataTypes.Person;
import dataTypes.Vehicle;


public class FileLogic implements Files
{
	@Override
	public void insertCustomers() throws SQLException
	{
		File personsListFile = new File("persoane.txt");
		List<Person>  personsList = new ArrayList<Person>();
		String str;		
		
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(personsListFile));
			
			try 
			{
				while((str = reader.readLine()) != null)
				{
					 String[] splited = str.split(", ");
					 personsList.add( new Person(splited[0], splited[1], splited[2], splited[3], Integer.parseInt(splited[4]) ) );			
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String firstName;	
		String lastName;
		String gender;
		String personalIdentificationNumber;
		String drivingLicenseYear;
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		for(Person p : personsList)
		{
			
			firstName = p.getFirstName();	
			lastName = p.getLastName();
			gender = p.getGender();
			personalIdentificationNumber = p.getPersonalIdentificationNumber();
			drivingLicenseYear = String.valueOf(p.getDrivingLicenseYear());
			
			query.executeUpdate("INSERT INTO CUSTOMERS VALUES('" + personalIdentificationNumber + "','" + lastName + "','" + firstName + "','" + gender + "'," + drivingLicenseYear + ");");
		}		
	}
	
	@Override
	public void insertVehicles() throws SQLException
	{
		File vehicleListFile = new File("vehicles.txt");
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		String str;		
		
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(vehicleListFile));
			
			try 
			{
				while((str = reader.readLine()) != null)
				{
					 String[] splited = str.split(", ");
					 vehicleList.add( new Vehicle(splited[0], CarType.valueOf(splited[1]), splited[2], Integer.parseInt(splited[3]), splited[4]) );			
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String carMaker;
		String manufacturingYear;
		String registrationNumber;
		String color;
		String type;
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		for(Vehicle v : vehicleList)
		{
			
			carMaker = v.getCarMaker();
			manufacturingYear = String.valueOf(v.getManufacturingYear());
			registrationNumber = v.getRegistrationNumber();
			color = v.getColor();
			type = v.getType().name();
			
			query.executeUpdate("INSERT INTO VEHICLES VALUES('" + registrationNumber + "','" + type + "','" + carMaker + "'," + manufacturingYear + ",'" + color + "');");
		}
	}

	@Override
	public void insertContracts() throws SQLException 
	{
		File contractListFile = new File("inchirieri.txt");
		List<Contract> contractList = new ArrayList<Contract>();
		String str;
		
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(contractListFile));
			
			try 
			{
				while((str = reader.readLine()) != null)
				{
					 String[] splited = str.split(", ");
					 contractList.add( new Contract(splited[0], splited[1],  Integer.parseInt(splited[2]), splited[3], splited[4]) );			
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		String personalIdentificationNumber;
		String registrationNumber;
		String rentingDateStart;
		String rentingDateEnd;
		String mileage;
		
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		for(Contract c : contractList)
		{
			
			personalIdentificationNumber = c.getPersonalIdentificationNumber();
			registrationNumber = c.getRegistrationNumber();
			rentingDateStart = c.getRentingDateStart();
			rentingDateEnd = c.getRentingDateEnd();
			mileage = String.valueOf(c.getMilage());
			
			query.executeUpdate("INSERT INTO CONTRACTS VALUES('" + rentingDateStart + "','" + rentingDateEnd + "'," + mileage + ",'" + personalIdentificationNumber + "','" + registrationNumber + "');");
		}
	}
	
}
