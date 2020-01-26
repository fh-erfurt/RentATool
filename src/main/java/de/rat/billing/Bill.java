package de.rat.billing;

import de.rat.customer.Customer;
import de.rat.customer.RentProcess;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**Represents a class bill.
 * Hold a list of every rentprocess from a customer
 * for a specific date.
 * @author Marco Petzold
 */



/** Creates a bill .
 *  @param billnumber is a static unique number
 *  @param customer for whom the bill is
 *  @param rentDate the date from the begin of the rentprocess
 *  @param rentStation the station where the customer want to pickup the tool
 *  @param billDate the date where the bill was created
 *  @param discount the discount which the employee can set
 *  @param fullRentPrice the full rentprice after the return from the tool
 *  @param listOfRentProcesses a list of all rentprocess
 *
 */
public class Bill {

    private static int autoincrementNumber = 10000;
    private int billNumber;
    private Customer customer;
    private GregorianCalendar rentDate;
    private Station rentStation;
    private Date billDate;
    private int discount;
    private double fullRentPrice;
    /* several rent processes for on bill possible*/
    private ArrayList<RentProcess> listOfRentProcesses = new ArrayList<RentProcess>();


    /**
     * constructor for the class bill
     *  @param billnumber is a static unique number
     *  @param customer for whom the bill is
     *  @param rentDate the date from the begin of the rentprocess
     *  @param rentStation the station where the customer want to pickup the tool
     *  @param billDate the date where the bill was created
     *  @param discount the discount which the employee can set
     *  @param fullRentPrice the full rentprice after the return from the tool
     *  @param listOfRentProcesses a list of all rentprocess
     */
    public Bill (Customer customer,Station rentStation){
        this.customer=customer;
        this.rentDate= new GregorianCalendar();
        this.rentStation=rentStation;
        this.billDate=null;
        this.discount= 0;
        this.fullRentPrice= 0;
        ++autoincrementNumber;
        this.billNumber = autoincrementNumber;
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

    public GregorianCalendar getRentDate() {
        return rentDate;
    }

    /**
     * deliver the rent station
     * @return   rent station
     */
    public Station getRentStation() {
        return rentStation;
    }


    /**
     * deliver the bill date
     * @return   bill date
     */
    public Date getBillDate() {
        return billDate;
    }


    /**
     * deliver the full rent price
     * @return   full rent price
     */
    public double getFullRentPrice() {
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
     * Arraylist of rentprocesses
     * @return   list of rentprocesses
     */
    public ArrayList<RentProcess> getListOfRentProcesses() {
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
    public void setRentDate(GregorianCalendar rentDate) {

       this.rentDate = rentDate;
    }


    /**
     * set the customer
     * @param  rentStation the new customer
     */
    public void setRentStation(Station rentStation) {
        this.rentStation = rentStation;
    }


    /**
     * set the discount
     * @param  discount the new customer
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }


    /**
     * set the bill date
     * @param  billDate the new customer
     */
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }



    /**
     * set the full rent price
     * @param  fullRentPrice the full rent price
     */

    public void setFullRentPrice() {

        for (RentProcess foundedProcesses :listOfRentProcesses)
        {
            // get the dates of the return and rented Date and calculate the difference.
            int days = calculateDifferenceBetweenDates(foundedProcesses.getReturnDate(),this.getRentDate());
            System.out.println("Days: " + days);
            // multiply the rented days with the rentPrice for each tool
            this.fullRentPrice += (foundedProcesses.getRentedTool().getRentPrice())*days;
        }

        this.fullRentPrice-= this.fullRentPrice*discount/100;
    }

    /**
     * check the bill for a given customer
     * @return   true if the bill was found
     * @return   false if the bill was not found
     */

    public boolean checkIfAllRentProcessesFromABillAreClosed(){
        for (RentProcess foundedProcesses : this.getListOfRentProcesses())
        {
            if (foundedProcesses.getReturnStation() == null || (foundedProcesses.getReturnDate()==null))
            {
                System.out.println("Die Rechnung vom Kunden: " + this.getCustomer().getFirstname() + " " + this.getCustomer().getLastname() + " RnNr: " + this.getBillNumber() + " ist noch offen!");
                return false;
            }
        }
        System.out.println("Die Rechnung vom Kunden: " + this.getCustomer().getFirstname() + " " + this.getCustomer().getLastname() + " RnNr: " + this.getBillNumber() + " kann geprüft werden!");
        return true;
    }


    /**
     * add a tool to the rent process
     * @param  rentProcess the actual rent process
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
            if(foundedRentProcess.getRentedTool().equals(searchedTool))
            {
                //TODO: Konsolenausgabe
                return foundedRentProcess;
            }
        }
        //TODO: Konsolenausgabe ??? hier ggf weglassen?
        return null;
    }


    /**
     * calculate the differnce between the date from the rent day and the date of return
     * @return  the calculated days
     *
     */
    public int calculateDifferenceBetweenDates(GregorianCalendar higherDate, GregorianCalendar lowerDate)
    {
        // gregorian calender includes the date as long, so we calculate the days between and rounded the result to int
        long LongDateDifference = higherDate.getTime().getTime()-lowerDate.getTime().getTime();
        return (int)Math.ceil((double)LongDateDifference/(24.*60.*60.*1000.)) + 1; //Gregorian Calender hold the time as milliseconds

    }
}
