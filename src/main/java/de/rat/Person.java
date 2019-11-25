package de.rat;

import java.text.DateFormat;

public abstract class Person {

    private final String lastname;
    private String firstname;
    private String birthday;    // updated to DateFormat later
    private Address address;
    private Account account;

    public Person(String lastname, String firstname, String birthday, Address address, Account account) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.address = address;
        this.account = account;
    }
}
