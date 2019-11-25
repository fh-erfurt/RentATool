package de.rat;

public class Manufacturer {

    private String name;
    private String address;
   private String agent;
   private String phoneNumber;


    public Manufacturer( String name, String address, String agent, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.agent = agent;
        this.phoneNumber = phoneNumber;

    }





    public String getName() {
        return name;
    }

    public String getAddress() {
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void changeManufacture(String name, String address, String agent, String phoneNumber) {
        this.name=name;
        this.address=address;
        this.agent=agent;
        this.phoneNumber=phoneNumber;
    }
}
