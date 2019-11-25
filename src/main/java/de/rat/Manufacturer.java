package de.rat;

public class Manufacturer {
    private static short  manufacturerId=0;
    private String name;
    private String address;
   private String agent;
   private String phoneNumber;


    public Manufacturer( String name, String address, String agent, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.agent = agent;
        this.phoneNumber = phoneNumber;
        manufacturerId++;
    }



    public short getManufacturerId() {
        return manufacturerId;
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

    public void setManufacturerId(short manufacturerId) {
        this.manufacturerId = manufacturerId;
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
}
