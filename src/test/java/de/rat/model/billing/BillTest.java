package de.rat.model.billing;

import de.rat.model.common.Address;
import de.rat.model.customer.Customer;
import de.rat.model.customer.RentProcess;
import de.rat.model.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {

    private Address testAddress;
    private Customer testUser;
    private Station testStation;
    private Manufacturer bosch;
    private Bill testBill;

    private Tool hammer;
    private Tool drill;

    private RentProcess rentHammer;
    private RentProcess rentDrill;

    private GregorianCalendar date1;
    private GregorianCalendar date2;

    @BeforeEach
    void setUp() {
        testAddress = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        testUser = new Customer("Schmidt", "Maria", new GregorianCalendar(2005, GregorianCalendar.AUGUST, 29), "maria.schmidt@web.de", "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
        testStation = new Station("S1", 3, testAddress);
        bosch = new Manufacturer("Bosch", testAddress, "Mr Smith", "123456");
        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, 3.0);
        hammer = new Tool("12553", bosch, "Hammer", Category.HANDTOOL, "1-4-6", ToolStatus.AVAILABLE, 2.5);
        testBill = new Bill(testUser, testStation);
        rentHammer = new RentProcess(hammer);
        rentDrill = new RentProcess(drill);
        date1 =  new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 15);
        date2 =  new GregorianCalendar(2019, GregorianCalendar.DECEMBER, 18);
    }

    @Test
    public void is_BillNumber_Autoincrement()
    {
        int billNumber = testBill.getBillNumber();
        Bill testBill2=new Bill(testUser,testStation);
        assertEquals(billNumber + 1, testBill2.getBillNumber());
    }

    @Test
    public void is_RentDate_Equal_CurrentDate()
    {
        GregorianCalendar today = new GregorianCalendar();
        assertEquals(today.get(Calendar.DATE), testBill.getRentDate().get(Calendar.DATE));
        assertEquals(today.get(Calendar.MONTH), testBill.getRentDate().get(Calendar.MONTH));
        assertEquals(today.get(Calendar.YEAR), testBill.getRentDate().get(Calendar.YEAR));
    }

    @Test
    public void is_Full_RentPrice_correct_calculated() {

        testBill.setRentDate(date1);
        rentHammer.setReturnDate(date2);
        testBill.getListOfRentProcesses().add(rentHammer);
        testBill.setFullRentPrice();

        assertEquals(10, testBill.getFullRentPrice());
    }

    @Test
    public void is_Full_RentPrice_correct_calculated_with_discount() {
        testBill.setRentDate(date1);
        rentHammer.setReturnDate(date2);
        testBill.getListOfRentProcesses().add(rentHammer);
        testBill.setDiscount(20);
        testBill.setFullRentPrice();

        assertEquals(8,testBill.getFullRentPrice());

    }

    @Test
    public void check_If_All_RentProcesses_From_A_Bill_Are_Closed() {
        testBill.setRentDate(date1);
        rentHammer.setReturnDate(date2);
        rentHammer.setReturnStation(testStation);
        rentDrill.setReturnStation(testStation);
        testBill.getListOfRentProcesses().add(rentHammer);

        // rentHammer is closed because returnDate and station are set
        assertTrue(testBill.checkIfAllRentProcessesFromABillAreClosed());

        testBill.getListOfRentProcesses().add(rentDrill);

        // seceond process rentHammer is not closed
        assertFalse(testBill.checkIfAllRentProcessesFromABillAreClosed());

    }

    @Test
    public void does_findRentProcess_works(){

        testBill.getListOfRentProcesses().add(rentHammer);
        assertEquals(rentHammer,testBill.findRentProcess(hammer));
    }

}