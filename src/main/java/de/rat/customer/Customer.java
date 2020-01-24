package de.rat.customer;


import de.rat.Rental;
import de.rat.common.Person;
import de.rat.common.Role;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;
import de.rat.common.Account;
import de.rat.employee.Company;

import java.util.ArrayList;
import java.util.GregorianCalendar;
/**Represents an customer.
 * @author Danny Steinbrecher
 */

public class Customer extends Person {

    private String phoneNumber;
    private ArrayList<Tool>  inventory = new ArrayList<Tool>();

    /** Creates an customer .
     *  @param lastname the lastname from the customer
     *  @param firstname the firstname from the customer
     *  @param birthday the birthday from the customer
     *  @param email the email from the customer
     *  @param street the street from the customer
     *  @param houseNr the houseNr from the customer
     *  @param zip the zip from the customer
     *  @param city the city from the customer
     *  @param country the country from the customer
     *  @param phoneNumber the phoneNumber from the customer
     */
    public Customer(String lastname, String firstname, GregorianCalendar birthday,
             String email, String street, int houseNr, int zip, String city, String country, String phoneNumber)
    {
        super(lastname, firstname, birthday, street, houseNr,  zip,  city,  country);
        this.account = new Account(Role.CUSTOMER, email, createPassword(lastname, firstname, birthday));
        this.phoneNumber = phoneNumber;
    }

    /** gets the tool fom the Inventory of the customer .
     *  @param tool the tool that should be returned
     */
    public Tool getToolFromInventory(Tool tool){
        for (Tool foundedTool : this.inventory) {
            if (foundedTool.equals(tool)) {
                this.inventory.remove(foundedTool);
                return foundedTool;
            }
        }
        return null;
    }

    /** put the tool in the Inventory from the customer .
     *  @param tool the tool that was rented
     */
    public boolean putToolInInventory(Tool tool){
        if(tool != null) {
            this.inventory.add(tool);
            return true;
        }
        return false;
    }

    /** gets the tool from the station.
     *  @param wantedTool the tool that would be rented
     *  @param removeStation the station which the tool was picked up
     */
    public boolean getToolFromStation(Tool wantedTool, Station removeStation){
        Tool searchedTool = removeStation.removeToolFromBox(wantedTool);
        return putToolInInventory(searchedTool);
    }

    /** return the tool to the station.
     *  @param wantedTool the tool that where rented
     *  @param removeStation the station which the tool will be removed
     */
    public boolean returnToolToStation(Tool wantedTool, Station removeStation){
        if(getToolFromInventory(wantedTool) != null) {
            return removeStation.addToolToBox(wantedTool);
            // Rental retnal = new Rental();
            // retnal.returnTool(wantedTool)
            // TODO: ggf an den Return Tool geben!
        }
        return false;
    }
}

