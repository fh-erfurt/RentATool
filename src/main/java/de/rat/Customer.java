package de.rat;

import java.util.Date;
import java.util.GregorianCalendar;

public class Customer extends Person{

    private String phoneNumber;
    private Company companyName;
    Customer(String lastname, String firstname, GregorianCalendar birthday,
             String email, String street, int hauseNr, int zip, String city, String country, String phoneNumber,Company companyName)
    {
        super(lastname, firstname, birthday, street, hauseNr,  zip,  city,  country);
        this.account = new Account(Role.CUSTOMER, email, createPassword(lastname, firstname, birthday));
        this.phoneNumber = phoneNumber;
        this.companyName=companyName;
        customerList.add(this); // add the customer to the list in the main class
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean reserveTool(Tool wantedTool, Date pickupDate, Station pickupStation){

        for (Tool foundedTool : companyName.getStock())
        {
            if (foundedTool.equals(wantedTool))
            {
                companyName.getStock().remove(wantedTool);
                pickupStation.addToolToBox(wantedTool);
                return true;
            }
        }
        return false;
    }
}
