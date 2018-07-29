package vehicleRentalPackage;

import java.util.List;

public interface Inventory 
{
	public void viewAllVehicles(List<Vehicle> vehicles);
	public void viewSortVehiclesByYear(List<Vehicle> vehicles);
	public void viewSortVehiclesByBrands(List<Vehicle> vehicles);
	public void viewSortVehiclesByType(List<Vehicle> vehicles);	
}
