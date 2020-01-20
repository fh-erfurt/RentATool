package de.rat.billing;

import de.rat.customer.Customer;
import de.rat.customer.RentProcess;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;
import de.rat.employee.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Billing {
    /** Creates an rental .
     * @param openBills a list from open bills
     * @param closedBills a list from closed bills
     */
    static private ArrayList<Bill> openBills = new ArrayList<Bill>();
    static private ArrayList<Bill> checkBills = new ArrayList<Bill>();
   static private ArrayList<Bill> closedBills = new ArrayList<Bill>();



    /** Find a open bill from the customer.
     * @return A class bill when the customer has a open bill, otherwise
     * @return null if there are no open bills
     */
    public Bill findOpenBillFromCustomer(Customer customer){
        for (Bill foundedBill : openBills) {

            // get date of today for comparing with rentDate
            GregorianCalendar today = new GregorianCalendar();
            int compareRentDates = foundedBill.calculateDifferenceBetweenDates(foundedBill.getRentDate(),today);
            // use only the founded Bill customer is the same and today is the rentDay of the Bill
            if (foundedBill.getCustomer().equals(customer)&& compareRentDates == 0) { // TODO : was ist hier mit dem ==0
                return foundedBill;
            }
        }
        return null;
    }

    public Bill findOpenBillFromCustomerForReturn(Customer customer, Tool wantedTool, Station removeStation, GregorianCalendar Date)
    {
        for (Bill foundedBill : openBills) {

            RentProcess rentprocess = foundedBill.findRentProcess(wantedTool);
            // use only the founded Bill, customer is the same and today is the rentDay of the Bill
            if (foundedBill.getCustomer().equals(customer)&& rentprocess!= null) {

                rentprocess.completeRentProcess(removeStation, Date);
                return foundedBill;
            }
        }
        return null;
    }

    /** Create a bill from the customer
     * @return A class bill with the customer and the pickup station
     */
    public Bill CreateOpenBillFromCustomer(Station pickupStation, Customer customer){
        Bill newBill = new Bill(customer, pickupStation);
        openBills.add(newBill);
        return newBill;
    }

    public void moveBillFromOpenToChecked()
    {
        for (Bill foundedBill : openBills)
        {
            if(foundedBill.getFullRentPrice() != 0)
            {
                checkBills.add(foundedBill);
                openBills.remove(foundedBill);
                EmployeeNotification.sendNotificationToAllEmployees();
            }
        }
    }

    public boolean moveFromCheckToClosed(Bill checkBill)
    {
        for(Bill foundedBill:checkBills)
        {
            if(foundedBill==checkBill)
            {
                closedBills.add(checkBill);
                checkBills.remove(checkBill);
                return true;
            }
        }
        return false;
    }
}