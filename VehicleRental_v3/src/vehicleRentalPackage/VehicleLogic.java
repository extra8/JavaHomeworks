package vehicleRentalPackage;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class VehicleLogic implements Inventory
{
	@Override
	public void viewSortVehiclesByYear(List<Vehicle> vehicles) 
	{
		Collections.sort(vehicles, VehicleYearComparator());
		for(Vehicle v : vehicles)
		{
			System.out.print(v.toString());
		}
	}

	@Override
	public void viewSortVehiclesByBrands(List<Vehicle> vehicles) 
	{
		Collections.sort(vehicles, VehicleBrandComparator());
		for(Vehicle v : vehicles)
		{
			System.out.print(v.toString());
		}
	}

	@Override
	public void viewSortVehiclesByType(List<Vehicle> vehicles) 
	{
		Collections.sort(vehicles, VehicleTypeComparator());
		for(Vehicle v : vehicles)
		{
			System.out.print(v.toString());
		}
	}

	@Override
	public void viewAllVehicles(List<Vehicle> vehicles) 
	{
		System.out.println();
		for(Vehicle v : vehicles)
		{
			System.out.print(v.toString());
		}
	}
	
	
	static Comparator<Vehicle> VehicleYearComparator()
	{
		return new Comparator<Vehicle>()
		{
			@Override
			public int compare(Vehicle v1, Vehicle v2) 
			{
				return v1.getManufacturingYear() - v2.getManufacturingYear();
			}			
		};
	}
	
	static Comparator<Vehicle> VehicleBrandComparator()
	{
		return new Comparator<Vehicle>()
		{
			@Override
			public int compare(Vehicle v1, Vehicle v2) 
			{
				if(v1.getCarMaker() == v2.getCarMaker()) return 0;
				if(v1.getCarMaker() == null) return -1;
				if(v2.getCarMaker() == null) return 1;
				
				return v1.getCarMaker().compareTo(v2.getCarMaker());
			}			
		};
	}
	
	static Comparator<Vehicle> VehicleTypeComparator()
	{
		return new Comparator<Vehicle>()
		{
			@Override
			public int compare(Vehicle v1, Vehicle v2) 
			{
				if(v1.getType() == v2.getType()) return 0;
				if(v1.getType() == null) return -1;
				if(v2.getType() == null) return 1;
				
				return v1.getType().compareTo(v2.getType());
			}			
		};
	}

}
