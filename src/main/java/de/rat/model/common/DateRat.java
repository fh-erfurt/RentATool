package de.rat.model.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**Represents a class date.
 * @author Marco Petzold, Christian König, Danny Steinbrecher, Bilal Alnani
 */
public class DateRat extends Date {

    private Date dateRat;

    public DateRat(){
        this.dateRat = new Date();
    }

    /**
     * get the current date with the 00:00:00 timestamp
     * @return  the date
     *
     */
//    public Date getToday() {
//        Date today = new Date();
//        return new SimpleDateFormat("yyyy-MM-dd").parse(today);
//
//    }

//    public static GregorianCalendar getToday() {
//        GregorianCalendar today = new GregorianCalendar();
//        today.set(Calendar.HOUR, 0);
//        today.set(Calendar.MINUTE, 0);
//        today.set(Calendar.SECOND, 0);
//        return today;
//    }

//    @Override
//    public String toString(){
//
//        return String.format(
//                "Customer[firstName='%s']",
//                this.dateRat.getTimeInMillis());
//    }


//    /**
//     * compares 2 Dates with an Operator
//     * @return  the calculated days
//     *
//     */
//    public static boolean compareDates(Date dateOne, Operator operator, Date dateTwo){
//        switch(operator){
//            case EQUAL:
//                return dateOne.getTimeInMillis() == dateTwo.getTimeInMillis();
//            case NOT_EQUAL:
//                return dateOne.getTimeInMillis() != dateTwo.getTimeInMillis();
//            case GREATER:
//                return dateOne.getTimeInMillis() > dateTwo.getTimeInMillis();
//            case GREATER_OR_EQUAL:
//                return dateOne.getTimeInMillis() >= dateTwo.getTimeInMillis();
//            case LESS:
//                return dateOne.getTimeInMillis() < dateTwo.getTimeInMillis();
//            case LESS_OR_EQUAL:
//                return dateOne.getTimeInMillis() <= dateTwo.getTimeInMillis();
//            default:
//                return false;
//        }
//    }
//
//
    /**
     * calculate the differnce between the date from the rent day and the date of return
     * @return  the calculated days
     *
     */
    public static int calculateDifferenceBetweenDates(Date higherDate, Date lowerDate) throws ClassCastException{
        // gregorian calender includes the date as long, so we calculate the days between and rounded the result to int
        long LongDateDifference = higherDate.getTime()-lowerDate.getTime();
        return (int)Math.ceil((double)LongDateDifference/(24.*60.*60.*1000.)) + 1; //Gregorian Calender hold the time as milliseconds
    }
}
