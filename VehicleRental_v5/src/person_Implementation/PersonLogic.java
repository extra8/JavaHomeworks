package person_Implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonLogic implements Persons
{

	@Override
	public List<Person> getPersonsFromSource()
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
					 personsList.add(new Person(splited[0], splited[1], splited[2], splited[3], Integer.parseInt(splited[4])));			
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
		char[] charArray = p.getDateOfBirth().toCharArray();
		int year = Integer.parseInt("19" + charArray[6] + charArray[7]);
		
		if (p.getDrivingLicenseYear() - year >=18)
		{
			//System.out.println(p.getDrivingLicenseYear() - year);
			return true;
		}
		else
			return false;
	}

}
