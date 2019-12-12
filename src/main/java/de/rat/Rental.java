package de.rat;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Rental {

    private ArrayList<Bill> openBills = new ArrayList<Bill>();
    private ArrayList<Bill> closedBills = new ArrayList<Bill>();

    public Rental() {
    }

    public void rentATool(Tool wantedTool, Station pickupStation, Customer customer, Warehouse warehouse) {

        // TODO: prüfe ob Werkzeug vorhanden
        // TODO: prüfe ob platz in Station - Methode der Station aufrufen
        Tool searchedTool = warehouse.removeToolFromWarehouse(wantedTool);
        Bill bill = this.findOrCreateOpenBillFromCustomer(pickupStation, customer);
        RentProcess rentProcess = new RentProcess(searchedTool);
        bill.getListOfRentProcesses().add(rentProcess);     // TODO: wenn in Bill die neue Methode existiert, dann diese Verwenden
        pickupStation.addToolToBox(searchedTool);

        /*
        Tool searchedTool = pickupStation.removeToolFromBox(wantedTool);
        if(searchedTool != null){
            customer.getRentedTools().add(searchedTool);

            RentProcess rentProcess = new RentProcess(wantedTool);
            Bill bill =  this.findOrCreateOpenBillFromCustomer(pickupStation, customer);

            bill.getListOfRentProcesses().add(rentProcess);
            return true;
        }

        return false;
         */
    }

    public void returnProcess(Station station, Customer customer, Tool tool, GregorianCalendar date, Warehouse warehouse){

        // TODO: Werkzeig aus Station nehmen
        // TODO: Werkzeug in Lager bringen
        // TODO: RentProcess abschließen
        // TODO: BIll abschließen, wenn nötig


        /*
        Bill bill = findOrCreateOpenBillFromCustomer(station, customer);
        RentProcess rentprocess = bill.findRentProcess(tool);
        rentprocess.completeRentProcess(tool,station, date, customer);

        Tool removedTool = station.removeToolFromBox(tool);
        warehouse.putToolInWarehouse(tool);
        */

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
