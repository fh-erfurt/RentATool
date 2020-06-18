package de.rat.model.common;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DateRatTest {

//    private DateRat dateRat;

//    @BeforeEach
//    void setUp() {
//        dateRat = new DateRat();
//    }

    private static final Logger log = LoggerFactory.getLogger(DateRatTest.class);

    @Test
    void get_the_Date_from_today_without_time(){

        DateRat dateRat = new DateRat();
//
//        log.info("Actual Date:");
//        log.info("--------------------------------");
//        log.info(dateRat.toString());
//        log.info("");
    }


    @Test
    void calculateDifferenceBetweenDates() {

        Date date1 = new DateRat();
        Date date2 = new DateRat();


                // get the dates of the return and rented Date and calculate the difference.
                int days = DateRat.calculateDifferenceBetweenDates(date1, date2);

        assertEquals(date1, date2);
        assertEquals(days, 1);
    }


}