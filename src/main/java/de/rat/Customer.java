package de.rat;

import java.text.DateFormat;

public class Customer extends Person{

    private String phoneNumber;


    public Customer(String lastname, String firstname, String birthday, Address address, Account account, String phoneNumber) {
        super(lastname, firstname, birthday, address, account);
        this.phoneNumber = phoneNumber;
    }
}
