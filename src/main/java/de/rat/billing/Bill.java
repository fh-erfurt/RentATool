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
    private Date billDate; // Todo Anfangs oder Enddatum?
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
            // gregorian calender includes the date as long, so we calculate the days and rounded the result to int
            long longDays = foundedProcesses.getReturnDate().getTime().getTime()-this.getRentDate().getTime().getTime();
            int days = (int)Math.round((double)longDays/(24.*60.*60.*1000.));

            // multiply the rented days with the rentPrice for each tool
            this.fullRentPrice += (foundedProcesses.getRentedTool().getRentPrice())*days;
        }

        this.fullRentPrice= this.fullRentPrice*discount/100;
    }

    // TODO: Method aus der Company hier eingefügt - muss angepasst werden
    public boolean closeBill(Customer customer, int discount){  //TODO: Discount?

            if (this.getCustomer().equals(customer))
            {
                for (RentProcess foundedProcesses :this.getListOfRentProcesses())
                {
                    if (foundedProcesses.getReturnStation() == null)  //ToDo über Date anpassen
                    {
                        return false;
                    }
                }
                this.setDiscount(discount);
                this.setFullRentPrice();
                //openBills.remove(bill);
                //closedBills.add(bill);
                return true;
            }


        return true;
    }

    public boolean addRentProcess(RentProcess rentProcess)
    {
       this.getListOfRentProcesses().add(rentProcess);
       return true;
    }
    // TODO: Methode find RentProcess
    public RentProcess findRentProcess(Tool searchedTool){
        return null;
    }

}
