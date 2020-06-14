package de.rat.model.common;

import de.rat.model.BaseModel;
import javax.persistence.*;

/**Represents a class address.
 * @author Marco Petzold, Christian König, Danny Steinbrecher, Bilal Alnani
 */

@Entity
public class Address extends BaseModel {

    private String street;
    private int houseNr;
    private int zip;
    private String city;
    private String country;

    protected Address(){ }

    public Address(String street, int houseNr, int zip, String city, String country) {
        this.street = street;
        this.houseNr = houseNr;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNr(int hauseNr) {
        this.houseNr = hauseNr;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean checkAddress(String street, int hauseNr, int zip, String city, String country) {
        return this.street.equals(street) && this.houseNr == hauseNr && this.zip == zip && this.city.equals(city) && this.country.equals(country);
    }


    public boolean changeAddress(String street, int hauseNr, int zip, String city, String country){
        if(this.checkAddress(street, hauseNr, zip, city, country)){
            return false;
        } else{
            this.setZip(zip);
            this.setStreet(street);
            this.setHouseNr(hauseNr);
            this.setCountry(country);
            this.setCity(city);
            return true;
        }
    }
}
