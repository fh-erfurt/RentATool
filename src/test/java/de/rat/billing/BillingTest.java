package de.rat.billing;

import de.rat.Rental;
import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.logistics.Manufacturer;
import de.rat.logistics.Station;
import de.rat.logistics.Tool;
import de.rat.logistics.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class BillingTest {

    //Variable declaration
    private Customer custMaria;
    private Address musterhausen;
    private Station stationOne;


    @BeforeEach
    void setUp() {
        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        stationOne = new Station("S1", 3, musterhausen);

        custMaria = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de",
                "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
    }

    @Test
    void findOpenBillFromCustomer() {
    }

    @Test
    void findOpenBillFromCustomerForReturn() {
    }

    @Test
    void createOpenBillFromCustomer() {
        Billing.CreateOpenBillFromCustomer(stationOne, custMaria);
        Billing.CreateOpenBillFromCustomer(stationOne, custMaria);
        Billing.CreateOpenBillFromCustomer(stationOne, custMaria);
        Billing.checkBillsFromCustomerAndMoveThemToTheCkeckedListIfAllRentProcessesAreClosed(custMaria);

    }

    @Test
    void moveBillFromOpenToChecked() {
    }

    @Test
    void moveFromCheckToClosed() {
    }

    @Test
    void findOrCreateBill() {
    }
}