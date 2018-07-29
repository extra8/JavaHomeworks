package vehicleRentalPackage;


public class Vehicle
{
	
	private String carMaker;
	private int manufacturingYear;
	private String registrationNumber;
	private String color;
	private CarType type;
	
	
	public Vehicle()
	{
		
	}
	
	public Vehicle(String carMaker, int manufacturingYear, String registrationNumber, String color , CarType type) 
	{
		this.carMaker = carMaker;
		this.manufacturingYear = manufacturingYear;
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.type = type;
	}
	
	
	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public String getCarMaker() {
		return carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public int getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	
	@Override
	public String toString() {
		System.out.println( carMaker + ", " + manufacturingYear + ", " + registrationNumber + ", " + color + ", " + type);
		return "";
	}
}
