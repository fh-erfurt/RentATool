package de.rat.storage.repository;


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

@DataJpaTest
class ToolRepositoryTest {

    @Autowired
    ToolRepository repository;
    private static final Logger log = LoggerFactory.getLogger(ToolRepositoryTest.class);

private Address address2;
private Manufacturer manufacture;
private Tool tool1;

    @BeforeEach
    void setUp() {

        address2 = new Address("Weg", 1,12345,"Erfurt","Deutschland");
        manufacture = new Manufacturer("Bosch", address2, "Herr Bosch", "05642-458759");
        tool1= new Tool("1",manufacture,"Hammer",Category.HANDTOOL,"1A",ToolStatus.AVAILABLE,5.00);
    }

//ToDo Test im Moment ohne manufacturer, da Fehler mit transient kommt
    @Test
    void  find_tool_by_description() {

        repository.save(tool1);

        Tool tool = repository.findByDescription("Hammer");
        log.info("Tool found with description:");
        log.info("--------------------------------");
        log.info(tool.getDescription());
        log.info("");
    }

    @Test
    void  find_tool_by_id() {

        repository.save(new Tool("2%%%%%%%%%","hammer",Category.HANDTOOL,"Lager1",ToolStatus.AVAILABLE,25.00));



        Tool tool = repository.findById(1);
        log.info("Tool found with ID(1):");
        log.info("--------------------------------");
        log.info(tool.getStock());
        log.info("");
    }

}
