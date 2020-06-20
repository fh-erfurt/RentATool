package de.rat.model.common;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.temporal.ChronoUnit;

/**Represents a class date.
 * @author Marco Petzold, Christian König, Danny Steinbrecher, Bilal Alnani
 */
public class Date extends GregorianCalendar {

    /**
     * compares 2 Dates with an Operator
     * @return  the calculated days
     *
     */
    public static boolean compareDates(LocalDate dateOne, Operator operator, LocalDate dateTwo){
        switch(operator){
            case EQUAL:
                return dateOne.compareTo(dateTwo) == 0;
            case NOT_EQUAL:
                return dateOne.compareTo(dateTwo) != 0;
            case GREATER:
               return dateOne.compareTo(dateTwo) > 0;
            case GREATER_OR_EQUAL:
                return dateOne.compareTo(dateTwo) >= 0;
            case LESS:
                return dateOne.compareTo(dateTwo) < 0;
            case LESS_OR_EQUAL:
                return dateOne.compareTo(dateTwo) <= 0;
            default:
                return false;
        }
    }


    /**
     * calculate the differnce between the date from the rent day and the date of return
     * @return  the calculated days
     *
     */
    public static int calculateDifferenceBetweenDates(LocalDate higherDate, LocalDate lowerDate) throws ClassCastException{
        return (int)ChronoUnit.DAYS.between(lowerDate, higherDate) + 1;
    }
}
