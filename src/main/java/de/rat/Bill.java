package de.rat;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Date;

public class Bill {

    private int billNumber;
    private Customer customer;
    private Date rentDate;
    private Station rentStation;
    private Date billDate;
    private int discount;
    private float fullRentPrice;
    /* several rent processes for on bill possible*/
    private ArrayList<RentProcess> listOfRentProcesses = new ArrayList<RentProcess>();

    public Bill (int billNumber,Customer customer,Date date,Station rentStation,RentProcess rentProcess){
        this.billNumber=billNumber;
        this.customer=customer;
        this.rentDate=date;
        this.rentStation=rentStation;
        listOfRentProcesses.add(rentProcess);
        this.billDate=null;
        this.discount=0;
        this.fullRentPrice=0;
    }

    /*Getter*/
    public int getBillNumber() {
        return billNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Station getRentStation() {
        return rentStation;
    }

    public Date getBillDate() {
        return billDate;
    }

    public float getFullRentPrice() {
        return fullRentPrice;
    }

    public int getDiscount() {
        return discount;
    }


    /*Setter*/
    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRentDate(Date rentDate) {
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
}
