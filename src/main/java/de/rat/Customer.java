package de.rat;

import java.text.DateFormat;

public class Customer extends Person{

    private String phoneNumber;
    Customer(String lastname, String firstname, String birthday,
                    String role, String email, String password,
                    String street, int hauseNr, int zip, String city, String country,
                    String phoneNumber)
    {
        super(lastname, firstname, birthday, role, email,  password, street, hauseNr,  zip,  city,  country);
        this.phoneNumber = phoneNumber;
        customerList.add(this); // add the customer to the list in the main class
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
