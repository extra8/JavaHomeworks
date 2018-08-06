package com.siemens.ctbav.internship.person_Implementation;

import java.util.List;

public interface Persons 
{
	public List<Person> getPersonsFromSource();
	public void viewPersonList(List<Person> persons);
	public boolean isEligible(Person p);
}
