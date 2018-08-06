package com.siemens.ctbav.internship.contract_Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class ContractLogic implements Contracts
{
    private JdbcTemplate jdbcTemplate;	
	private static final String GET_ALL_CONTRACTS = "SELECT * FROM CONTRACTS WHERE REGISTRATION_NR IS NOT NULL GROUP BY REGISTRATION_NR, CNP, CONTRACT_ID, RENT_START, RENT_END, MILEAGE ORDER BY REGISTRATION_NR ASC;";
	
	@Override
	public List<Contract> getContractsFromSource()
	{
		List<Contract> contractList = new ArrayList<Contract>();
		
		contractList = jdbcTemplate.query(GET_ALL_CONTRACTS, (resultSet, nr)->
		{
			Contract contract = new Contract();
			contract.setContractID(Integer.parseInt(resultSet.getString("CONTRACT_ID")));
			contract.setRentingDateStart(resultSet.getString("RENT_START"));
			contract.setRentingDateEnd(resultSet.getString("RENT_END"));
			contract.setMilage(Integer.parseInt(resultSet.getString("MILEAGE")));
			contract.setPersonalIdentificationNumber(resultSet.getString("CNP"));
			contract.setRegistrationNumber(resultSet.getString("REGISTRATION_NR"));
            
            return contract;
		});		
		
		return contractList;
	}

	@Override
	public List<Contract> getContractsOfUser(String personalIdentificationNumber) 
	{
		String GET_ALL_CONTRACTS_OF_USER = "SELECT * FROM CONTRACTS WHERE CNP = '" + personalIdentificationNumber + "' ORDER BY RENT_START, RENT_END, REGISTRATION_NR, MILEAGE, CONTRACT_ID, CNP;";
		
		List<Contract> contractList = new ArrayList<Contract>();
		
		contractList = jdbcTemplate.query(GET_ALL_CONTRACTS_OF_USER, (resultSet, nr)->
		{
			Contract contract = new Contract();
			contract.setContractID(Integer.parseInt(resultSet.getString("CONTRACT_ID")));
			contract.setRentingDateStart(resultSet.getString("RENT_START"));
			contract.setRentingDateEnd(resultSet.getString("RENT_END"));
			contract.setMilage(Integer.parseInt(resultSet.getString("MILEAGE")));
			contract.setPersonalIdentificationNumber(resultSet.getString("CNP"));
			contract.setRegistrationNumber(resultSet.getString("REGISTRATION_NR"));
            
            return contract;
		});			
		
		return contractList;
	}

	@Override
	public void newContract(Contract c)
	{	
		String sql = "INSERT INTO CONTRACTS VALUES('" + c.getRentingDateStart() + "','" + c.getRentingDateEnd() + "'," + c.getMilage() + ",'" + c.getPersonalIdentificationNumber() + "','" + c.getRegistrationNumber() + "');";
		jdbcTemplate.update(sql);
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
	
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
