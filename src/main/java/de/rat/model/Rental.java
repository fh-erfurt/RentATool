package de.rat.model;

import de.rat.model.billing.*;
import de.rat.model.customer.*;
import de.rat.model.logistics.*;

/**Represents an rental.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */

public class Rental {

    /** Creates an rental from the tool .
     *  @param wantedTool the tool that would by rented
     *  @param pickupStation the station which the tool was pickup
     *  @param customer the customer that rented the tool
     *  @param warehouse the the warehouse which the tool was removed in
     *  store in the pickupStation
     */
    public static boolean rentATool(Tool wantedTool, Station pickupStation, Customer customer, Warehouse warehouse) {

        //if the tool is not in the warehouse we get false
        if(warehouse.removeToolFromWarehouse(wantedTool) == null){ return false;}

        //if the station is full we get false
        if(!pickupStation.addToolToBox(wantedTool)){return false;}

        Bill bill = Billing.findOrCreateBill(customer, pickupStation);

        bill.addRentProcess(wantedTool);

        return true;
    }


    /**return the wanted tool.
     * return false when the returnTool that store in the remove station
     * is not the wanted tool, otherwise the wanted tool is store in the warehouse
     * return false if the customer is not he right customer
     * return true if the return process complete
     */
    public static boolean returnTool(Tool wantedTool, Station removeStation, Customer customer, Warehouse warehouse){

        //if the tool is not in the station we get false
        if(removeStation.removeToolFromBox(wantedTool) == null){ return false; }

        warehouse.putToolInWarehouse(wantedTool);

        //if we have no open Bill from this Customer we get false
        if(Billing.findOpenBillFromCustomerForReturn(customer,wantedTool, removeStation) == null){return false;}

        Billing.checkBillsFromCustomerAndMoveThemToTheCkeckedListIfAllRentProcessesAreClosed(customer);
        return true;
    }
}
