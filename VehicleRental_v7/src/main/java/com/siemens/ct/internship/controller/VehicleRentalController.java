package com.siemens.ct.internship.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siemens.ctbav.internship.contract.implementation.Contract;
import com.siemens.ctbav.internship.contract.implementation.ContractLogic;
import com.siemens.ctbav.internship.person.implementation.Person;
import com.siemens.ctbav.internship.person.implementation.PersonLogic;
import com.siemens.ctbav.internship.vehicle.implementation.Vehicle;
import com.siemens.ctbav.internship.vehicle.implementation.VehicleLogic;

@Controller
public class VehicleRentalController {

    @Autowired
    VehicleLogic vl;
    @Autowired
    ContractLogic cl;
    @Autowired
    PersonLogic pl;
    
    @RequestMapping(value = "/start")
    public String start()
    {
        System.out.println("In start");
        return "start";
    }
    
    @RequestMapping(value = "/vby")
    public String vehicleByYear(Model model) 
    {
    	List<Vehicle> VehicleList = new ArrayList<Vehicle>();
        
        VehicleList = vl.getSortedVehiclesByYear();
        model.addAttribute("VehicleList", VehicleList);
        System.out.println("In vby");
        return "VehicleByYear";
    }
    
    @RequestMapping(value = "/vbt")
    public String vehicleByType(Model model) 
    {
    	List<Vehicle> VehicleList = new ArrayList<Vehicle>();
        
        VehicleList = vl.getSortedVehiclesByType();
        model.addAttribute("VehicleList", VehicleList);
        System.out.println("In vbt");
        return "VehicleByType";
    }
    
    @RequestMapping(value = "/vbb")
    public String vehicleByBrand(Model model) 
    {
    	List<Vehicle> VehicleList = new ArrayList<Vehicle>();
        
        VehicleList = vl.getSortedVehiclesByBrands();
        model.addAttribute("VehicleList", VehicleList);
        System.out.println("In vbb");
        return "VehicleByBrand";
    }
    
    @RequestMapping(value = "/av")
    public String allVehicle(Model model) 
    {
    	List<Vehicle> VehicleList = new ArrayList<Vehicle>();
        
        VehicleList = vl.getVehiclesFromSource();
        model.addAttribute("VehicleList", VehicleList);
        System.out.println("In av");
        return "AllVehicles";
    }
    
    @RequestMapping(value = "/ac")
    public String allContracts(Model model) 
    {
    	List<Contract> ContractList = new ArrayList<Contract>();
        
        ContractList = cl.getContractsFromSource();
        model.addAttribute("ContractList", ContractList);
        System.out.println("In ac");
        return "AllContracts";
    }
    
    @RequestMapping(value = "/ec")
    public String eligibleCustomers(Model model) 
    {
    	List<Person> CustomerList = new ArrayList<Person>();
        
    	CustomerList = pl.getEligiblePersons();
        model.addAttribute("CustomerList", CustomerList);
        System.out.println("In ec");
        return "EligibleCustomers";
    }
    
    @RequestMapping(value = "/acust")
    public String allCustomers(Model model) 
    {
    	List<Person> CustomerList = new ArrayList<Person>();
        
    	CustomerList = pl.getPersonsFromSource();
        model.addAttribute("CustomerList", CustomerList);
        System.out.println("In acust");
        return "AllCustomers";
    }
    
    @RequestMapping(value = "/coa")
    public String contractOfUser(Model model) 
    {
        System.out.println("In coa");

        return "ContractsOfCustomer";
    }
    
    @RequestMapping(value = "/uc")
    public String userContracts(@RequestParam("cnp") String cnp, Model model)
    {
    	List<Contract> ContractList = new ArrayList<Contract>();
        
    	ContractList = cl.getContractsOfUser(cnp);
    	model.addAttribute("ContractList", ContractList);
        System.out.println("In uc");
        return "UserContracts";
    }
    
    @RequestMapping(value = "/nc1")
    public String newContractPage(Model model) 
    {
        System.out.println("In coa");

        return "NewContract";
    }
    
    @RequestMapping(value = "/nc2")
    public String newContract(@RequestParam("rents") String rents, @RequestParam("rente") String rente, @RequestParam("mileage") String mileage, @RequestParam("cnp") String cnp, @RequestParam("regnr") String regnr, Model model)
    {
    	Contract c = new Contract(rents, rente, Integer.parseInt(mileage), cnp, regnr);
    	cl.newContract(c);

        System.out.println("In nc");
        return "NewContract";
    }

}
