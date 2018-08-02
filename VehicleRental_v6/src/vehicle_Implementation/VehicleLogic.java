package vehicle_Implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class VehicleLogic implements Inventory
{
	@Override
	public List<Vehicle> SortVehiclesByYear(List<Vehicle> vehicles) throws SQLException 
	{
		//List<Vehicle> result = vehicles.stream().sorted(Comparator.comparing(Vehicle::getManufacturingYear)).collect(Collectors.toList());
		List<Vehicle> result = new ArrayList<Vehicle>();
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		ResultSet rs = query.executeQuery("SELECT * FROM VEHICLES WHERE REGISTRATION_NR IS NOT NULL GROUP BY MANUFACTURING_YEAR,TYPE,REGISTRATION_NR,BRAND,COLOR ORDER BY MANUFACTURING_YEAR ASC;");
		while(rs.next())
		{
			result.add( new Vehicle(rs.getString(1), CarType.valueOf(rs.getString(2)), rs.getString(3), Integer.parseInt(rs.getString(4)), rs.getString(5) ) );
		}
		
		return result;
	}

	@Override
	public List<Vehicle> SortVehiclesByBrands(List<Vehicle> vehicles) throws SQLException 
	{
		//List<Vehicle> result = vehicles.stream().sorted((v1, v2) -> v1.getCarMaker().compareTo(v2.getCarMaker())).collect(Collectors.toList());
		List<Vehicle> result = new ArrayList<Vehicle>();
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		ResultSet rs = query.executeQuery(" SELECT * FROM VEHICLES WHERE REGISTRATION_NR IS NOT NULL GROUP BY BRAND,TYPE,REGISTRATION_NR,MANUFACTURING_YEAR,COLOR ORDER BY BRAND ASC;");
		while(rs.next())
		{
			result.add( new Vehicle(rs.getString(1), CarType.valueOf(rs.getString(2)), rs.getString(3), Integer.parseInt(rs.getString(4)), rs.getString(5) ) );
		}
		
		return result;
	}
	
	@Override
	public List<Vehicle> SortVehiclesByType(List<Vehicle> vehicles) throws SQLException 
	{
		//List<Vehicle> result = vehicles.stream().sorted((v1, v2) -> v1.getType().name().compareTo(v2.getType().name())).collect(Collectors.toList());	
		List<Vehicle> result = new ArrayList<Vehicle>();
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		ResultSet rs = query.executeQuery("SELECT * FROM VEHICLES WHERE REGISTRATION_NR IS NOT NULL GROUP BY TYPE,REGISTRATION_NR,BRAND,MANUFACTURING_YEAR,COLOR ORDER BY TYPE ASC;");
		while(rs.next())
		{
			result.add( new Vehicle(rs.getString(1), CarType.valueOf(rs.getString(2)), rs.getString(3), Integer.parseInt(rs.getString(4)), rs.getString(5) ) );
		}
		
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
	public List<Vehicle> getVehiclesFromSource() throws NumberFormatException, SQLException
	{
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		ResultSet rs = query.executeQuery("SELECT * FROM VEHICLES;");
		while(rs.next())
		{
			vehicleList.add( new Vehicle(rs.getString(1), CarType.valueOf(rs.getString(2)), rs.getString(3), Integer.parseInt(rs.getString(4)), rs.getString(5) ) );
		}		
		
		return vehicleList;
	}
}
