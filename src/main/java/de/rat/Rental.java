package de.rat;

import de.rat.billing.Bill;
import de.rat.billing.Billing;
import de.rat.customer.Customer;
import de.rat.customer.RentProcess;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;
import de.rat.logistics.Warehouse;

import java.io.IOException;
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

        try{
            //check if the station is full
            if(!pickupStation.checkStationLevel()){return false;}

            //check if the searched Tool is in the warehouse
            if(warehouse.removeToolFromWarehouse(wantedTool) == null){ return false;}

            Bill bill = this.findOrCreateBill(customer, pickupStation);

            //TODO:
            // Put the wanted tool in the rent process
            RentProcess rentProcess = new RentProcess(wantedTool);

            bill.addRentProcess(rentProcess);

            pickupStation.addToolToBox(wantedTool);
            return true;
        }
        catch (IOException e){

        }

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

        Bill bill = new Billing().findOpenBillFromCustomerForReturn(customer,wantedTool, removeStation, date);
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

        if(bill.checkBill(customer)) {
            new Billing().moveBillFromOpenToChecked();
        }

        return true;
    }


    /**Gets or Create open bill.
     * @param customer the customer that rented the tool
     * @param pickupStation the station which the tool was pickup
     * create a new open bill with include the pickup station an customer
     */
    private Bill findOrCreateBill(Customer customer, Station pickupStation){
        Bill bill = new Billing().findOpenBillFromCustomer(customer);
        if(bill == null){
            bill = new Billing().CreateOpenBillFromCustomer(pickupStation, customer);
        }
        return bill;
    }


}
