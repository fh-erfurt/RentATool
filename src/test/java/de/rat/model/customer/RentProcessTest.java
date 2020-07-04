package de.rat.model.customer;

import de.rat.model.common.Address;
import de.rat.model.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RentProcessTest {

    private Tool drill;
    private Tool hammer;

    private Address musterhausen;
    private Station stationOne;
    private Station stationTwo;
    private Warehouse warehouse;
    private Manufacturer bosch;
    private LocalDate date;


    @BeforeEach
    void setUp() {

        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        bosch = new Manufacturer("Bosch", musterhausen, "Mr Smith", "123456");
        stationOne = new Station("S1", 3, musterhausen);
        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, new BigDecimal(3));
        date =  LocalDate.of(2019, 12, 15);
    }

    @Test
    void is_the_rent_process_complete_with_a_useful_tool_date_and_station(){
        RentProcess testProcess = new RentProcess(drill);

        assertTrue(testProcess.completeRentProcess(stationOne,date));

    }

    @Test
    void does_the_rent_process_not_complete_with_wrong_params(){
        RentProcess testProcess = new RentProcess(hammer);

        assertFalse(testProcess.completeRentProcess(stationTwo,date));
    }

}