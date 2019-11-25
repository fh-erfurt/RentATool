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
