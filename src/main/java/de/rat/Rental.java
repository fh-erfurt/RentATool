package de.rat;

import de.rat.billing.Bill;
import de.rat.customer.Customer;
import de.rat.customer.RentProcess;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;
import de.rat.logistics.Warehouse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**Represents an rental.
 * @author ???
 * @version ??
 * @since 1??
 */
public class Rental {
    /** Creates an rental .
     * @param openBills a list from open bills
     * @param closedBills a list from closed bills
     */
    private ArrayList<Bill> openBills = new ArrayList<Bill>();
    private ArrayList<Bill> closedBills = new ArrayList<Bill>();



    /** Creates an rental .
     * @param --
     */
    public Rental() {
    }

    /** Creates an rental from the tool .
     *  @param wantedTool the tool that would by rented
     *  @param pickupStation the station which the tool was pickup
     *  @param customer the customer that rented the tool
     *  @param warehouse the the warehouse which the tool was removed in
     *  store in the pickupStation
     */
    public boolean rentATool(Tool wantedTool, Station pickupStation, Customer customer, Warehouse warehouse) {


        /**check if the station is full
         * @return false ????
         */
        if(!pickupStation.checkStationLevel()){
            return false;
        }

        /**check if the searched Tool is in the warehouse
         * @return false ????
         */
        if(warehouse.removeToolFromWarehouse(wantedTool) == null){
            return false;
        }

        /**Gets the open bill.
         * @param bill if there are no open bills from the customer
         * create a new open bill with include the pickup station an customer
         */
        Bill bill = this.findOpenBillFromCustomer(customer);
        if(bill == null){
            bill = this.CreateOpenBillFromCustomer(pickupStation, customer);
        }
        /** Put the wanted tool in the rent process
         * @return true if the rent process was add to the list of rent processes and
         * the wanted tool was add to the pickupStation
         */
        RentProcess rentProcess = new RentProcess(wantedTool);

        bill.getListOfRentProcesses().add(rentProcess);     // TODO: wenn in Bill die neue Methode existiert, dann diese Verwenden
        pickupStation.addToolToBox(wantedTool);
        return true;
    }

    public boolean returnTool(Tool wantedTool, Station removeStation, Customer customer, Warehouse warehouse, GregorianCalendar date){
        /**Gets the wanted tool.
         * @return false when the returnTool that store in the remove station
         * is not the wanted tool, otherwise the wanted tool is store in the warehouse
         */

        if(removeStation.removeToolFromBox(wantedTool) == null){
            return false;
        }
        warehouse.putToolInWarehouse(wantedTool);

        /**Gets the open bill.
         * @return false if there are no open bills from the customer
         */
        Bill bill = findOpenBillFromCustomerForReturn(customer,wantedTool, removeStation, date);
        if(bill == null){
            return false;
        }
        /**Gets the rent process in which the wanted Tool was rented.
         * @return false if there are no rent process
         */
        // wird in finOpenBillFromCustomerForReturn bereits gerpüft
        /*RentProcess rentprocess = bill.findRentProcess(wantedTool);
        if(rentprocess == null){
            return false;
        }*/

        /**Gets the rent process with the remove station an date.
         * @return true if the bill was close
         */
        // rentprocess.completeRentProcess(removeStation, date);
        // wird in finOpenBillFromCustomerForReturn bereits gesetzt

        //ToDo Fall wenn letztes Werkzeug abgegeben wurde, aber was wenn nicht?wie rausfiltern?
        if(bill.closeBill(customer, 2))
        {
           return true;
        }
        //ToDo else??


        return true;
    }

    /** Find a open bill from the customer.
     * @return A class bill when the customer has a open bill, otherwise
     * @return null if there are no open bills
     */
    public Bill findOpenBillFromCustomer(Customer customer){
        for (Bill foundedBill : this.openBills) {

            // get date of today for comparing with rentDate
            GregorianCalendar today = new GregorianCalendar();
            int compareRentDates = foundedBill.calculateDifferenceBetweenDates(foundedBill.getRentDate(),today);
            // use only the founded Bill customer is the same and today is the rentDay of the Bill
            if (foundedBill.getCustomer().equals(customer)&& compareRentDates == 0) {
                return foundedBill;
            }
        }
        return null;
    }

    public Bill findOpenBillFromCustomerForReturn(Customer customer,Tool wantedTool,Station removeStation, GregorianCalendar Date)
    {
        for (Bill foundedBill : this.openBills) {

            RentProcess rentprocess = foundedBill.findRentProcess(wantedTool);
            // use only the founded Bill customer is the same and today is the rentDay of the Bill
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
        this.openBills.add(newBill);
        return newBill;
    }

    public boolean moveBillFromOpenToClosed()
    {
        for (Bill foundedBill : this.openBills)
        {
            if(foundedBill.getFullRentPrice() != 0)
                {
                    this.closedBills.add(foundedBill);
                    this.openBills.remove(foundedBill);
                    return true;
                }
        }
        return false;
    }
}
