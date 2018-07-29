package vehicleRentalPackage;


public class Person 
{
		
	private String firstName;	
	private String lastName;
	private String gender;
	private String personalIdentificationNumber;
	private String dateOfBirth;
	private int drivingLicenseYear;
	
	
	public Person(String firstName, String lastName, String gender, String personalIdentificationNumber,
			String dateOfBirth, int drivingLicenseYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.personalIdentificationNumber = personalIdentificationNumber;
		//this.dateOfBirth = dateOfBirth;
		this.drivingLicenseYear = drivingLicenseYear;
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
	

}
