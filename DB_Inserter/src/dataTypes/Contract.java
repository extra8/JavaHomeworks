package dataTypes;

public class Contract
{	
	private String personalIdentificationNumber;
	private String registrationNumber;
	private String rentingDateStart;
	private String rentingDateEnd;
	private int mileage;
	
	
	public Contract(String rentingDateStart, String rentingDateEnd, int mileage, String personalIdentificationNumber, String registrationNumber) 
	{
		this.rentingDateStart = rentingDateStart;
		this.rentingDateEnd = rentingDateEnd;
		this.mileage = mileage;
		this.personalIdentificationNumber = personalIdentificationNumber;
		this.registrationNumber = registrationNumber;
	}

	public int getMilage() {
		return mileage;
	}

	public void setMilage(int milage) {
		this.mileage = milage;
	}

	public String getRentingDateStart() {
		return rentingDateStart;
	}

	public void setRentingDateStart(String rentingDateStart) {
		this.rentingDateStart = rentingDateStart;
	}

	public String getRentingDateEnd() {
		return rentingDateEnd;
	}

	public void setRentingDateEnd(String rentingDateEnd) {
		this.rentingDateEnd = rentingDateEnd;
	}

	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Override
	public String toString() 
	{
		return rentingDateStart + ", " + rentingDateEnd + ", " + mileage + ", " + personalIdentificationNumber + ", " + registrationNumber;
	}

}
