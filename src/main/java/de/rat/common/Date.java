package de.rat.common;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**Represents a class date.
 * @author Marco Petzold, Christian König, Danny Steinbrecher, Bilal Alnani
 */
public class Date extends GregorianCalendar {

    public static GregorianCalendar getToday() {
        GregorianCalendar today = new GregorianCalendar();
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        return today;
    }

    public static boolean compareDates(GregorianCalendar dateOne, Operator operator, GregorianCalendar dateTwo){
        switch(operator){
            case EQUAL:
                return dateOne.getTimeInMillis() == dateTwo.getTimeInMillis();
            case NOT_EQUAL:
                return dateOne.getTimeInMillis() != dateTwo.getTimeInMillis();
            case GREATER:
                return dateOne.getTimeInMillis() > dateTwo.getTimeInMillis();
            case GREATER_OR_EQUAL:
                return dateOne.getTimeInMillis() >= dateTwo.getTimeInMillis();
            case LESS:
                return dateOne.getTimeInMillis() < dateTwo.getTimeInMillis();
            case LESS_OR_EQUAL:
                return dateOne.getTimeInMillis() <= dateTwo.getTimeInMillis();
            default:
                return false;
        }
    }

    /**
     * calculate the differnce between the date from the rent day and the date of return
     * @return  the calculated days
     *
     */
    public static int calculateDifferenceBetweenDates(GregorianCalendar higherDate, GregorianCalendar lowerDate) {
        // gregorian calender includes the date as long, so we calculate the days between and rounded the result to int
        long LongDateDifference = higherDate.getTime().getTime()-lowerDate.getTime().getTime();
        return (int)Math.ceil((double)LongDateDifference/(24.*60.*60.*1000.)) + 1; //Gregorian Calender hold the time as milliseconds
    }
}
