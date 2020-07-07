package de.rat.storage.repository;


import de.rat.model.common.Address;
import de.rat.model.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WarehouseRepositoryTest {

    private Warehouse warehouse1;
    private Address boschAddress;
    private Manufacturer bosch;
    private Tool hammer;
    private Tool bohrer;


    @Autowired
    ToolRepository tRepo;
    @Autowired
    AddressRepository aRepo;
    @Autowired
    WarehouseRepository wRepo;
    @Autowired
    ManufracturerRepository mRepo;

    private static final Logger log = LoggerFactory.getLogger(ToolRepositoryTest.class);

    @BeforeEach
    void setUp() {

        boschAddress = new Address("Weg", 12, 12345, "Erfurt", "Deutschland");
        aRepo.save(boschAddress);

        bosch = new Manufacturer("Bosch", boschAddress, "Schmidt", "123456789");
        mRepo.save(bosch);

        hammer = new Tool("1", bosch, "Hammer", Category.HANDTOOL, "1A", ToolStatus.AVAILABLE, new BigDecimal("3.00"));
        tRepo.save(hammer);

        bohrer = new Tool("2", bosch, "Bohrer", Category.HANDTOOL, "1A", ToolStatus.AVAILABLE, new BigDecimal("4.00"));
        tRepo.save(bohrer);

        warehouse1 = new Warehouse();
    }

    @Test
    public void is_tool_in_stock(){

        warehouse1.putToolInWarehouse(hammer);
        wRepo.save(warehouse1);

        assertEquals(wRepo.findById(warehouse1.getId()).getStock().size(),1);
    }

    @Test
    public void is_tool_status_changed_in_database(){

        warehouse1.putToolInWarehouse(hammer);
        wRepo.save(warehouse1);

        assertEquals(wRepo.findById(warehouse1.getId()).removeToolFromWarehouse(hammer).getToolStatus(),ToolStatus.AVAILABLE);

        warehouse1.putToolInWarehouse(hammer);

        warehouse1.setToolStatus(hammer,ToolStatus.ISINREPAIR);
        tRepo.save(hammer);
        wRepo.save(warehouse1);

        log.info("'Stock  Size':");
        log.info("--------------------------------");
        log.info(String.valueOf(warehouse1.getStock().size()));

        //hammer is in warehouse, but toolstatus is not availeble so it cant remove
        assertNull(wRepo.findById(warehouse1.getId()).removeToolFromWarehouse(hammer));





    }

}