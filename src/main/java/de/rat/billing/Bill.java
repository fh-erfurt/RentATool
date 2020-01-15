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


    public Bill (Customer customer,Station rentStation){
        this.customer=customer;
        this.rentDate= new GregorianCalendar();
        this.rentStation=rentStation;
        this.billDate=null;
        this.discount=0;
        this.fullRentPrice=0;
        autoincrementNumber++;
        this.billNumber = autoincrementNumber;
    }

    /*Getter*/
    public int getBillNumber() {
        return billNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public GregorianCalendar getRentDate() {
        return rentDate;
    }

    public Station getRentStation() {
        return rentStation;
    }

    public Date getBillDate() {
        return billDate;
    }

    public double getFullRentPrice() {
        return fullRentPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public ArrayList<RentProcess> getListOfRentProcesses() {
        return listOfRentProcesses;
    }

    /*Setter*/
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRentDate(GregorianCalendar rentDate) {

       this.rentDate = rentDate;
    }

    public void setRentStation(Station rentStation) {
        this.rentStation = rentStation;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    /*methods*/

    public void setFullRentPrice() {

        for (RentProcess foundedProcesses :listOfRentProcesses)
        {
            // get the dates of the return and rented Date and calculate the difference.
            int days = calculateDifferenceBetweenDates(foundedProcesses.getReturnDate(),this.getRentDate());

            // multiply the rented days with the rentPrice for each tool
            this.fullRentPrice += (foundedProcesses.getRentedTool().getRentPrice())*days;
        }

        this.fullRentPrice= this.fullRentPrice*discount/100;
    }


    public boolean checkBill(Customer customer)
    {

            if (this.getCustomer().equals(customer))
            {
                for (RentProcess foundedProcesses :this.getListOfRentProcesses())
                {
                    if (foundedProcesses.getReturnStation() == null || (foundedProcesses.getReturnDate()==null))
                    {
                        return false;
                    }
                }
                this.setFullRentPrice();
                return true;
            }


        return true;
    }

    public boolean addRentProcess(RentProcess rentProcess)
    {
       this.getListOfRentProcesses().add(rentProcess);
       return true;
    }

    public RentProcess findRentProcess(Tool searchedTool){

        for (RentProcess foundedRentProcess : this.listOfRentProcesses)
        {
            if(foundedRentProcess.getRentedTool().equals(searchedTool))
            {
                return foundedRentProcess;
            }
        }
        return null;
    }

    public int calculateDifferenceBetweenDates(GregorianCalendar lowerDate, GregorianCalendar higherDate)
    {
        // gregorian calender includes the date as long, so we calculate the days between and rounded the result to int
        long LongDateDifference = higherDate.getTime().getTime()-lowerDate.getTime().getTime();
        int dateDifference = (int)Math.round((double)LongDateDifference/(24.*60.*60.*1000.)); //Gregorian Calender hold the time as milliseconds
        return dateDifference;
    }
}
