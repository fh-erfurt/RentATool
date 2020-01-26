package de.rat.employee;

import de.rat.billing.*;
import de.rat.customer.*;
import de.rat.logistics.*;
import de.rat.common.*;

import java.util.GregorianCalendar;

/**Represents an Employee.
 * extends from Person
 * @author Danny Steinbrecher
 */

public class Employee extends Person {

    private Employee supervisor;

    /** constructor for the employee - with supervisor
     *  @param lastname the lastname from the Employee
     *  @param firstname the firstname from the Employee
     *  @param birthday the birthday from the Employee
     *  The next attributes are for the Address
     *  @param street the street from the Address, where the Employee lives
     *  @param houseNr the houseNr from the Address, where the Employee lives
     *  @param zip the zip-code from the Address, where the Employee lives
     *  @param city the city from the Address, where the Employee lives
     *  @param country the country from the Address, where the Employee lives
     *  Employee Information
     *  @param supervisor the supervisor from the Employee
     */
    public Employee(String lastname, String firstname, GregorianCalendar birthday,
             String street, int houseNr, int zip, String city, String country,
             Employee supervisor) {

        super(lastname, firstname, birthday, street, houseNr,  zip,  city,  country);
        this.account    = new Account(Role.EMPLOYEE, createEmail(lastname, firstname), createPassword());
        this.supervisor = supervisor;
    }

    /** constructor for the employee - without supervisor
     *  @param lastname the lastname from the Employee
     *  @param firstname the firstname from the Employee
     *  @param birthday the birthday from the Employee
     *  The next attributes are for the Address
     *  @param street the street from the Address, where the Employee lives
     *  @param houseNr the houseNr from the Address, where the Employee lives
     *  @param zip the zip-code from the Address, where the Employee lives
     *  @param city the city from the Address, where the Employee lives
     *  @param country the country from the Address, where the Employee lives
     *  Employee Information
     */
    public Employee(String lastname, String firstname, GregorianCalendar birthday,
             String street, int houseNr, int zip, String city, String country) {

        super(lastname, firstname, birthday, street, houseNr,  zip,  city,  country);
        this.account    = new Account(Role.EMPLOYEE, createEmail(lastname, firstname), createPassword());
        this.supervisor = null;
    }

    // Getter
    public Person getSupervisor() {
        return supervisor;
    }


    // Methods
    /** create default email for the employee
     * @return firstname + lastname + rat.de
     *
     */
    private String  createEmail(String lastname, String firstname){
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@rat.de";
    }

    /** set the tool status for the tool that was returned to the warehouse
     * @return true if the tool status was set from the warehouse method setToolStatus
     *
     */
    public boolean setToolStatus(Tool tool,ToolStatus toolStatus,Warehouse warehouse) {
        return warehouse.setToolStatus(tool, toolStatus);
    }

    /** is a notification for the employee to checked the array list check bills
     *
     */
    public void printNotification() {
        System.out.println("Hallo " + this.getFirstname() + ", es liegen neue Rechnungen zum bearbeiten vor!");

    }

    /** is a notification for the employee to checked the open Bills because of an Problem
     *
     */
    public void printNotificationCheckOpenBills(Customer customer) {
        System.out.println("Hallo " + this.getFirstname() + ", gibt ein Problem mit einer Offenen Rechnung vom Kunden: " + customer.getFirstname() + " " + customer.getLastname());
    }

    /** set the discount an move the bill to the closed bill
     * @return boolean
     *
     */
    public boolean setDiscountAndMoveBillsToCloseBills(Bill checkBill, int discount) {
        if(checkBill != null){
            checkBill.setDiscount(discount);
            checkBill.setFullRentPrice();

            Billing.moveFromCheckToClosed(checkBill);

            System.out.println("Rechnung wurde erfolgreich geprüft und bearbeitet.");
            System.out.println("Rechnung wurde in die closedBill verschoben.");
            return true;
        }
        System.out.println("Keine Rechnung übergeben.");
        return false;
    }
}

