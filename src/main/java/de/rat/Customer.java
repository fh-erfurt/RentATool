package de.rat;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Customer extends Person{

    private String phoneNumber;
    private Company company;
    private ArrayList<Tool> rentedTools= new ArrayList<Tool>();

    Customer(String lastname, String firstname, GregorianCalendar birthday,
             String email, String street, int hauseNr, int zip, String city, String country, String phoneNumber,Company company)
    {
        super(lastname, firstname, birthday, street, hauseNr,  zip,  city,  country);
        this.account = new Account(Role.CUSTOMER, email, createPassword(lastname, firstname, birthday));
        this.phoneNumber = phoneNumber;
        this.company = company;
        customerList.add(this); // add the customer to the list in the main class
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Company getCompany() {
        return company;
    }

    public ArrayList<Tool> getRentedTools() {
        return rentedTools;
    }

    public void getToolFromStation(){
        // TODO: Tool aus Station entnehmen
        // TODO: Tool in Inventar legen
    }

    public void returnToolToStation(){
        // TODO: Tool aus Inventar entnehmen
        // TODO: Tool in Station legen
    }



    /*
    public boolean reserveTool(Tool wantedTool, Date pickupDate, Station pickupStation){

        // TODO: extra Tool Status prüfen
        Tool findTool = company.findToolInStockOfCompany(wantedTool);

        if(findTool != null){
            company.getStock().remove(findTool);
            pickupStation.addToolToBox(findTool);
            return true;
        }

        return false;
    }

    public boolean rentATool(Tool wantedTool,Station pickupStation) {

        Tool searchedTool = pickupStation.removeToolFromBox(wantedTool);
        if(searchedTool != null){
            this.rentedTools.add(searchedTool);

        RentProcess rentProcess = new RentProcess(wantedTool);
        Bill bill =  this.findOrCreateOpenBillFromCustomer(pickupStation);

        bill.getListOfRentProcesses().add(rentProcess);
        return true;
        }

        return false;
    }

    public Bill findOrCreateOpenBillFromCustomer(Station pickupStation){
        for (Bill foundedBill : this.getCompany().getOpenBills()) {
            if (foundedBill.getCustomer().equals(this)) {
                return foundedBill;
            }
        }
        Bill newBill = new Bill(this, pickupStation);
        this.getCompany().getOpenBills().add(newBill);
        return newBill;
    }




    public boolean returnToolToStation(Tool tool, Station returnStation, GregorianCalendar Date){
        returnStation.addToolToBox(tool);
        for (Bill foundedBill : this.company.getOpenBills()) {
            if (foundedBill.getCustomer().equals(this)) {
                for (RentProcess foundedProcesses :foundedBill.getListOfRentProcesses()) {
                    if (foundedProcesses.getRentedTool().equals(tool)) {
                        foundedProcesses.setReturnDate(null);    //TODO: Null in Date
                        foundedProcesses.setReturnStation(returnStation);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // prüfe alle Werkzeuge in der Station, ob ein Flag gesetzt ist, welcher sagt, dass das Werkzeug zurückgegeben wurde
    //packe alle diese Werzeuge zurück in die Company

     */
}

