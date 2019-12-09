package de.rat;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Date;

public class Bill {

    private int billNumber;
    private Customer customer;
    private Date rentDate;
    private Station rentStation;
    private Date billDate; // Todo Anfangs oder Enddatum?
    private int discount;
    private double fullRentPrice;
    /* several rent processes for on bill possible*/
    private ArrayList<RentProcess> listOfRentProcesses = new ArrayList<RentProcess>();

    public Bill (Customer customer,Station rentStation){
        this.billNumber=1234;  //ToDo
        this.customer=customer;
        this.rentDate=null; //ToDO
        this.rentStation=rentStation;
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

    public void setFullRentPrice() {


        for (RentProcess foundedProcesses :listOfRentProcesses)
        {
            this.fullRentPrice += foundedProcesses.getRentedTool().getRentPrice();  //ToDo date adden
        }

        this.fullRentPrice= this.fullRentPrice*discount/100;
    }

    public Bill findOpenBillFromCustomer(Customer customer){
        for (Bill foundedBill : customer.getCompany().getOpenBills())
        {
            if (foundedBill.getCustomer().equals(customer))
            {
                return foundedBill;
            }
        }
        return null;
    }
}
