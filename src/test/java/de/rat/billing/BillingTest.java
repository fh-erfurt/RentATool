package de.rat.billing;

import de.rat.Rental;
import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.customer.RentProcess;
import de.rat.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.rat.Rental;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class BillingTest {

    //Variable declaration
    private Customer custMaria;
    private Address musterhausen;
    private Station stationOne;
    private Bill billMaria;
    private RentProcess rentProcessMariaHammer;
    private Tool hammer;
    private Tool drill;
    private Manufacturer bosch;
    private Address address;
    private Warehouse warehouse;


    @BeforeEach
    void setUp() {
        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        stationOne = new Station("S1", 3, musterhausen);
        custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
        hammer = new Tool("123",bosch,"Hammer", Category.HANDTOOL,"Lager",ToolStatus.AVAILABLE,3.5);
        drill = new Tool("123",bosch,"Hammer", Category.ELECTRICALTOOL,"Lager",ToolStatus.AVAILABLE,5.5);
        address = new Address("Bosch-Strasse", 1, 99425, "Weimar", "DE");
        bosch =  new Manufacturer("Bosch",address,"Mr. Smith","01234");
        warehouse= new Warehouse();

    }


    @Test
    void was_a_bill_in_open_bill_after_customer_rent_a_tool() {
        //create one Bill with the current date - equal to rentDate
        warehouse.putToolInWarehouse(hammer);
        Rental.rentATool(hammer,stationOne,custMaria,warehouse);
        Bill searchedBill = Billing.findOpenBillFromCustomer(custMaria);
        assertEquals(10001,searchedBill.getBillNumber());

        // change date, so rentDate is in the past
        GregorianCalendar newDate= new GregorianCalendar(2020, Calendar.JANUARY,24);
        Billing.getOpenBills().get(0).setRentDate(newDate);
        Bill searchedBill1 = Billing.findOpenBillFromCustomer(custMaria);
        assertEquals(null,searchedBill1);
    }
    @Test
    void is_there_just_one_bill_after_rent_two_tools() {
        //create one Bill with the current date - equal to rentDate
        warehouse.putToolInWarehouse(hammer);
        Rental.rentATool(hammer,stationOne,custMaria,warehouse);
        Bill searchedBill = Billing.findOpenBillFromCustomerForReturn(custMaria,drill,stationOne);
        assertEquals(10001,searchedBill.getBillNumber());
    }

    @Test
    void has_the_bill_a_return_station_after_return_tool() {
        // set return station and date in the method
        warehouse.putToolInWarehouse(hammer);
        Rental.rentATool(hammer,stationOne,custMaria,warehouse);
        Bill testBill = Billing.findOpenBillFromCustomerForReturn(custMaria,hammer,stationOne);
        assertEquals(stationOne,testBill.getListOfRentProcesses().get(0).getReturnStation());

    }

    @Test
    void move_the_bill_after_all_rent_processes_are_closed() {
        warehouse.putToolInWarehouse(hammer);
        Rental.rentATool(hammer,stationOne,custMaria,warehouse);
        //1 bill in openBills, 0 in checkedBills
        int sizeOpenBills = Billing.getOpenBills().size();
        int sizeCheckedBills = Billing.getCheckBills().size();

        Billing.checkBillsFromCustomerAndMoveThemToTheCkeckedListIfAllRentProcessesAreClosed(custMaria);
        //0 bill in openBills, 1 in checkedBills
        assertEquals(0,sizeOpenBills-1);
        assertEquals(1,sizeCheckedBills+1);


    }

    @Test
    void move_the_bill_from_checked_to_closed() {

        Bill bill = new Bill(custMaria,stationOne);
        Billing.getCheckBills().add(bill);
        //1 bill iun checkedBills, 0 in closedBills
        int sizeCheckedBills = Billing.getCheckBills().size();
        int sizeClosedBills = Billing.getClosedBills().size();

        Billing.moveFromCheckToClosed(bill);

        //0 bill iun checkedBills, 1 in closedBills
        assertEquals(0,sizeCheckedBills-1);
        assertEquals(1,sizeClosedBills+1);
    }


    @Test
    void is_no_bill_available_create_a_new_one_otherwise_use_the_available() {
        //create new bill
        warehouse.putToolInWarehouse(hammer);
        Rental.rentATool(hammer,stationOne,custMaria,warehouse);
        Bill searchedBill = Billing.findOpenBillFromCustomer(custMaria);
        assertEquals(10001,searchedBill.getBillNumber());

        //find bill and use them
        warehouse.putToolInWarehouse(drill);
        Rental.rentATool(drill,stationOne,custMaria,warehouse);
        assertEquals(10001,searchedBill.getBillNumber());
    }
}