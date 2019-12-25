package de.rat;

import java.util.GregorianCalendar;

public abstract class Person {

    private String lastname;
    private String firstname;
    private GregorianCalendar birthday;
    private Address address;
    protected Account account;

    public Person(String lastname, String firstname, GregorianCalendar birthday,
                  String street, int hauseNr, int zip, String city, String country) {

        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.address = new Address(street, hauseNr, zip, city, country);
    }


    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public GregorianCalendar getBirthday() {
        return birthday;
    }

    public Address getAddress() {
        return address;
    }

    public Account getAccount() {
        return account;
    }

    String createPassword(String lastname, String firstname, GregorianCalendar birthday) {

        //da241289st
        String shortFirstname = firstname.substring(0,2).toLowerCase();
        String shortLastname = lastname.substring(0,2).toLowerCase();
        int shortDay = birthday.get(GregorianCalendar.DATE);
        int shortMonth = (birthday.get(GregorianCalendar.MONTH) + 1 );
        String shortYear = Integer.toString(birthday.get(GregorianCalendar.YEAR)).substring(2,4);

        return shortFirstname + (shortDay < 10 ? "0" : "") + shortDay   + (shortMonth < 10 ? "0" : "") + shortMonth + shortYear + shortLastname;
    }

}
