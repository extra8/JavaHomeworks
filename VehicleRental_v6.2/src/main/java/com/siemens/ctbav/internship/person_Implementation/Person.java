package com.siemens.ctbav.internship.person_Implementation;

import org.springframework.beans.factory.annotation.Autowired;

public class Person 
{		
	@Autowired
	private String firstName;	
	private String lastName;
	private String gender;
	private String personalIdentificationNumber;
	private String dateOfBirth;
	private int drivingLicenseYear;
	
	
	public Person()
	{
		
	}	
	
	public Person(String personalIdentificationNumber, String lastName, String firstName, String gender , int drivingLicenseYear) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.personalIdentificationNumber = personalIdentificationNumber;
		this.drivingLicenseYear = drivingLicenseYear;
		
		this.dateOfBirth = extractBirthday(personalIdentificationNumber);
	}


	public String getFirstName() {
		return firstName;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getGender() {
		return gender;
	}
	
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}
	
	
	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}
	
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public int getDrivingLicenseYear() {
		return drivingLicenseYear;
	}
	
	
	public void setDrivingLicenseYear(int drivingLicenseYear) {
		this.drivingLicenseYear = drivingLicenseYear;
	}
	
	@Override
	public String toString() 
	{
		return personalIdentificationNumber + ", " + lastName + ", " + firstName + ", " + gender + ", " + drivingLicenseYear + ", " + dateOfBirth + "\n";
	}
	
	public String extractBirthday(String idNumber)
	{
		String birthday;
		
		char[] charArray = idNumber.toCharArray();
		
		birthday = "" + charArray[5] + charArray[6] + "." + charArray[3] + charArray[4] + "." + charArray[1] + charArray[2];
		
		return birthday;
	}
	
}
