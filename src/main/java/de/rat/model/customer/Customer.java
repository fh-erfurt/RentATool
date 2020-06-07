package de.rat.model.customer;

import de.rat.model.common.*;
import de.rat.model.logistics.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.persistence.Entity;
/**Represents an customer.
 * @author Danny Steinbrecher, Marco Petzold, Christian König,Bilal Alnani
 */

@Entity
public class Customer extends Person {
public Customer(){

}
    private static final Logger logger = Logger.getLogger("LOGGER");
    private String phoneNumber;
@Transient
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
        this.account = new Account(Role.CUSTOMER, email, createPassword());
        this.phoneNumber = phoneNumber;
    }


    /** gets the tool fom the Inventory of the customer .
     *  @param tool the tool that should be returned
     */
    public Tool getToolFromInventory(Tool tool){
        for (Tool foundedTool : this.inventory) {
            if (foundedTool.equals(tool)) {
                this.inventory.remove(foundedTool);
                logger.info("Das Werkzeug wurde beim Kunden gefunden!");
                return foundedTool;
            }
        }
        logger.severe("Das Werkzeug wurde nicht beim Kunden gefunden!");
        return null;
    }


    /** put the tool in the Inventory from the customer .
     *  @param tool the tool that was rented
     */
    public boolean putToolInInventory(Tool tool){
        if(tool != null) {
            this.inventory.add(tool);
            logger.info("Das Werkzeug wurde an den Kunden übergeben!");
            return true;
        }
        logger.severe("Das Werkzeug konnte nicht an den Kunden übergeben werden!");
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
     *  @param removeStation the station which the tool will be insert for remove
     */
    public boolean returnToolToStation(Tool wantedTool, Station removeStation){
        return removeStation.addToolToBox(wantedTool);
    }
}

