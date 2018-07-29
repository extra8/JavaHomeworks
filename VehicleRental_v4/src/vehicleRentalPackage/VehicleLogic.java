package vehicleRentalPackage;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class VehicleLogic implements Inventory
{
	@Override
	public List<Vehicle> viewSortVehiclesByYear(List<Vehicle> vehicles) 
	{
		List<Vehicle> result = vehicles.stream().sorted(Comparator.comparing(Vehicle::getManufacturingYear)).collect(Collectors.toList());		
		return result;
	}

	@Override
	public List<Vehicle> viewSortVehiclesByBrands(List<Vehicle> vehicles) 
	{
		List<Vehicle> result = vehicles.stream().sorted((v1, v2) -> v1.getCarMaker().compareTo(v2.getCarMaker())).collect(Collectors.toList());
		return result;
	}
	

	@Override
	public List<Vehicle> viewSortVehiclesByType(List<Vehicle> vehicles) 
	{
		List<Vehicle> result = vehicles.stream().sorted((v1, v2) -> v1.getType().compareTo(v2.getType())).collect(Collectors.toList());		
		return result;
	}

	@Override
	public void viewVehicleList(List<Vehicle> vehicles) 
	{
		System.out.println();
		for(Vehicle v : vehicles)
		{
			System.out.print(v.toString());
		}
	}
}
