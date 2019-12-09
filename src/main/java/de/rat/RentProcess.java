package de.rat;

import java.util.Date;

public class RentProcess {
    private Tool rentedTool;
    private Date returnDate;
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

    public Date getReturnDate() {
        return returnDate;
    }

    /*Setter*/
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturnStation(Station returnStation){
        this.returnStation=returnStation;
    }

    public void setRentedTool(Tool rentedTool) {
        this.rentedTool = rentedTool;
    }

    /*methods*/
}


