package de.rat.storage.repository;

import de.rat.model.Rental;
import de.rat.model.billing.Bill;
import de.rat.model.billing.BillStatus;
import de.rat.model.billing.Billing;
import de.rat.model.common.*;
import de.rat.model.customer.Customer;
import de.rat.model.customer.RentProcess;
import de.rat.model.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RentalBillTest {

    private Warehouse warehouse1;
    private Address address1;
    private Manufacturer bosch;
    private Station station1;
    private Tool hammer;
    private Tool bohrer;
    private Customer custHans;

    @Autowired
    CustomerRepository cRepo;
    @Autowired
    ToolRepository tRepo;
    @Autowired
    AddressRepository aRepo;
    @Autowired
    WarehouseRepository wRepo;
    @Autowired
    ManufracturerRepository mRepo;
    @Autowired
    StationRepository sRepo;
    @Autowired
    RentProcessRepository rpRepo;
    @Autowired
    BillRepository bRepo;
    @Autowired
    BillingRepository billingRepo;

    private static final Logger log = LoggerFactory.getLogger(RentalBillTest.class);

    @BeforeEach
    void setUp() {

        address1 = new Address("Weg", "1","12345","Erfurt","DE");
        aRepo.save(address1);
        custHans =  new Customer("Müller", "Hans", LocalDate.of(2005, 8, 29),"hans@web.de","Weg","1","12345", "Erfurt","DE","0176767676");
        cRepo.save(custHans);
        bosch = new Manufacturer("Bosch", address1, "Schmidt", "123456789");
        mRepo.save(bosch);
        hammer = new Tool("1", bosch, "Hammer", Category.HANDTOOL, "1A", ToolStatus.AVAILABLE, new BigDecimal("3.00"));
        tRepo.save(hammer);
        bohrer = new Tool("2", bosch, "Bohrer", Category.HANDTOOL, "1A", ToolStatus.AVAILABLE, new BigDecimal("4.00"));
        tRepo.save(bohrer);
        warehouse1 = new Warehouse();
        warehouse1.putToolInWarehouse(hammer);
        warehouse1.putToolInWarehouse(bohrer);
        wRepo.save(warehouse1);
        station1 = new Station("Station 1",25,address1);
        sRepo.save(station1);

    }

    @Test
    void is_rental_save_all_repositories() {

        Rental.rentATool(hammer, station1, custHans, warehouse1);
        tRepo.save(hammer);
        cRepo.save(custHans);
        sRepo.save(station1);
        wRepo.save(warehouse1);

        Bill testBill = Billing.findOrCreateBill(custHans, station1);
        RentProcess testRentProcess = testBill.findRentProcess(hammer);
        rpRepo.save(testRentProcess);
        bRepo.save(testBill);

        assertEquals(hammer, testRentProcess.getRentedTool());
        assertEquals(testBill.getCustomer(), custHans);
        assertEquals(testBill.getBillStatus(), BillStatus.OPEN);

        Rental.returnTool(hammer, station1, custHans, warehouse1);
        tRepo.save(hammer);
        cRepo.save(custHans);
        sRepo.save(station1);
        wRepo.save(warehouse1);

        assertEquals(testBill.getBillStatus(), BillStatus.CHECKED);
        assertEquals(station1.getNumberOfTools(),0);
    }

    @Test
    void are_all_data_are_saved_for_rent_and_remove_two_tools_at_one_day() {

        //rent tool 1
        Rental.rentATool(hammer, station1, custHans, warehouse1);
        tRepo.save(hammer);
        cRepo.save(custHans);
        sRepo.save(station1);
        wRepo.save(warehouse1);
        Bill testBill = Billing.findOrCreateBill(custHans, station1);


        // rent tool 2
        Rental.rentATool(bohrer, station1, custHans, warehouse1);
        tRepo.save(bohrer);
        cRepo.save(custHans);
        sRepo.save(station1);
        wRepo.save(warehouse1);
        Bill testBill1 = Billing.findOrCreateBill(custHans, station1);

        assertEquals(testBill, testBill1);

        //compare tools with rentProcesses
        RentProcess testRentProcess1 = testBill.findRentProcess(hammer);
        RentProcess testRentProcess2 = testBill.findRentProcess(bohrer);

        rpRepo.save(testRentProcess1);
        rpRepo.save(testRentProcess2);

        // all in same bill
        bRepo.save(testBill);

        assertEquals(hammer, testRentProcess1.getRentedTool());
        assertEquals(bohrer, testRentProcess2.getRentedTool());
        assertEquals(testBill.getCustomer(), custHans);
        assertEquals(testBill.getBillStatus(), BillStatus.OPEN);

        //return first tool
        Rental.returnTool(hammer, station1, custHans, warehouse1);
        tRepo.save(hammer);
        cRepo.save(custHans);
        sRepo.save(station1);
        wRepo.save(warehouse1);

        // bill is already open
        assertEquals(testBill.getBillStatus(), BillStatus.OPEN);

        //return last tool, bill is moved to checked_bills
        Rental.returnTool(bohrer, station1, custHans, warehouse1);

        tRepo.save(hammer);
        cRepo.save(custHans);
        sRepo.save(station1);
        wRepo.save(warehouse1);
        assertEquals(testBill.getBillStatus(), BillStatus.CHECKED);


        }


}