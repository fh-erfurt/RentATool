package de.rat.model.customer;

import de.rat.model.BaseModel;
import de.rat.model.logistics.Station;
import de.rat.model.logistics.Tool;
import javax.persistence.*;
import java.time.LocalDate;
/**Represents an RentProcess.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */

/** Creates an customer .
 *  rentedTool is the rented tool
 *  returnDate the date when the customer bring the tool back
 *  returnStation the station that the customer has chosen to bring back the tool
 *
 */

@Entity
public class RentProcess extends BaseModel {

    @ManyToOne
    private Tool rentedTool;

    private LocalDate returnDate;

    @ManyToOne
    private Station returnStation;

    protected RentProcess(){}

    /** Creates an customer .
     *  rentedTool is the rented tool
     *  returnDate the date when the customer bring the tool back
     *  returnStation the station that the customer has chosen to bring back the tool
     *
     */
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

    public LocalDate getReturnDate() {
        return returnDate;
    }


    /*Setter*/
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturnStation(Station returnStation){
        this.returnStation=returnStation;
    }


    /** set return date and return station to complete the return process
     *  @return  true if the method works
     *  @return  false if the method not works
     *
     */
    public boolean completeRentProcess(Station station, LocalDate date){

        if(this.rentedTool != null && station != null && date != null){
            this.setReturnDate(date);
            this.setReturnStation(station);
            return true;
        }
        return false;
    }
}


