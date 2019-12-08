package de.rat;

import java.text.DateFormat;

public class Employee extends Person{

   private Department department;
   private Employee supervisor;

    Employee(String lastname, String firstname, String birthday,
             String street, int hauseNr, int zip, String city, String country,
             Department department, Employee supervisor)
    {
        super(lastname, firstname, birthday, street, hauseNr,  zip,  city,  country);
        this.account = new Account("Mitarbeiter", createEmail(lastname, firstname), createPassword(lastname, firstname));
        this.department = department;
        this.supervisor = supervisor;
        employeeList.add(this); //add the employee to the list in the main class
    }


    private String  createEmail(String lastname, String firstname){
        return lastname + "." + firstname + "@rat.de";
    }

    public Department getDepartment() {
        return department;
    }

    public Employee getSupervisor() {
        return supervisor;
    }
}
