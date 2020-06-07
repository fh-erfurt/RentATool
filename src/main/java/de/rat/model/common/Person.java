package de.rat.model.common;

import de.rat.model.BaseModel;
import javax.persistence.*;
import java.util.GregorianCalendar;

/**Represents a Person.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */

@MappedSuperclass
public abstract class Person extends BaseModel {
public Person(){}
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "firstname")
    private String firstname;

    @Temporal (TemporalType.DATE)
    private GregorianCalendar birthday;

    @ManyToOne
    private Address address;

    @OneToOne
    protected Account account;

    /** constructor for a Person
     *  it´s an abstract class which can inherit zo employee and customer
     *  @param lastname the lastname from the Person
     *  @param firstname the firstname from the Person
     *  @param birthday the birthday from the Person
     *  The next attributes are for the Address
     *  @param street the street from the Address, where the Person lives
     *  @param houseNr the houseNr from the Address, where the Person lives
     *  @param zip the zip-code from the Address, where the Person lives
     *  @param city the city from the Address, where the Person lives
     *  @param country the country from the Address, where the Person lives
     */
    public Person(String lastname, String firstname, GregorianCalendar birthday,
                  String street, int houseNr, int zip, String city, String country) {

        this.lastname   = lastname;
        this.firstname  = firstname;
        this.birthday   = birthday;
        this.address    = new Address(street, houseNr, zip, city, country);
    }


    //Getter
    public Address getAddress()     { return address; }
    public Account getAccount()     { return account; }
    public String getFirstname()    { return firstname; }
    public String getLastname()     { return lastname; }


    //Methods
    /** creates the Password for an employee or a customer.
     *  @return password (String)
     *
     */
    public String createPassword() {
        //example: da241289st
        String shortFirstname   = this.firstname.substring(0,2).toLowerCase();
        String shortLastname    = this.lastname.substring(0,2).toLowerCase();
        int shortDay            = this.birthday.get(GregorianCalendar.DATE);
        int shortMonth          = this.birthday.get(GregorianCalendar.MONTH) + 1;
        String shortYear        = Integer.toString(this.birthday.get(GregorianCalendar.YEAR)).substring(2,4);

        return shortFirstname + (shortDay < 10 ? "0" : "") + shortDay   + (shortMonth < 10 ? "0" : "") + shortMonth + shortYear + shortLastname;
    }
}
