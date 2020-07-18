package de.rat.repositories;


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
class StationRepositoryTest {

    private Station station1;
    private Address boschAddress;
    private Manufacturer bosch;
    private Tool hammer;
    private Tool bohrer;


    @Autowired
    ToolRepository tRepo;
    @Autowired
    AddressRepository aRepo;
    @Autowired
    StationRepository sRepo;
    @Autowired
    ManufracturerRepository mRepo;

    private static final Logger log = LoggerFactory.getLogger(ToolRepositoryTest.class);

    @BeforeEach
    void setUp() {

        boschAddress= new Address("Weg","12","12345","Erfurt","Deutschland");
        aRepo.save(boschAddress);

        bosch = new Manufacturer("Bosch",boschAddress,"Schmidt","123456789");
        mRepo.save(bosch);

        hammer = new Tool("1", bosch, "Hammer", Category.HANDTOOL, "1A", ToolStatus.AVAILABLE, new BigDecimal("3.00"));
        tRepo.save(hammer);

        bohrer = new Tool("2", bosch, "Bohrer", Category.HANDTOOL, "1A", ToolStatus.AVAILABLE, new BigDecimal("4.00"));
        tRepo.save(bohrer);

        station1 = new Station("Station 1",25,boschAddress);
        sRepo.save(station1);
    }

    @Test
    public void is_Tool_in_box (){
        station1.addToolToBox(hammer);
        sRepo.save(station1);

        // if tool is already in station, adding tool to box failed
        assertFalse(sRepo.findById(station1.getId()).addToolToBox(hammer));

    }

    @Test
    public void is_tool_removed_from_station_table_after_removing(){

        station1.addToolToBox(bohrer);
        sRepo.save(station1);
        log.info("Box Size:");
        log.info("--------------------------------");
        log.info(String.valueOf(station1.getBoxesOfTools().size()));

        station1.addToolToBox(hammer);
        sRepo.save(station1);
        log.info("Box Size:");
        log.info("--------------------------------");
        log.info(String.valueOf(station1.getBoxesOfTools().size()));

        station1.removeToolFromBox(bohrer);
        sRepo.save(station1);
        log.info("'Box Size':");
        log.info("--------------------------------");
        log.info(String.valueOf(station1.getBoxesOfTools().size()));

        //check box size from station from database
        assertEquals(sRepo.findById(station1.getId()).getBoxesOfTools().size(),1);

    }
}