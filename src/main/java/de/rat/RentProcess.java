package de.rat;

import java.util.Date;
import java.util.GregorianCalendar;

public class RentProcess {
    private Tool rentedTool;
    private GregorianCalendar returnDate;
    private Station returnStation;

    public RentProcess (Tool rentedTool){
        this.rentedTool = rentedTool;
        returnDate=null;
        returnStation=null;
    }

    /*Getter*/
    public Station getReturnStation() {
        return returnStation;
    }

    public Tool getRentedTool(){
        return rentedTool;
    }

    public GregorianCalendar getReturnDate() {
        return returnDate;
    }


    /*Setter*/
    public void setReturnDate(GregorianCalendar returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturnStation(Station returnStation){
        this.returnStation=returnStation;
    }

    public void setRentedTool(Tool rentedTool) {
        this.rentedTool = rentedTool;
    }

    /*methods*/
    public boolean completeRentProcess(Station station, GregorianCalendar date){

        if(this.rentedTool != null && station != null && date != null){
            this.setReturnDate(date);
            this.setReturnStation(station);
            return true;
        }
        return false;
    }


}


