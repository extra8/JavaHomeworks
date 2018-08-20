package com.siemens.ctbav.internship.contract.implementation;

import java.util.List;


public interface Contracts 
{
	public List<Contract> getContractsFromSource() ;
	public void newContract(Contract c);
	public List<Contract> getContractsOfUser(String personalIdentificationNumber);	
	public void viewContracts(List<Contract> contracts);
}
