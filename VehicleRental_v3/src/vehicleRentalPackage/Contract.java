package vehicleRentalPackage;

public class Contract
{	
	private Person person ;
	private Vehicle vehicle ;
	private String rentingDateStart;
	private String rentingDateEnd;
	


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

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
