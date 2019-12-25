package de.rat;

import java.util.GregorianCalendar;

public class Employee extends Person{

   private Department department;
   private Person supervisor;  //TODO: why does an employee class not work here?

    Employee(String lastname, String firstname, GregorianCalendar birthday,
             String street, int houseNr, int zip, String city, String country,
             Department department, Employee supervisor) {

        super(lastname, firstname, birthday, street, houseNr,  zip,  city,  country);
        this.account = new Account(Role.EMPLOYEE, createEmail(lastname, firstname), createPassword(lastname, firstname, birthday));
        this.department = department;
        this.supervisor = supervisor;
    }

    Employee(String lastname, String firstname, GregorianCalendar birthday,
             String street, int houseNr, int zip, String city, String country,
             Department department) {

        super(lastname, firstname, birthday, street, houseNr,  zip,  city,  country);
        this.account = new Account(Role.EMPLOYEE, createEmail(lastname, firstname), createPassword(lastname, firstname, birthday));
        this.department = department;
        this.supervisor = null;
    }

    private String  createEmail(String lastname, String firstname){
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@rat.de";
    }


    public Person getSupervisor() {
        return supervisor;
    }
}
