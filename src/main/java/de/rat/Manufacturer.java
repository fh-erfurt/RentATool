package de.rat;

import java.util.ArrayList;

public class Manufacturer {

    private String name;
    private Address address;
    private String agent;
    private String phoneNumber;
    static ArrayList<Manufacturer> manufacturerList =  new ArrayList<Manufacturer>();


    public Manufacturer( String name, Address address, String agent, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.agent = agent;
        this.phoneNumber = phoneNumber;
        manufacturerList.add(this); //add the manufacturer to the ArrayList
    }





    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getAgent() {
        return agent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void changeManufacture(String name, Address address, String agent, String phoneNumber) {
        this.name=name;
        this.address=address;
        this.agent=agent;
        this.phoneNumber=phoneNumber;
    }
}
