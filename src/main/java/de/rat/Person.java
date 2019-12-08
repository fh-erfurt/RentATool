package de.rat;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Map;

public abstract class Person {

    private final String lastname;
    private String firstname;
    private String birthday;    // updated to DateFormat later
    private Address address;
    private Account account;
    static ArrayList<Person> customerList =  new ArrayList<Person>(); // TODO merge the two lists
    static ArrayList<Person> employeeList = new ArrayList<Person>();

    public Person(String lastname, String firstname, String birthday,
                  String role, String email, String password,
                  String street, int hauseNr, int zip, String city, String country) {

        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.address = new Address(street, hauseNr, zip, city, country);
        this.account = new Account(role, email, password);

    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
