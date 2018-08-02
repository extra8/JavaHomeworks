package inserter_package;

import java.io.IOException;
import java.sql.SQLException;

public class Start 
{
	public static void main(String[] args) throws SQLException, IOException
	{
		InserterLogic fl = new InserterLogic();
		
		fl.insertCustomers();
		fl.insertVehicles();
		fl.insertContracts();
	}
}
