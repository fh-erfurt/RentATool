package de.rat;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Rental {

    private ArrayList<Bill> openBills = new ArrayList<Bill>();
    private ArrayList<Bill> closedBills = new ArrayList<Bill>();

    public Rental() {
    }

    public boolean rentATool(Tool wantedTool, Station pickupStation, Customer customer, Warehouse warehouse) {

        // TODO: prüfe ob platz in Station - Methode der Station aufrufen
        if(pickupStation.isVoll()){
            return false;
        }

        // TODO: prüfe ob Werkzeug vorhanden
        Tool searchedTool = warehouse.removeToolFromWarehouse(wantedTool);
        if(searchedTool == null){
            return false;
        }

        Bill bill = this.findOrCreateOpenBillFromCustomer(pickupStation, customer);
        RentProcess rentProcess = new RentProcess(searchedTool);

        bill.getListOfRentProcesses().add(rentProcess);     // TODO: wenn in Bill die neue Methode existiert, dann diese Verwenden
        pickupStation.addToolToBox(searchedTool);
        return true;
    }

    public void returnProcess(Tool wantedTool, Station removeStation, Customer customer, Warehouse warehouse){

        // TODO: prüfungen einfügen
        Tool searchedTool = removeStation.removeToolFromBox(wantedTool);
        warehouse.putToolInWarehouse(searchedTool);
        Bill bill = findOrCreateOpenBillFromCustomer(removeStation, customer);    // TODO: es muss eine Bill da sein, wie prüft man das?
        RentProcess rentprocess = bill.findRentProcess(searchedTool);
        rentprocess.completeRentProcess(searchedTool,removeStation, date, customer);
        bill.closeBill(); //TODO: soll das automatisch passieren, oder manuel?
    }


    public Bill findOrCreateOpenBillFromCustomer(Station pickupStation, Customer customer){
        for (Bill foundedBill : customer.getCompany().getOpenBills()) {
            if (foundedBill.getCustomer().equals(customer)) {
                return foundedBill;
            }
        }
        Bill newBill = new Bill(customer, pickupStation);
        customer.getCompany().getOpenBills().add(newBill);
        return newBill;
    }
}
