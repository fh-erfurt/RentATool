package de.rat.model.logistics;

import de.rat.model.BaseModel;
import de.rat.model.common.Address;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**Represents an manufacturer.
 * @author Danny Steinbrecher, Marco Petzold, Christian König,Bilal Alnani
 */
@Entity
public class Manufacturer extends BaseModel {

    private String name;

    @ManyToOne
    private Address address;

    private String agent;
    private String phoneNumber;


    /** Creates an manufacturer with the specified name.
     * @param name The manufacturer  name.
     * @param address The manufacturer address.
     * @param agent    The manufacturer agent.
     * @param phoneNumber   The manufacturer phoneNumber.
     */
    public Manufacturer( String name, Address address, String agent, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.agent = agent;
        this.phoneNumber = phoneNumber;

    }

    /** Gets the manufacturer name.
     * @return A string representing the manufacturer name
     */
    public String getName() {
        return name;
    }


    /** Gets the manufacturer address.
     * @return A Class representing the address.
     */
    public Address getAddress() {
        return address;
    }


    /** Gets the manufacturer agent.
     * @return A string representing the manufacturer agent.
     */
    public String getAgent() {
        return agent;
    }


    /** Gets the manufacturer phoneNumber.
     * @return A string representing the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /** Sets the manufacturer name.
     * @param name  A String containing the  manufacturer
     *     name.
     */
    public void setName(String name) {
        this.name = name;
    }


    /** Sets the manufacturer address.
     * @param address  A Class containing the  manufacturer
     *    address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }


    /** Change the the manufacturer.
     * @param name The manufacturer  name.
     * @param address The manufacturer address.
     * @param agent    The manufacturer agent.
     * @param phoneNumber   The manufacturer phoneNumber
     */
    public void changeManufacture(String name, Address address, String agent, String phoneNumber) {
        this.name=name;
        this.address=address;
        this.agent=agent;
        this.phoneNumber=phoneNumber;
    }
}
