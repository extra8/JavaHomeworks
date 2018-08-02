package contract_Implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ContractLogic implements Contracts
{

	@Override
	public List<Contract> getContractsFromSource() throws SQLException 
	{
		List<Contract> contractList = new ArrayList<Contract>();
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		ResultSet rs = query.executeQuery("SELECT * FROM CONTRACTS WHERE REGISTRATION_NR IS NOT NULL GROUP BY REGISTRATION_NR, CNP, CONTRACT_ID, RENT_START, RENT_END, MILEAGE ORDER BY REGISTRATION_NR ASC;");
		while(rs.next())
		{
			contractList.add( new Contract(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), rs.getString(5), rs.getString(6) ) );
		}		
		
		return contractList;
	}

	@Override
	public List<Contract> getContractsOfUser(String personalIdentificationNumber) throws SQLException 
	{

		List<Contract> contractList = new ArrayList<Contract>();
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
		
		ResultSet rs = query.executeQuery("  SELECT * FROM CONTRACTS WHERE CNP = 1501118265428 ORDER BY RENT_START, RENT_END, REGISTRATION_NR, MILEAGE, CONTRACT_ID, CNP;");
		while(rs.next())
		{
			contractList.add( new Contract(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), rs.getString(5), rs.getString(6) ) );
		}		
		
		return contractList;
	}

	@Override
	public void newContract(Contract c) throws SQLException 
	{
		String personalIdentificationNumber;
		String registrationNumber;
		String rentingDateStart;
		String rentingDateEnd;
		String mileage;		
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=VEHICLE_RENTAL;integratedSecurity=true");
		
		Statement query = connection.createStatement();
					
		personalIdentificationNumber = c.getPersonalIdentificationNumber();
		registrationNumber = c.getRegistrationNumber();
		rentingDateStart = c.getRentingDateStart();
		rentingDateEnd = c.getRentingDateEnd();
		mileage = String.valueOf(c.getMilage());
		
		query.executeUpdate("INSERT INTO CONTRACTS VALUES('" + rentingDateStart + "','" + rentingDateEnd + "'," + mileage + ",'" + personalIdentificationNumber + "','" + registrationNumber + "');");        
	}

	@Override
	public void viewContracts(List<Contract> contracts) 
	{
		System.out.println();
		for(Contract c : contracts)
		{
			System.out.print(c.toString());
		}		
	}

}
