package DBI;

import java.sql.SQLException;

public class Start 
{
	public static void main(String[] args) throws SQLException
	{
		FileLogic fl = new FileLogic();
		
		fl.insertCustomers();
		fl.insertVehicles();
		fl.insertContracts();
	}
}
