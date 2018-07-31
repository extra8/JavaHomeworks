package vehicle_Implementation;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		List<Vehicle> result = vehicles.stream().sorted((v1, v2) -> v1.getType().name().compareTo(v2.getType().name())).collect(Collectors.toList());		
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
	
	@Override
	public List<Vehicle> getVehiclesFromSource()
	{
		File vehicleListFile = new File("vehicles.txt");
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		String str;		
		
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(vehicleListFile));
			
			try 
			{
				while((str = reader.readLine()) != null)
				{
					 String[] splited = str.split(", ");
					 vehicleList.add(new Vehicle(splited[0], CarType.valueOf(splited[1]), splited[2], Integer.parseInt(splited[3]), splited[4]));			
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return vehicleList;
	}
}
