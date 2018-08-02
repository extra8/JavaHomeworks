package contract_Implementation;

import java.sql.SQLException;
import java.util.List;


public interface Contracts 
{
	public List<Contract> getContractsFromSource()  throws SQLException ;
	public void newContract(Contract c) throws SQLException;
	public List<Contract> getContractsOfUser(String personalIdentificationNumber) throws SQLException;	
	public void  viewContracts(List<Contract> contracts);
}
