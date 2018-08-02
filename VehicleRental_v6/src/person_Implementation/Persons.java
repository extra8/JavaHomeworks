package person_Implementation;

import java.sql.SQLException;
import java.util.List;

public interface Persons 
{
	public List<Person> getPersonsFromSource() throws SQLException;
	public void viewPersonList(List<Person> persons);
	public boolean isEligible(Person p);
}
