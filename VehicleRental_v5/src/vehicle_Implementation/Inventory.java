package vehicle_Implementation;

import java.util.List;

public interface Inventory 
{
	public void viewVehicleList(List<Vehicle> vehicles);
	public List<Vehicle> viewSortVehiclesByYear(List<Vehicle> vehicles);
	public List<Vehicle> viewSortVehiclesByBrands(List<Vehicle> vehicles);
	public List<Vehicle> viewSortVehiclesByType(List<Vehicle> vehicles);	
	public List<Vehicle> getVehiclesFromSource();
}
