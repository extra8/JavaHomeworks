package contract_Implementation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import person_Implementation.Person;

public class ContractsLogic implements Contracts
{

	@Override
	public List<Contract> viewContracts() 
	{

		return null;
	}

	@Override
	public List<Contract> viewContractsOfUser(Person p) 
	{

		return null;
	}

	@Override
	public void newContract(Contract c) 
	{
		File contractsListFile = new File("inchirieri.txt");
		
		FileWriter fileWritter;
		try 
		{
			fileWritter = new FileWriter(contractsListFile,true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.newLine();
	        bufferWritter.write(c.toString());
	        bufferWritter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
        
	}

}
