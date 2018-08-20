package com.siemens.ctbav.internship.vehicle.implementation;

import org.springframework.beans.factory.annotation.Autowired;

public class Vehicle
{
	@Autowired
	private String carMaker;
	private int manufacturingYear;
	private String registrationNumber;
	private String color;
	private CarType type;
	
	public Vehicle(String registrationNumber, CarType type, String carMaker, int manufacturingYear, String color) 
	{
		this.registrationNumber = registrationNumber;
		this.type = type;
		this.carMaker = carMaker;
		this.manufacturingYear = manufacturingYear;
		this.color = color;		
	}
	
	public Vehicle()
	{
		
	}
		
	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public String getCarMaker() {
		return carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public int getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	@Override
	public String toString() 
	{
		return registrationNumber + ", " + type + ", " + carMaker + ", " + manufacturingYear + ", " + color + "\n";
	}
}
