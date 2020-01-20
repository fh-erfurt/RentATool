package de.rat.employee;


import de.rat.billing.Billing;
import de.rat.logistics.*;
import de.rat.billing.Bill;
import de.rat.common.Person;
import de.rat.common.Role;
import de.rat.common.Account;


import java.util.GregorianCalendar;

public class Employee extends Person {

    private Department department;
    private Employee supervisor;

    public Employee(String lastname, String firstname, GregorianCalendar birthday,
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

    public Person getSupervisor() {
        return supervisor;
    }

    private String  createEmail(String lastname, String firstname){
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@rat.de";
    }

    public boolean setDiscountAndMoveBillsToCloseBills(Bill checkBill,int discount)
    {
        checkBill.setDiscount(discount);
        checkBill.setFullRentPrice();

        Billing billing=new Billing();
        return billing.moveFromCheckToClosed(checkBill);

    }



    public boolean setToolStatus(Tool tool,ToolStatus toolStatus,Warehouse warehouse)
        {
            return warehouse.setToolStatus(tool, toolStatus);
        }


}

