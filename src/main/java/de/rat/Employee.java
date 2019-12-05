package de.rat;

import java.text.DateFormat;

public class Employee extends Person{

   private Department department;
   private Employee supervisor;

    Employee(String lastname, String firstname, String birthday,
             String role, String email, String password,
             String street, int hauseNr, int zip, String city, String country,
             Department department, Employee supervisor)
    {
        super(lastname, firstname, birthday, role, email,  password, street, hauseNr,  zip,  city,  country);
        this.department = department;
        this.supervisor = supervisor;
        employeeList.add(this); //add the employee to the list in the main class
    }

    Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
}
