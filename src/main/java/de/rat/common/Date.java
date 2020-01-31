package de.rat.common;

import de.rat.billing.Bill;
import de.rat.customer.Customer;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date extends GregorianCalendar {

    public static GregorianCalendar getToday() {
        GregorianCalendar today = new GregorianCalendar();
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        return today;
    }
}
