package de.rat.employee;


import de.rat.billing.Billing;
import de.rat.logistics.*;
import de.rat.billing.Bill;
import de.rat.common.Person;
import de.rat.common.Role;
import de.rat.common.Account;


import java.util.GregorianCalendar;

/** Creates station .
 *  @param supervisor from the employee
 *
 */

public class Employee extends Person {

    private Employee supervisor;


    /** constructor for the employee
     *  @param super constructor from the person
     *  @param account from the employee
     *  @param department from the employee
     *  @param supervisor from the employee
     */
    public Employee(String lastname, String firstname, GregorianCalendar birthday,
             String street, int houseNr, int zip, String city, String country,
             Employee supervisor) {

        super(lastname, firstname, birthday, street, houseNr,  zip,  city,  country);
        this.account = new Account(Role.EMPLOYEE, createEmail(lastname, firstname), createPassword());
        this.supervisor = supervisor;
    }

 //ToDO??????
    Employee(String lastname, String firstname, GregorianCalendar birthday,
             String street, int houseNr, int zip, String city, String country) {

        super(lastname, firstname, birthday, street, houseNr,  zip,  city,  country);
        this.account = new Account(Role.EMPLOYEE, createEmail(lastname, firstname), createPassword());
        this.supervisor = null;
    }


    /** get the supervisor
     * @return supervisor  from the employee
     *
     */
    public Person getSupervisor() {
        return supervisor;
    }


    /** create default email for the employee
     * @return firstname+lastname+rat.de
     *
     */
    private String  createEmail(String lastname, String firstname){
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@rat.de";
    }



    /** set the discount an move the bill to the closed bill
     * @return true
     *
     */
    public boolean setDiscountAndMoveBillsToCloseBills(Bill checkBill,int discount)
    {
        //TODO: musste aufgrund der static änderungen in der Billing und dem setzten von Boolean auf Void für die kmode Methode angepasst werden
        // muss geprüft werde
        checkBill.setDiscount(discount);
        checkBill.setFullRentPrice();

        //Billing billing=new Billing();
        Billing.moveFromCheckToClosed(checkBill);
        return true;
    }


    /** set the tool status for the tool that was returned to the warehouse
     * @return true if the tool status was set from the warehouse method setToolStatus
     *
     */
    public boolean setToolStatus(Tool tool,ToolStatus toolStatus,Warehouse warehouse)
        {
            return warehouse.setToolStatus(tool, toolStatus);
        }

    /** is a notification for the employee to checked the array list check bills
     * @return println
     *
     */
        public void printNotification()
        {
           System.out.println("Bitte schau deine aktuellen Aufträge an!!!");
        }

}

