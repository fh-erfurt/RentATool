package de.rat.model.billing;

import de.rat.model.Rental;
import de.rat.model.common.Address;
import de.rat.model.customer.Customer;
import de.rat.model.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BillingTest {

    //Variable declaration
    private Customer custMaria;
    private Address musterhausen;
    private Station stationOne;
    private Tool hammer;
    private Tool drill;
    private Manufacturer bosch;
    private Address address;
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        musterhausen = new Address("Musterstrasse", "1", "99099", "Erfurt", "Deutschland");
        stationOne = new Station("S1", 3, musterhausen);
        custMaria = new Customer("Schmidt", "Maria", LocalDate.of(2005, 8, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", "53", "99986", "Dresden", "Germany", "561616310651");
        hammer = new Tool("123",bosch,"Hammer", Category.HANDTOOL,"Lager",ToolStatus.AVAILABLE,new BigDecimal("3.5"));
        drill = new Tool("123",bosch,"Hammer", Category.ELECTRICALTOOL,"Lager",ToolStatus.AVAILABLE,new BigDecimal("5.5"));
        address = new Address("Bosch-Strasse", "1", "99425", "Weimar", "DE");
        bosch =  new Manufacturer("Bosch",address,"Mr. Smith","01234");
        warehouse= new Warehouse();

    }

    @Test
    void is_a_bill_in_openBills_after_customer_rent_a_tool() throws InterruptedException {
        //create one Bill with the current date - equal to rentDate
        warehouse.putToolInWarehouse(hammer);
        Bill newBill = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        Billing.getOpenBills().add(newBill);
        Bill searchedBill = Billing.findOpenBillFromCustomer(custMaria);
        assertEquals(searchedBill, newBill);
    }

    @Test
    void is_billStatus_open_after_create_a_bill()
    {
        Bill newBill = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        assertEquals(newBill.getBillStatus(), BillStatus.OPEN);
    }

    @Test
    void should_return_null_if_the_rent_date_is_not_the_current_day()
    {
        // change date, so rentDate is in the past
        Billing.getOpenBills().clear();
        warehouse.putToolInWarehouse(hammer);
        LocalDate newDate= LocalDate.of(2020, 1,24);
        Bill nullBill = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        nullBill.setRentDate(newDate);
        Billing.getOpenBills().add(nullBill);
        assertNull(Billing.findOpenBillFromCustomer(custMaria));
    }

    @Test
    void is_there_a_bill_from_a_customer_which_matches_with_the_returned_tool() {
        //create one Bill with the current date - equal to rentDate
        Billing.getOpenBills().clear();
        warehouse.putToolInWarehouse(hammer);
        Rental.rentATool(hammer,stationOne,custMaria,warehouse);
        Bill searchedBill = Billing.findOpenBillFromCustomerForReturn(custMaria,hammer,stationOne);
        assertEquals(searchedBill,Billing.getOpenBills().get(0));
    }

    @Test
    void move_the_bill_after_all_rent_processes_are_closed() {
        Billing.getOpenBills().clear();
        Billing.getCheckBills().clear();
        warehouse.putToolInWarehouse(hammer);
        Rental.rentATool(hammer,stationOne,custMaria,warehouse);
        //1 bill in openBills, 0 in checkedBills
        int sizeOpenBills = Billing.getOpenBills().size();
        int sizeCheckedBills = Billing.getCheckBills().size();

        Billing.checkBillsFromCustomerAndMoveThemToTheCkeckedListIfAllRentProcessesAreClosed(custMaria);

        //check bill status
        for (Bill bill : Billing.getCheckBills()) {
            if (bill.getCustomer().equals(custMaria)) {
                assertEquals(bill.getBillStatus(), BillStatus.CHECKED);
            }
            return;
        }

        //0 bill in openBills, 1 in checkedBills
        assertEquals(0,sizeOpenBills-1);
        assertEquals(1,sizeCheckedBills+1);

    }

    @Test
    void move_the_bill_from_checked_to_closed() {
        Billing.getOpenBills().clear();
        Billing.getClosedBills().clear();

        Bill bill = new Bill(custMaria,stationOne);
        Billing.getCheckBills().add(bill);
        //1 bill iun checkedBills, 0 in closedBills
        int sizeCheckedBills = Billing.getCheckBills().size();
        int sizeClosedBills = Billing.getClosedBills().size();

        Billing.moveFromCheckToClosed(bill);

        //check bill status
        assertEquals(bill.getBillStatus(), BillStatus.CLOSED);

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
        //find bill and use them
        warehouse.putToolInWarehouse(drill);
        Rental.rentATool(drill,stationOne,custMaria,warehouse);
        Bill searchedBill2 = Billing.findOpenBillFromCustomer(custMaria);

        assertEquals(searchedBill,searchedBill2);
    }


    @Test
    void findBillInListByReference() {
        Bill bill = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        Bill bill2 = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        Bill bill3 = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        Bill bill4 = new Bill(custMaria, stationOne);
        Bill bill5 = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        Bill bill6 = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        Bill bill7 = Billing.createOpenBillFromCustomer(stationOne, custMaria);
        //Billing.getOpenBills().add(bill42);
        assertEquals(bill3,Billing.findBillInListByReference(bill3, (ArrayList<Bill>) Billing.getOpenBills()));
        assertNull(Billing.findBillInListByReference(bill4, (ArrayList<Bill>) Billing.getOpenBills()));
    }
}