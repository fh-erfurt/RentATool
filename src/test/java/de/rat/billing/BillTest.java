package de.rat.billing;

import de.rat.billing.Bill;
import de.rat.common.Address;
import de.rat.customer.Customer;
import de.rat.employee.Company;
import de.rat.logistics.Station;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

class BillTest {

    Company rentATool = new Company("Rent a Tool");
    Address Testaddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
    Customer TestUser = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de","Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651",rentATool);
    Station Teststation = new Station("S1", 3, Testaddress);

    @Test
    void createANewBill()
    {
        Bill testbill=new Bill(TestUser,Teststation);

    }


}