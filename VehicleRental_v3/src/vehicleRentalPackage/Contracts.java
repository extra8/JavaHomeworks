package vehicleRentalPackage;

import java.util.List;

public interface Contracts 
{
	public List<Contract> viewContracts();
	public Contract rentVehicle(Person p, Vehicle v);
	public List<Contract> viewContractsOfUser(Person p);	
}
