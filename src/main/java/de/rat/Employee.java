package de.rat;

import java.text.DateFormat;

public class Employee extends Person{

   private Department department;
   private Employee supervisor;

    public Employee(String lastname, String firstname, String birthday, Address address, Account account, Department department, Employee supervisor) {
        super(lastname, firstname, birthday, address, account);
        this.department = department;
        this.supervisor = supervisor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
}
