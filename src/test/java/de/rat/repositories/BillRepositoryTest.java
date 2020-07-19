package de.rat.repositories;

import de.rat.model.billing.Bill;
import de.rat.model.billing.Billing;
import de.rat.model.common.Address;
import de.rat.model.customer.Customer;
import de.rat.model.logistics.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.QAbstractAuditable;


import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BillRepositoryTest {

    private Bill custBill;
    private Bill compareBill;
    private Customer custHans;
    private Address stationAddress;
    private Station rentStation;


    @Autowired
    BillRepository billRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    StationRepository stationRepository;

    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);


    @BeforeEach
    void setUp() {
        custHans = new Customer("Müller", "Hans", LocalDate.of(2005, 8, 29), "hans@web.de", "Kastanienallee", "1A", "01144", "Berlin", "DE", "0176767676");
        customerRepository.save(custHans);
        stationAddress = new Address("Strasse", "1","12345","Arnstadt","Deutschland");
        addressRepository.save(stationAddress);
        rentStation = new Station("Sation 15",24,stationAddress);
    }


    @Test
    void find_Bill_by_Id(){

        custBill =new Bill(custHans,rentStation);
        billRepository.save(custBill);
        Billing.getClosedBills().add(custBill);
        assertEquals(Billing.getClosedBills().size(),1);
        Optional<Bill> compareBill = billRepository.findById(10001);
        assertEquals(compareBill.get().getBillNumber(),10001);

    }

}
