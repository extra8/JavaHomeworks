package com.siemens.ctbav.internship.vehicle_Implementation;

import java.util.List;

public interface Inventory 
{
	public void viewVehicleList(List<Vehicle> vehicles);
	public List<Vehicle> getSortedVehiclesByYear();
	public List<Vehicle> getSortedVehiclesByBrands();
	public List<Vehicle> getSortedVehiclesByType();	
	public List<Vehicle> getVehiclesFromSource();
}
