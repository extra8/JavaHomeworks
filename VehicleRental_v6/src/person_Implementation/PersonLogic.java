package person_Implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonLogic implements Persons
{

	@Override
	public List<Person> getPersonsFromSource() throws SQLException
	{
		List<Person>  personsList = new ArrayList<Person>();
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		ResultSet rs = query.executeQuery("SELECT * FROM CUSTOMERS;");
		while(rs.next())
		{
			personsList.add( new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)) ) );
		}		
		
		return personsList;
	}
	
	@Override
	public void viewPersonList(List<Person> persons)
	{
		System.out.println();
		for(Person p : persons)
		{
			System.out.print(p.toString());
		}
	}
	
	@Override
	public boolean isEligible(Person p)
	{
		char[] birthdayCharArray = p.getDateOfBirth().toCharArray();
		char[] firstDigit = p.getPersonalIdentificationNumber().toCharArray();
		int year = 0;
		
		
		if(firstDigit[0] == '5' || firstDigit[0] == '6')
		{
			year = Integer.parseInt("20" + birthdayCharArray[6] + birthdayCharArray[7]);
		}
		else if (firstDigit[0] == '1' || firstDigit[0] == '2')
		{
			year = Integer.parseInt("19" + birthdayCharArray[6] + birthdayCharArray[7]);
		}
		else 
			year = Integer.parseInt("18" + birthdayCharArray[6] + birthdayCharArray[7]);
		
		
		if (p.getDrivingLicenseYear() - year >=18)
		{
			return true;
		}
		else 
			return false;
	}

}
