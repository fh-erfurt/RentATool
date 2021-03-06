package de.rat.model.common;

import de.rat.model.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**Represents a Person.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */


@MappedSuperclass
public abstract class Person extends BaseModel {

    @NotNull(message = "Name cannot be null.")
    @Size(min = 2, max = 35, message = "Lastname must be 2-35 characters long.")
    private String lastname;
    @NotNull
    @Size(min = 2, max = 35, message = "Firstname must be 2-35 characters long.")
    private String firstname;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    @ManyToOne
    private Address address;

    @OneToOne
    public Account account;

    public Person(){}

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
    public Person(String lastname, String firstname, LocalDate birthday,
                  String street, String houseNr, String zip, String city, String country) {

        this.lastname   = lastname;
        this.firstname  = firstname;
        this.birthday   = birthday;
        this.address    = new Address(street, houseNr, zip, city, country);
    }

    public Person(String lastname, String firstname) {

        this.lastname   = lastname;
        this.firstname  = firstname;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");

        return shortFirstname  + formatter.format(birthday) + shortLastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                this.getId(), firstname, lastname);
    }
}
