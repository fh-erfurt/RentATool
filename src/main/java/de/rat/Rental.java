package de.rat;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Rental {

    private ArrayList<Bill> openBills = new ArrayList<Bill>();
    private ArrayList<Bill> closedBills = new ArrayList<Bill>();

    public Rental() {
    }

    public boolean rentATool(Tool wantedTool, Station pickupStation, Customer customer, Warehouse warehouse) {

        // check if the station is full
        if(!pickupStation.checkStationLevel()){
            return false;
        }

        // check if the searched Tool is in the warehouse
        if(warehouse.removeToolFromWarehouse(wantedTool) == null){
            return false;
        }

        Bill bill = this.findOpenBillFromCustomer(customer);
        if(bill == null){
            bill = this.CreateOpenBillFromCustomer(pickupStation, customer);
        }

        RentProcess rentProcess = new RentProcess(wantedTool);

        bill.getListOfRentProcesses().add(rentProcess);     // TODO: wenn in Bill die neue Methode existiert, dann diese Verwenden
        pickupStation.addToolToBox(wantedTool);
        return true;
    }

    public boolean returnTool(Tool wantedTool, Station removeStation, Customer customer, Warehouse warehouse, GregorianCalendar date){
        if(removeStation.removeToolFromBox(wantedTool) == null){
            return false;
        }
        warehouse.putToolInWarehouse(wantedTool);

        Bill bill = findOpenBillFromCustomer(customer);
        if(bill == null){
            return false;
        }

        RentProcess rentprocess = bill.findRentProcess(wantedTool);
        if(rentprocess == null){
            return false;
        }

        rentprocess.completeRentProcess(removeStation, date);
        bill.closeBill(customer, 2);    //TODO: Discount?

        return true;
    }


    public Bill findOpenBillFromCustomer(Customer customer){
        for (Bill foundedBill : this.openBills) {
            if (foundedBill.getCustomer().equals(customer)) {
                return foundedBill;
            }
        }
        return null;
    }


    public Bill CreateOpenBillFromCustomer(Station pickupStation, Customer customer){
        Bill newBill = new Bill(customer, pickupStation);
        this.openBills.add(newBill);
        return newBill;
    }


}
