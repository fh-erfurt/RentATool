package de.rat.billing;

import de.rat.billing.Bill;
import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.employee.Company;
import de.rat.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillTest {

//    Company rentATool = new Company("Rent a Tool");
//    Address testAddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
//    Customer testUser = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de","Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
//    Station testStation = new Station("S1", 3, testAddress);
//    Bill testBill = new Bill(testUser,testStation);
//    Station station = new Station("S1", 3, testAddress);

    private Company rentATool;
    private Address testAddress;
    private Customer testUser;
    private Station testStation;
    private Bill testBill;
    private Station station;

    @BeforeEach
    void setUp() {
        rentATool = new Company("Rent a Tool");
        testAddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        testUser = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de", "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
        testStation = new Station("S1", 3, testAddress);
        testBill = new Bill(testUser, testStation);
        station = new Station("S1", 3, testAddress);
    }

    //TODO: Autoinkrement funktioniert noch nicht richtig! Ist das auch von den anderen Tests abhängig? Inkrement startet bei 10002!
    // starte ich nur den einzelnen Test, dann will er 10001 als ergebnis, starte ich alle Test, dann will er 10002!
    // Habe verscuht das mit BeforeEach zu umgehen, hat aber nicht funktioniert

    @Test
    public void isBillNumberAutoincrement()
    {
        //BillNumber starts with 10000
        assertEquals(10002, testBill.getBillNumber());
        Bill testBill2=new Bill(testUser,testStation);
        assertEquals(10003, testBill2.getBillNumber());
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