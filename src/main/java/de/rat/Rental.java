package de.rat;

import java.util.ArrayList;

public class Rental {

    private ArrayList<Bill> openBills = new ArrayList<Bill>();
    private ArrayList<Bill> closedBills = new ArrayList<Bill>();

    public Rental() {
    }

    public boolean rentATool(Tool wantedTool, Station pickupStation, Customer customer) {

        Tool searchedTool = pickupStation.removeToolFromBox(wantedTool);
        if(searchedTool != null){
            customer.getRentedTools().add(searchedTool);

            RentProcess rentProcess = new RentProcess(wantedTool);
            Bill bill =  this.findOrCreateOpenBillFromCustomer(pickupStation, customer);

            bill.getListOfRentProcesses().add(rentProcess);
            return true;
        }

        return false;
    }

    public Bill findOrCreateOpenBillFromCustomer(Station pickupStation, Customer customer){
        for (Bill foundedBill : customer.getCompany().getOpenBills()) {
            if (foundedBill.getCustomer().equals(this)) {
                return foundedBill;
            }
        }
        Bill newBill = new Bill(customer, pickupStation);
        customer.getCompany().getOpenBills().add(newBill);
        return newBill;
    }



}
