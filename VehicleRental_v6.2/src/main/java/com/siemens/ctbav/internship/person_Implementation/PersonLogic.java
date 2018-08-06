package com.siemens.ctbav.internship.person_Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class PersonLogic implements Persons
{
    private JdbcTemplate jdbcTemplate;	
	private static final String GET_ALL_CUSTOMERS = "SELECT * FROM CUSTOMERS;";
	
	@Override
	public List<Person> getPersonsFromSource()
	{
		List<Person>  personsList = new ArrayList<Person>();
		
		personsList = jdbcTemplate.query(GET_ALL_CUSTOMERS, (resultSet, nr)->
		{
			Person person = new Person();
			person.setPersonalIdentificationNumber(resultSet.getString("CNP"));
			person.setLastName(resultSet.getString("LAST_NAME"));
			person.setFirstName(resultSet.getString("FIRST_NAME"));
			person.setGender(resultSet.getString("GENDER"));
			person.setDrivingLicenseYear(Integer.parseInt(resultSet.getString("LICENSE_YEAR")));
            
            return person;
		});
		
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
	
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
