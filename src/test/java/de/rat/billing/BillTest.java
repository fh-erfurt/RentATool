package de.rat.billing;

import de.rat.billing.Bill;
import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.employee.Company;
import de.rat.logistics.Station;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillTest {

    Company rentATool = new Company("Rent a Tool");
    Address Testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
    Customer TestUser = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de","Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651",rentATool);
    Station Teststation = new Station("S1", 3, Testaddress);
    Bill testBill=new Bill(TestUser,Teststation);

    @Test
    public void isBillNumberAutoincrement()
    {
        assertEquals(10001, testBill.getBillNumber());
        Bill testBill2=new Bill(TestUser,Teststation);
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

    @Test
    public void isDateDifferenceEqualToOwnExpectedResult()
    {
        GregorianCalendar Date1 = new GregorianCalendar(2020,Calendar.JANUARY,10);
        int year1  =Date1.get(Calendar.YEAR);
        int month1 =Date1.get(Calendar.MONTH);
        int day1   =Date1.get(Calendar.DATE);

        GregorianCalendar Date2 = new GregorianCalendar(2020,Calendar.FEBRUARY,1);
        int year2  =Date2.get(Calendar.YEAR);
        int month2 =Date2.get(Calendar.MONTH)+1;
        int day2   =Date2.get(Calendar.DATE);

        long longDays = Date2.getTime().getTime()-Date1.getTime().getTime();
        long Days = Math.round((double)longDays/(24.*60.*60.*1000.));
        int days = (int)Days;
        assertEquals(3,days);


    }







}