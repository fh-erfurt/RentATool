package de.rat;

import java.text.DateFormat;
import java.util.ArrayList;

public abstract class Person {

    private final String lastname;
    private String firstname;
    private String birthday;    // TODO updated to DateFormat
    private Address address;
    protected Account account;
    static ArrayList<Person> customerList =  new ArrayList<Person>(); // TODO merge the two lists
    static ArrayList<Person> employeeList = new ArrayList<Person>();

    public Person(String lastname, String firstname, String birthday,
                  String street, int hauseNr, int zip, String city, String country) {

        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.address = new Address(street, hauseNr, zip, city, country);
    }

    public String createPassword(String lastname, String firstname) {
        return lastname;
    }


    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getBirthday() {
        return birthday;
    }

    public Address getAddress() {
        return address;
    }

    public Account getAccount() {
        return account;
    }

    public static ArrayList<Person> getCustomerList() {
        return customerList;
    }

    public static ArrayList<Person> getEmployeeList() {
        return employeeList;
    }
}
