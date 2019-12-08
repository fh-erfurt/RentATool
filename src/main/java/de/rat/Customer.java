package de.rat;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Customer extends Person{

    private String phoneNumber;
    private Company company;
    private ArrayList<Tool> rentedTools= new ArrayList<Tool>();

    Customer(String lastname, String firstname, GregorianCalendar birthday,
             String email, String street, int hauseNr, int zip, String city, String country, String phoneNumber,Company companyName)
    {
        super(lastname, firstname, birthday, street, hauseNr,  zip,  city,  country);
        this.account = new Account(Role.CUSTOMER, email, createPassword(lastname, firstname, birthday));
        this.phoneNumber = phoneNumber;
        this.company=companyName;
        customerList.add(this); // add the customer to the list in the main class
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean reserveTool(Tool wantedTool, Date pickupDate, Station pickupStation){

        for (Tool foundedTool : company.getStock())
        {
            if (foundedTool.equals(wantedTool))
            {
                company.getStock().remove(wantedTool);
                pickupStation.addToolToBox(wantedTool);
                return true;
            }
        }
        return false;
    }


    public boolean rentATool(Tool wantedTool,Station pickupStation) {

        this.rentedTools.add(pickupStation.removeToolFromBox(wantedTool));
        RentProcess rentedTool = new RentProcess(wantedTool);

        for (Bill foundedBill : this.company.getOpenBills())
        {
            if (foundedBill.getCustomer().equals(this))
            {
                foundedBill.getListOfRentProcesses().add(rentedTool);
                return true;
            }
        }
        Bill userBill = new Bill(this, pickupStation);
        userBill.getListOfRentProcesses().add(rentedTool);
        this.company.getOpenBills().add(userBill);


        return true;
    }


    public boolean returnTool(Tool choosenTool,Station returnStation){

        returnStation.addToolToBox(choosenTool);
        for (Bill foundedBill : this.company.getOpenBills())
        {
            if (foundedBill.getCustomer().equals(this))
            {
                for (RentProcess foundedProcesses :foundedBill.getListOfRentProcesses())
                {
                    if (foundedProcesses.getRentedTool().equals(choosenTool))
                    {
                        foundedProcesses.setReturnDate(null); //ToDo;
                        foundedProcesses.setReturnStation(returnStation);

                        return true;
                    }
                }

            }
        }
        return false;
    }
}

