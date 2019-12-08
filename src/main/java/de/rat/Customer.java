package de.rat;

import java.text.DateFormat;
import java.util.Date;

public class Customer extends Person{

    private String phoneNumber;
    Customer(String lastname, String firstname, String birthday,
             String email,
                    String street, int hauseNr, int zip, String city, String country,
                    String phoneNumber)
    {
        super(lastname, firstname, birthday, street, hauseNr,  zip,  city,  country);
        this.account = new Account("Kunde", email, createPassword(lastname, firstname));
        this.phoneNumber = phoneNumber;
        customerList.add(this); // add the customer to the list in the main class
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean reserveTool(String toolname, Date pickupDate, Station pickupStation){

        return true;
    }
}
