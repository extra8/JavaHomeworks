package com.siemens.ctbav.internship.vehicle_Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class VehicleLogic implements Inventory
{
    private JdbcTemplate jdbcTemplate;	
	private static final String GET_ALL_VEHICLES = "SELECT * FROM VEHICLES;";	
	private static final String GET_VEHICLES_BY_TYPE = "SELECT * FROM VEHICLES WHERE REGISTRATION_NR IS NOT NULL GROUP BY TYPE,REGISTRATION_NR,BRAND,MANUFACTURING_YEAR,COLOR ORDER BY TYPE ASC;";
	private static final String GET_VEHICLES_BY_BRAND = "SELECT * FROM VEHICLES WHERE REGISTRATION_NR IS NOT NULL GROUP BY BRAND,TYPE,REGISTRATION_NR,MANUFACTURING_YEAR,COLOR ORDER BY BRAND ASC;";
	private static final String GET_VEHICLES_BY_YEAR = "SELECT * FROM VEHICLES WHERE REGISTRATION_NR IS NOT NULL GROUP BY MANUFACTURING_YEAR,TYPE,REGISTRATION_NR,BRAND,COLOR ORDER BY MANUFACTURING_YEAR ASC;";
	
	
	@Override
	public List<Vehicle> getSortedVehiclesByYear()
	{
		//List<Vehicle> result = vehicles.stream().sorted(Comparator.comparing(Vehicle::getManufacturingYear)).collect(Collectors.toList());
		
		//Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		//Statement query = connection.createStatement();
		
		//ResultSet rs = query.executeQuery("SELECT * FROM VEHICLES WHERE REGISTRATION_NR IS NOT NULL GROUP BY MANUFACTURING_YEAR,TYPE,REGISTRATION_NR,BRAND,COLOR ORDER BY MANUFACTURING_YEAR ASC;");
		//while(rs.next())
		//{
			//result.add( new Vehicle(rs.getString(1), CarType.valueOf(rs.getString(2)), rs.getString(3), Integer.parseInt(rs.getString(4)), rs.getString(5) ) );
		//}
		
		List<Vehicle> result = new ArrayList<Vehicle>();
		
		result = jdbcTemplate.query(GET_VEHICLES_BY_YEAR, (resultSet, nr)->
		{
            Vehicle vehicle = new Vehicle();
            vehicle.setRegistrationNumber(resultSet.getString("REGISTRATION_NR"));
            vehicle.setType(CarType.valueOf(resultSet.getString("TYPE")));
            vehicle.setCarMaker(resultSet.getString("BRAND"));
            vehicle.setManufacturingYear(Integer.parseInt(resultSet.getString("MANUFACTURING_YEAR")));
            vehicle.setColor(resultSet.getString("COLOR"));
            
            return vehicle;
		});
		
		return result;
	}

	@Override
	public List<Vehicle> getSortedVehiclesByBrands()
	{
		//List<Vehicle> result = vehicles.stream().sorted((v1, v2) -> v1.getCarMaker().compareTo(v2.getCarMaker())).collect(Collectors.toList());
		List<Vehicle> result = new ArrayList<Vehicle>();
		
		result = jdbcTemplate.query(GET_VEHICLES_BY_BRAND, (resultSet, nr)->
		{
            Vehicle vehicle = new Vehicle();
            vehicle.setRegistrationNumber(resultSet.getString("REGISTRATION_NR"));
            vehicle.setType(CarType.valueOf(resultSet.getString("TYPE")));
            vehicle.setCarMaker(resultSet.getString("BRAND"));
            vehicle.setManufacturingYear(Integer.parseInt(resultSet.getString("MANUFACTURING_YEAR")));
            vehicle.setColor(resultSet.getString("COLOR"));
            
            return vehicle;
		});
		
		return result;
	}
	
	
	@Override
	public List<Vehicle> getSortedVehiclesByType() 
	{
		//List<Vehicle> result = vehicles.stream().sorted((v1, v2) -> v1.getType().name().compareTo(v2.getType().name())).collect(Collectors.toList());	
		List<Vehicle> result = new ArrayList<Vehicle>();
		
		result = jdbcTemplate.query(GET_VEHICLES_BY_TYPE, (resultSet, nr)->
		{
            Vehicle vehicle = new Vehicle();
            vehicle.setRegistrationNumber(resultSet.getString("REGISTRATION_NR"));
            vehicle.setType(CarType.valueOf(resultSet.getString("TYPE")));
            vehicle.setCarMaker(resultSet.getString("BRAND"));
            vehicle.setManufacturingYear(Integer.parseInt(resultSet.getString("MANUFACTURING_YEAR")));
            vehicle.setColor(resultSet.getString("COLOR"));
            
            return vehicle;
		});
		
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
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		
		vehicleList = jdbcTemplate.query(GET_ALL_VEHICLES, (resultSet, nr)->
		{
            Vehicle vehicle = new Vehicle();
            vehicle.setRegistrationNumber(resultSet.getString("REGISTRATION_NR"));
            vehicle.setType(CarType.valueOf(resultSet.getString("TYPE")));
            vehicle.setCarMaker(resultSet.getString("BRAND"));
            vehicle.setManufacturingYear(Integer.parseInt(resultSet.getString("MANUFACTURING_YEAR")));
            vehicle.setColor(resultSet.getString("COLOR"));
            
            return vehicle;
		});
				
		return vehicleList;
	}
	
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
