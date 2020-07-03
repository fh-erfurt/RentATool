package de.rat.storage.repository;

import de.rat.model.common.Address;
import de.rat.model.customer.Customer;
import de.rat.model.logistics.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ManufracturerRepositoryTest {

    private Address address1;
    private Manufacturer manufacturer1;



}