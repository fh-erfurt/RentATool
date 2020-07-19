package de.rat.repositories;

import de.rat.model.common.Address;
import de.rat.model.logistics.Category;
import de.rat.model.logistics.Manufacturer;
import de.rat.model.logistics.Tool;
import de.rat.model.logistics.ToolStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ToolRepositoryTest {

    @Autowired
    ToolRepository toolRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ManufracturerRepository manufracturerRepository;

    private static final Logger log = LoggerFactory.getLogger(ToolRepositoryTest.class);

    private Address address2;
    private Manufacturer manufacture;
    private Tool tool1;
    private Tool tool2;

    @BeforeEach
    void setUp() {

        address2 = new Address("Weg", "1","12345","Erfurt","Deutschland");
        addressRepository.save(address2);

        manufacture = new Manufacturer("Bosch", address2, "Herr Bosch", "05642-458759");
        manufracturerRepository.save(manufacture);

        tool1= new Tool("1",manufacture,"Bohrer",Category.HANDTOOL,"1A",ToolStatus.AVAILABLE,new BigDecimal("5.00"));
        tool2= new Tool("2",manufacture,"Axt",Category.HANDTOOL,"1B",ToolStatus.AVAILABLE,new BigDecimal("6.00"));


    }

//ToDo Test im Moment ohne manufacturer, da Fehler mit transient kommt
    @Test
    void  find_tool_by_description() {

        toolRepository.save(tool1);

        Tool tool = toolRepository.findByDescription("Hammer");
        log.info("Tool found with description:");
        log.info("--------------------------------");
        log.info(tool.getDescription());
        log.info("");
        assertEquals(tool.getStock(),"1A");
    }

    @Test
    void  find_tool_by_id() {

        toolRepository.save(tool2);

        Tool tool = toolRepository.findById(tool2.getId());
        log.info("Tool found with ID(1):");
        log.info("--------------------------------");
        log.info(tool.getStock());
        log.info("");
        assertEquals(tool.getStock(),"1B");
    }

}
