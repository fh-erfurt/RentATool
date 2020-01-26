package de.rat.billing;

import de.rat.customer.Customer;
import de.rat.customer.RentProcess;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;
import de.rat.employee.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**Represents a class bill.
 * Hold a list of every rentprocess from a customer
 * for a specific date.
 * @author Danny Steinbrecher
 */


/** Creates a billing class .
 * @param openBills a list from open bills
 * @param closedBills a list from closed bills
 * @param checkBills a list from the bills that still have to be checked from the employee
 */
public class Billing {

    private static  ArrayList<Bill> openBills = new ArrayList<Bill>();
    private static  ArrayList<Bill> checkBills = new ArrayList<Bill>();
    private static  ArrayList<Bill> closedBills = new ArrayList<Bill>();

    public Billing() {
    }


    public static ArrayList<Bill> getOpenBills() {
        return openBills;
    }

    public static ArrayList<Bill> getCheckBills() {
        return checkBills;
    }

    public static ArrayList<Bill> getClosedBills() {
        return closedBills;
    }

    /** Find a open bill from the customer where the date is the actual date.
     * @return A class bill when the customer has a open bill, otherwise
     * @return null if there are no open bills
     */
    public static Bill findOpenBillFromCustomer(Customer customer){
        for (Bill foundedBill : openBills) {

            // get date of today for comparing with rentDate
            GregorianCalendar today = new GregorianCalendar();
            int compareRentDates = foundedBill.calculateDifferenceBetweenDates(foundedBill.getRentDate(),today);
            // use only the founded Bill customer, is the same and today is the rentDay of the Bill
            if (foundedBill.getCustomer().equals(customer)&& compareRentDates == 1) {
                System.out.println("Die Rechnung wurde gefunden!");
                return foundedBill;
            }
        }
        System.out.println("Es konnte keine passende Offene Rechnung gefunden werden");
        return null;
    }


    /** Find a open bill from the customer and complete the rent processes
     * @return A class bill when the customer has a open bill, otherwise
     * @return null if there are no open bills
     */
    public static Bill findOpenBillFromCustomerForReturn(Customer customer, Tool wantedTool, Station removeStation)
    {
        GregorianCalendar today = new GregorianCalendar();
        for (Bill foundedBill : openBills) {

            RentProcess rentprocess = foundedBill.findRentProcess(wantedTool);
            // use only the founded Bill, customer is the same and today is the rentDay of the Bill
            if (foundedBill.getCustomer().equals(customer)&& rentprocess!= null) {

                rentprocess.completeRentProcess(removeStation, today);
                System.out.println("Die Rechnung wurde gefunden");
                return foundedBill;
            }
        }

        EmployeeNotification.sendNotificationToAllEmployeesToCheckTheOpenBills(customer);
        System.out.println("Die Rechnung wurde nicht gefunden!");
        return null;
    }

    /** Create a bill from the customer
     * @return A class bill with the customer and the pickup station
     */
    public static Bill CreateOpenBillFromCustomer(Station pickupStation, Customer customer){
        Bill newBill = new Bill(customer, pickupStation);
        openBills.add(newBill);


        for (Bill foundedBill : openBills)
        {
            System.out.println(foundedBill.getCustomer());
        }


        System.out.println("Rechnung wurde erstellt und zu der OpenBill-Liste hinzugefügt");
        return newBill;
    }

    /** Move the  bills from the openBill Array to the checkedBill Array
     * and send a notification to all employee's
     * @param checkBills bills that have to checked from the employee
     * @param openBills bills with open rent processes

     */

    public static void checkBillsFromCustomerAndMoveThemToTheCkeckedListIfAllRentProcessesAreClosed(Customer customer) {

        Iterator iterator = openBills.iterator();   //TODO: Iterator???
        while (iterator.hasNext()) {
            Bill bill = (Bill) iterator.next();
            if (bill.getCustomer().equals(customer)) {
                if(bill.checkIfAllRentProcessesFromABillAreClosed()) {
                    bill.setFullRentPrice();
                    System.out.println("Der Gesamtpreis wurde eingetragen!");

                    iterator.remove();
                    checkBills.add(bill);
                    System.out.println("Rechnung wurde von Open zu Checked verschoben");

                    EmployeeNotification.sendNotificationToAllEmployees();
                    return;
                }
            }
        }
    }





    /** Find a bill in a List of Bills by a Reference Bill
     * @return A bill when the bill was in this List
     * @return null if the bill was not in this list
     */
    public static Bill findBillInListByReference(Bill bill, ArrayList<Bill> billList ){
        for (Bill foundedBill : billList) {
            if (foundedBill.equals(bill)) {
                return foundedBill;
            }
        }
        return null;
    }

    /** Move the  bills from the checkBill Array to the closeBill Array
     * @param checkBills bills that have to checked from the employee
     * @param closedBills bills with closed bills

     */

    //TODO: musste hier auch mit dem Iterator arbeiten: bitte prüfen
    public static void moveFromCheckToClosed(Bill checkBill)
    {
        Iterator iterator = checkBills.iterator();
        while (iterator.hasNext())
        {
            Bill bill = (Bill) iterator.next();
            if(bill == checkBill)
            {
                iterator.remove();
                closedBills.add(bill);
                System.out.println("Rechnung wurde von Open zu Checked verschoben");

            }
        }

    }



    /**Find or Create open bill.
     * @param customer the customer that rented the tool
     * @param pickupStation the station which the tool was pickup
     * create a new open bill with include the pickup station an customer
     */
    public static Bill findOrCreateBill(Customer customer, Station pickupStation){
        Bill bill = findOpenBillFromCustomer(customer);
        if(bill == null){
            bill = CreateOpenBillFromCustomer(pickupStation, customer);
            return bill;
        }
        System.out.println("Eine Rechnung wurde gefunden");
        return bill;
    }
}
