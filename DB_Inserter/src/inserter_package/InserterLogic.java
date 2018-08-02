package inserter_package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InserterLogic
{

	public void insertCustomers() throws SQLException, IOException
	{
		File personsListFile = new File("persoane.txt");
		String str;	
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		Statement query = connection.createStatement();
		
		String firstName;	
		String lastName;
		String gender;
		String personalIdentificationNumber;
		String drivingLicenseYear;
		
		BufferedReader reader = new BufferedReader(new FileReader(personsListFile));
			
		while((str = reader.readLine()) != null)
		{
			String[] splited = str.split(", ");
			 
			firstName = splited[2];
			lastName = splited[1];
			gender = splited[3];
			personalIdentificationNumber = splited[0];
			drivingLicenseYear = splited[4];
			
			query.executeUpdate("INSERT INTO CUSTOMERS VALUES('" + personalIdentificationNumber + "','" + lastName + "','" + firstName + "','" + gender + "'," + drivingLicenseYear + ");");					 	
		}	
		
		reader.close();
	}
	

	public void insertVehicles() throws SQLException, IOException
	{
		File vehicleListFile = new File("vehicles.txt");
		String str;	
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		Statement query = connection.createStatement();
		
		String carMaker;
		String manufacturingYear;
		String registrationNumber;
		String color;
		String type;		

		BufferedReader reader = new BufferedReader(new FileReader(vehicleListFile));			

		while((str = reader.readLine()) != null)
		{
			String[] splited = str.split(", ");
		 
			registrationNumber = splited[0];
			type = splited[1];
			carMaker = splited[2];
			manufacturingYear = splited[3];
			color = splited[4];
			
			query.executeUpdate("INSERT INTO VEHICLES VALUES('" + registrationNumber + "','" + type + "','" + carMaker + "'," + manufacturingYear + ",'" + color + "');");										 	
		}		
		
		reader.close();
	}


	public void insertContracts() throws SQLException, IOException 
	{
		File contractListFile = new File("inchirieri.txt");
		String str;	
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		Statement query = connection.createStatement();
		
		String personalIdentificationNumber;
		String registrationNumber;
		String rentingDateStart;
		String rentingDateEnd;
		String mileage;
		
		BufferedReader reader = new BufferedReader(new FileReader(contractListFile));

		while((str = reader.readLine()) != null)
		{
			String[] splited = str.split(", ");
			 
			personalIdentificationNumber = splited[3];
			registrationNumber = splited[4];
			rentingDateStart = splited[0];
			rentingDateEnd = splited[1];
			mileage = splited[2];
			
			query.executeUpdate("INSERT INTO CONTRACTS VALUES('" + rentingDateStart + "','" + rentingDateEnd + "'," + mileage + ",'" + personalIdentificationNumber + "','" + registrationNumber + "');");										 	
		}	
		
		reader.close();
	}
	
}
