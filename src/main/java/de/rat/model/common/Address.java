package de.rat.model.common;

import de.rat.model.BaseModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**Represents a class address.
 * @author Marco Petzold, Christian König, Danny Steinbrecher, Bilal Alnani
 */
public class Address extends BaseModel {

    private String street;
    private int hauseNr;
    private int zip;
    private String city;
    private String country;

    public Address(String street, int hauseNr, int zip, String city, String country) {
        this.street = street;
        this.hauseNr = hauseNr;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public int getHauseNr() {
        return hauseNr;
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

    public void setHauseNr(int hauseNr) {
        this.hauseNr = hauseNr;
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
        return this.street.equals(street) && this.hauseNr == hauseNr && this.zip == zip && this.city.equals(city) && this.country.equals(country);
    }


    public boolean changeAddress(String street, int hauseNr, int zip, String city, String country){
        if(this.checkAddress(street, hauseNr, zip, city, country)){
            return false;
        } else{
            this.setZip(zip);
            this.setStreet(street);
            this.setHauseNr(hauseNr);
            this.setCountry(country);
            this.setCity(city);
            return true;
        }
    }
}
