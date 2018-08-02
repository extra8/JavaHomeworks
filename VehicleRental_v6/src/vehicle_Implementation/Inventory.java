package vehicle_Implementation;

import java.sql.SQLException;
import java.util.List;

public interface Inventory 
{
	public void viewVehicleList(List<Vehicle> vehicles);
	public List<Vehicle> SortVehiclesByYear(List<Vehicle> vehicles) throws SQLException ;
	public List<Vehicle> SortVehiclesByBrands(List<Vehicle> vehicles) throws SQLException ;
	public List<Vehicle> SortVehiclesByType(List<Vehicle> vehicles) throws SQLException ;	
	public List<Vehicle> getVehiclesFromSource() throws NumberFormatException, SQLException;
}
