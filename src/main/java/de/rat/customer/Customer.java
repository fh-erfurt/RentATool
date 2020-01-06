package de.rat.customer;


import de.rat.common.Person;
import de.rat.common.Role;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;
import de.rat.common.Account;
import de.rat.employee.Company;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Customer extends Person {

    private String phoneNumber;
    private Company company;
    private ArrayList<Tool>  inventory = new ArrayList<Tool>();

    public Customer(String lastname, String firstname, GregorianCalendar birthday,
             String email, String street, int houseNr, int zip, String city, String country, String phoneNumber,Company company)
    {
        super(lastname, firstname, birthday, street, houseNr,  zip,  city,  country);
        this.account = new Account(Role.CUSTOMER, email, createPassword(lastname, firstname, birthday));
        this.phoneNumber = phoneNumber;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }


    public Tool getToolFromInventory(Tool wantedTool){
        for (Tool foundedTool : this.inventory) {
            if (foundedTool.equals(wantedTool)) {
                this.inventory.remove(foundedTool);
                return foundedTool;
            }
        }
        return null;
    }

    public boolean putToolInInventory(Tool tool){
        if(tool != null) {
            this.inventory.add(tool);
            return true;
        }
        return false;
    }

    public boolean getToolFromStation(Tool wantedTool, Station removeStation){
        Tool searchedTool = removeStation.removeToolFromBox(wantedTool);
        return putToolInInventory(searchedTool);
    }

    public boolean returnToolToStation(Tool wantedTool, Station removeStation){
        Tool searchedTool = getToolFromInventory(wantedTool);
        return removeStation.addToolToBox(wantedTool);
    }

}

