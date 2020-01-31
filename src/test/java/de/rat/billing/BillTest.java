package de.rat.billing;

import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillTest {

    private Address testAddress;
    private Customer testUser;
    private Station testStation;
    private Bill testBill;
    private Station station;

    @BeforeEach
    void setUp() {
        testAddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        testUser = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de", "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
        testStation = new Station("S1", 3, testAddress);
        testBill = new Bill(testUser, testStation);
        station = new Station("S1", 3, testAddress);
    }

    @Test
    public void isBillNumberAutoincrement()
    {
        int billNumber = testBill.getBillNumber();
        Bill testBill2=new Bill(testUser,testStation);
        assertEquals(billNumber + 1, testBill2.getBillNumber());
    }

    @Test
    public void isRentDateEqualCurrentDate()
    {
        GregorianCalendar today = new GregorianCalendar();
        assertEquals(today.get(Calendar.DATE), testBill.getRentDate().get(Calendar.DATE));
        assertEquals(today.get(Calendar.MONTH), testBill.getRentDate().get(Calendar.MONTH));
        assertEquals(today.get(Calendar.YEAR), testBill.getRentDate().get(Calendar.YEAR));
    }



}