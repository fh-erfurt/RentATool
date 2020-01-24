package de.rat;

import de.rat.billing.Bill;
import de.rat.billing.Billing;
import de.rat.customer.Customer;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;
import de.rat.logistics.Warehouse;

import java.util.GregorianCalendar;
/**Represents an rental.
 * @author Danny Steinbrecher
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

        //check if the searched Tool is in the warehouse
        if(warehouse.removeToolFromWarehouse(wantedTool) == null){ return false;}

        //check if the station is full
        if(pickupStation.checkStationLevel()){return false;}

        Bill bill = Billing.findOrCreateBill(customer, pickupStation);

        bill.addRentProcess(wantedTool);

        return pickupStation.addToolToBox(wantedTool);
    }

    public boolean returnTool(Tool wantedTool, Station removeStation, Customer customer, Warehouse warehouse, GregorianCalendar date){


            /**Gets the wanted tool.
             * @return false when the returnTool that store in the remove station
             * is not the wanted tool, otherwise the wanted tool is store in the warehouse
             */

            if(removeStation.removeToolFromBox(wantedTool) == null){ return false;}
            warehouse.putToolInWarehouse(wantedTool);

            /**Gets the open bill.
             * @return false if there are no open bills from the customer
             */

            Bill bill = Billing.findOpenBillFromCustomerForReturn(customer,wantedTool, removeStation, date);
            if(bill == null){return false;}

            if(!bill.checkBill(customer)) { return false; }

            Billing.moveBillFromOpenToChecked();

        return true;
    }





}
