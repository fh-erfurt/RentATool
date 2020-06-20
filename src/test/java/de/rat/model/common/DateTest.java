package de.rat.model.common;
import de.rat.model.common.Date;

import de.rat.model.customer.Customer;
import de.rat.model.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    private LocalDate date1;
    private LocalDate date2;


    @BeforeEach
    void setUp() {

        date1 = LocalDate.of(2005, 8, 29);
        date2 = LocalDate.of(2005, 8, 30);
    }

    @Test
    void calculateDifferenceBetweenDates() {

        int diffrence = Date.calculateDifferenceBetweenDates(date2, date1);
        assertEquals(diffrence, 2);

    }


    @Test
    void compareDates() {

        assertTrue(Date.compareDates(date1, Operator.LESS, date2));
        //TODO: added all Tests
//        return dateOne == dateTwo;

//        return dateOne != dateTwo;

//        return dateOne.compareTo(dateTwo) > 0;

//        return dateOne.compareTo(dateTwo) >= 0;

//        return dateOne.compareTo(dateTwo) < 0;

//        return dateOne.compareTo(dateTwo) <= 0;


    }
}