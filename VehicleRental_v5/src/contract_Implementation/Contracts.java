package contract_Implementation;

import java.util.List;

import person_Implementation.Person;

public interface Contracts 
{
	public List<Contract> viewContracts();
	public void newContract(Contract c);
	public List<Contract> viewContractsOfUser(Person p);	
}
