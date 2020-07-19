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
        assertEquals(Date.calculateDifferenceBetweenDates(date2, date1), 2);
    }


    @Test
    void compareDates() {

        // EQUAL:
        assertTrue(Date.compareDates(date1, Operator.EQUAL, date1));
        assertFalse(Date.compareDates(date1, Operator.EQUAL, date2));

        // NOT_EQUAL:
        assertTrue(Date.compareDates(date1, Operator.NOT_EQUAL, date2));
        assertFalse(Date.compareDates(date1, Operator.NOT_EQUAL, date1));

        // GREATER:
        assertTrue(Date.compareDates(date2, Operator.GREATER, date1));
        assertFalse(Date.compareDates(date1, Operator.GREATER, date2));

        // GREATER_OR_EQUAL:
        assertTrue(Date.compareDates(date1, Operator.GREATER_OR_EQUAL, date1));
        assertTrue(Date.compareDates(date2, Operator.GREATER_OR_EQUAL, date1));
        assertFalse(Date.compareDates(date1, Operator.GREATER_OR_EQUAL, date2));

        // LESS:
        assertTrue(Date.compareDates(date1, Operator.LESS, date2));
        assertFalse(Date.compareDates(date2, Operator.LESS, date1));

        // LESS_OR_EQUAL:
        assertTrue(Date.compareDates(date1, Operator.LESS_OR_EQUAL, date1));
        assertTrue(Date.compareDates(date1, Operator.LESS_OR_EQUAL, date2));
        assertFalse(Date.compareDates(date2, Operator.LESS_OR_EQUAL, date1));
    }
}