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

        try{
            //check if the station is full
            if(!pickupStation.checkStationLevel()){return false;}

            //check if the searched Tool is in the warehouse
            if(warehouse.removeToolFromWarehouse(wantedTool) == null){ return false;}

            Bill bill = this.findOrCreateBill(customer, pickupStation);

            //TODO:
            // Methode in Bill wird den RentProcess mit erstellen
            // Put the wanted tool in the rent process
            RentProcess rentProcess = new RentProcess(wantedTool);
            bill.addRentProcess(rentProcess);

            if(!pickupStation.addToolToBox(wantedTool)){return false;}
        }
        catch (Exception e){
            System.out.println(getClass() + ": " + e.getMessage());
        }
        return true;
    }

    public boolean returnTool(Tool wantedTool, Station removeStation, Customer customer, Warehouse warehouse, GregorianCalendar date){

        try{
            /**Gets the wanted tool.
             * @return false when the returnTool that store in the remove station
             * is not the wanted tool, otherwise the wanted tool is store in the warehouse
             */

            if(removeStation.removeToolFromBox(wantedTool) == null){ return false;}
            warehouse.putToolInWarehouse(wantedTool);

            /**Gets the open bill.
             * @return false if there are no open bills from the customer
             */

            Bill bill = new Billing().findOpenBillFromCustomerForReturn(customer,wantedTool, removeStation, date);
            if(bill == null){
                return false;
            }

            if(!bill.checkBill(customer)) { return false; }

               Billing billing =new Billing();
               billing.moveBillFromOpenToChecked();


        } catch (Exception e){
            System.out.println(getClass() + ": " + e.getMessage());
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
