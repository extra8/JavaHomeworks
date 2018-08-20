package com.siemens.ctbav.internship.person.implementation;

import java.util.List;

public interface Persons 
{
	public List<Person> getPersonsFromSource();
	public void viewPersonList(List<Person> persons);
	public boolean isEligible(Person p);
	public List<Person> getEligiblePersons();
}
