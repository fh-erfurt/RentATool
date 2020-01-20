package de.rat.billing;

import de.rat.billing.Bill;
import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.employee.Company;
import de.rat.logistics.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillTest {

    Company rentATool = new Company("Rent a Tool");
    Address testAddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
    Customer testUser = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de","Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
    Station testStation = new Station("S1", 3, testAddress);
    Bill testBill=new Bill(testUser,testStation);
    Station station = new Station("S1", 3, testAddress);


    @Test
    public void isBillNumberAutoincrement()
    {
        //BillNumber starts with 10000
        assertEquals(10001, testBill.getBillNumber());
        Bill testBill2=new Bill(testUser,testStation);
        assertEquals(10002, testBill2.getBillNumber());
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