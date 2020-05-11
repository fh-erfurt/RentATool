package de.rat.domain.billing;

import de.rat.domain.common.*;
import de.rat.domain.common.Date;
import de.rat.domain.customer.*;
import de.rat.domain.logistics.*;
import de.rat.domain.employee.*;

import java.util.*;
import java.util.logging.Logger;

/**Represents a class bill.
 * Hold a list of every rentprocess from a customer
 * for a specific date.
 * @author Marco Petzold, Christian König, Danny Steinbrecher, Bilal Alnani
 */


/** Creates a billing class .
 * openBills a list from open bills
 * closedBills a list from closed bills
 * checkBills a list from the bills that still have to be checked from the employee
 */
public class Billing {
    private static final Logger logger = Logger.getLogger("LOGGER");
    private static  ArrayList<Bill> openBills = new ArrayList<Bill>();
    private static  ArrayList<Bill> checkBills = new ArrayList<Bill>();
    private static  ArrayList<Bill> closedBills = new ArrayList<Bill>();


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
        // get date of today for comparing with rentDate
        GregorianCalendar today =  Date.getToday();

        Bill searchedBill = openBills.stream()
                .filter(bill -> Date.compareDates(bill.getRentDate(), Operator.GREATER_OR_EQUAL, today) && bill.getCustomer().equals(customer))
                .findAny()
                .orElse(null);

        logger.info( (searchedBill != null ) ? "Die Rechnung wurde gefunden!" : "Es konnte keine passende Offene Rechnung gefunden werden");

        return searchedBill;
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
            if (foundedBill.getCustomer().equals(customer) && rentprocess!= null) {

                rentprocess.completeRentProcess(removeStation, today);
                logger.info("Die Rechnung wurde gefunden");
                return foundedBill;
            }

        }
        EmployeeNotification.sendNotificationToAllEmployeesToCheckTheOpenBills(customer);
        logger.severe("Die Rechnung wurde nicht gefunden!");
        return null;
    }


    /** Create a bill from the customer
     * @return A class bill with the customer and the pickup station
     */
    public static Bill createOpenBillFromCustomer(Station pickupStation, Customer customer){
        Bill newBill = new Bill(customer, pickupStation);
        openBills.add(newBill);
        logger.info("Rechnung wurde erstellt und zu der OpenBill-Liste hinzugefügt");
        return newBill;
    }


    /** Move the  bills from the openBill Array to the checkedBill Array
     * and send a notification to all employee's
     * checkBills bills that have to checked from the employee
     * openBills bills with open rent processes

     */
    public static void checkBillsFromCustomerAndMoveThemToTheCkeckedListIfAllRentProcessesAreClosed(Customer customer) {

        Iterator<Bill> iterator = openBills.iterator();
        while (iterator.hasNext()) {
            Bill bill = iterator.next();
            if (bill.getCustomer().equals(customer)) {
                if(bill.checkIfAllRentProcessesFromABillAreClosed()) {
                    bill.setFullRentPrice();
                    logger.info("Der Gesamtpreis wurde eingetragen!");

                    iterator.remove();
                    checkBills.add(bill);
                    logger.info("Rechnung wurde von Open zu Checked verschoben");

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
    public static Bill findBillInListByReference(Bill searchedBill, ArrayList<Bill> billList ){
        return billList.stream().filter(bill -> bill.equals(searchedBill)).findFirst().orElse(null);
    }


    /** Move the  bills from the checkBill Array to the closeBill Array
     * checkBills bills that have to checked from the employee
     * closedBills bills with closed bills

     */
    public static void moveFromCheckToClosed(Bill checkBill)
    {
        Iterator<Bill> iterator = checkBills.iterator();
        while (iterator.hasNext())
        {
            Bill bill = iterator.next();
            if(bill == checkBill)
            {
                iterator.remove();
                closedBills.add(bill);
                logger.info("Rechnung wurde von Checked zu Closed verschoben");

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
            bill = createOpenBillFromCustomer(pickupStation, customer);
            logger.info("Eine neue Rechnung wurde erstellt!");
            return bill;
        }
        logger.info("Eine Rechnung wurde gefunden!");
        return bill;
    }
}