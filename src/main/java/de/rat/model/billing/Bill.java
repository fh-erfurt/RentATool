package de.rat.model.billing;

import de.rat.model.customer.*;
import de.rat.model.logistics.*;
import de.rat.model.common.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**Represents a class bill.
 * Hold a list of every rentprocess from a customer
 * for a specific date.
 * @author Marco Petzold, Christian König, Danny Steinbrecher
 */

/** Creates a bill .
 *  billnumber is a static unique number<br>
 *  customer for whom the bill is<br>
 *  rentDate the date from the begin of the rentprocess<br>
 *  rentStation the station where the customer want to pickup the tool<br>
 *  discount the discount which the employee can set<br>
 *  fullRentPrice the full rentprice after the return from the tool<br>
 *  listOfRentProcesses a list of all rentprocess<br>
 *
 */
@Entity
public class Bill {

    @Transient
    private static final Logger logger = Logger.getLogger("LOGGER");

    @Transient
    private static int autoincrementNumber = 10000;

    @Id
    private int billNumber;

    @ManyToOne
    private Customer customer;


    private LocalDate rentDate;

    @ManyToOne
    private Station rentStation;

    private int discount;

    private BigDecimal fullRentPrice;
    private BillStatus billStatus;

    /* several rent processes for on bill possible*/
    @OneToMany
    @JoinTable(name="billRentprocesses",inverseJoinColumns=@JoinColumn(name="rentProcess_id"))
    private List<RentProcess> listOfRentProcesses = new ArrayList<RentProcess>();

    protected Bill(){}

    /**
     * constructor for the class bill<br>
     *  billnumber is a static unique number<br>
     *  customer for whom the bill is<br>
     *  rentDate the date from the begin of the rentprocess<br>
     *  rentStation the station where the customer want to pickup the tool<br>
     *  billDate the date where the bill was created<br>
     *  discount the discount which the employee can set<br>
     *   fullRentPrice the full rentprice after the return from the tool<br>
     *  listOfRentProcesses a list of all rentprocess<br>
     */
    public Bill (Customer customer,Station rentStation){
        this.customer = customer;
        this.rentDate = LocalDate.now();
        this.rentStation = rentStation;
        this.discount = 0;
        this.fullRentPrice = new BigDecimal(0);
        ++autoincrementNumber;
        this.billNumber = autoincrementNumber;
        this.billStatus = BillStatus.OPEN;
    }


    /**
     * deliver the billnumber
     * @return   number form the bill
     */
    public int getBillNumber() {
        return billNumber;
    }


    /**
     * deliver the customer from the bill
     * @return   customer from the bill
     */
    public Customer getCustomer() {
        return customer;
    }


    /**
     * deliver the rent date
     * @return   rent date
     */
    public LocalDate getRentDate() {
        return rentDate;
    }


    /**
     * deliver the full rent price
     * @return   full rent price
     */
    public BigDecimal getFullRentPrice() {
        return fullRentPrice;
    }


    /**
     * deliver the discount
     * @return   discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * deliver the bill status
     * @return   billStatus
     */
    public BillStatus getBillStatus() {
        return billStatus;
    }


    /**
     * Arraylist of rentprocesses
     * @return   list of rentprocesses
     */
    public List<RentProcess> getListOfRentProcesses() {
        return listOfRentProcesses;
    }
    

    /**
     * set the customer
     * @param  customer the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    /**
     * set the rent date
     * @param  rentDate the new rent date
     */
    public void setRentDate(LocalDate rentDate) { this.rentDate = rentDate; }


    /**
     * set the discount
     * @param  discount the new customer
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }


    /**
     * set the full rent price
     */
    public void setFullRentPrice() {

        for (RentProcess foundedProcesses :listOfRentProcesses)
        {
            // get the dates of the return and rented Date and calculate the difference.
            int days = Date.calculateDifferenceBetweenDates(foundedProcesses.getReturnDate(),this.getRentDate());

            // multiply the rented days with the rentPrice for each tool
            this.fullRentPrice = this.fullRentPrice.add((foundedProcesses.getRentedTool().getRentPrice()).multiply(new BigDecimal(days)));
        }

        this.fullRentPrice = this.fullRentPrice.subtract(this.fullRentPrice.multiply(new BigDecimal(discount)).divide(new BigDecimal(100),3, RoundingMode.CEILING));
    }

    /**
     * set the bill status
     */
    public void setBillStatus(BillStatus billStatus) { this.billStatus = billStatus; }

    /**
     * check the bill for a given customer
     * @return   true if the bill was found<br>
     * @return   false if the bill was not found
     */
    public boolean checkIfAllRentProcessesFromABillAreClosed(){
        for (RentProcess foundedProcesses : this.getListOfRentProcesses())
        {
            if (foundedProcesses.getReturnStation() == null || (foundedProcesses.getReturnDate()==null))
            {
                logger.info("Die Rechnung vom Kunden: " + this.getCustomer().getFirstname() + " " + this.getCustomer().getLastname() + " RnNr: " + this.getBillNumber() + " ist noch offen!");
                return false;
            }
        }
        logger.info("Die Rechnung vom Kunden: " + this.getCustomer().getFirstname() + " " + this.getCustomer().getLastname() + " RnNr: " + this.getBillNumber() + " kann geprüft werden!");
        return true;
    }


    /**
     * add a tool to the rent process
     * rentProcess the actual rent process
     */
    public void addRentProcess(Tool wantedTool)
    {
        RentProcess rentProcess = new RentProcess(wantedTool);
        this.getListOfRentProcesses().add(rentProcess);

    }


    /**
     * find a tool in the rent process
     * @return  foundedRentProcess the rent process for the searched tool
     * @return null if there are no rent process
     */
    public RentProcess findRentProcess(Tool searchedTool){


        for (RentProcess foundedRentProcess : this.listOfRentProcesses)
        {

            if(foundedRentProcess.getRentedTool().getId()== (searchedTool.getId()))
            {

                return foundedRentProcess;
            }
        }
        return null;
    }
}
