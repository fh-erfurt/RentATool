package de.rat.model.logistics;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.logging.Logger;
/**Represents a bill.
 * @author Danny Steinbrecher, Marco Petzold, Christian König,Bilal Alnani
 */

/** Creates a bill .
 *  Stock is a array list of tools
 *
 */

@Entity
//ToDo will Id haben?
public class Warehouse {
    private static final Logger logger = Logger.getLogger("LOGGER");
    private ArrayList<Tool> Stock= new ArrayList<>();

    public Warehouse() {
    }

    /** get  the stock from the warehouse and print the size
     *  @return  the stock
     *
     */
    public ArrayList<Tool> getStock() {
        return Stock;
    }

    /** put the respective tool in the warehouse
     *
     */
    public void putToolInWarehouse(Tool tool){
        if(tool !=null)
        {
            this.Stock.add(tool);
            logger.info("Das Tool ist im Warenhaus ");
        }
    }



    /** remove the respective tool from the warehouse
     *  @return  the tool
     *  @return  null if there was no tool founded or a toll was not AVAILABLE
     *
     */
    public Tool removeToolFromWarehouse(Tool tool){

        for (Tool foundedTool : Stock)
        {
            if(foundedTool.equals(tool))
            {
                if(foundedTool.getToolStatus() == ToolStatus.AVAILABLE) {
                    Stock.remove(tool);
                    logger.info("Das Tool ist bereit zum Ausleihen");
                    return tool;
                }else{
                    logger.severe("Das Tool ist nicht ausleihbereit");
                    return null;
                }
            }
        }
        logger.severe("Werkzeug nicht im Lager vorhanden");
        return null;
    }

    /** set the tool status for the tool
     *  @return  true if the tool status was updated
     *  @return false if there was no tool
     *
     */
    public boolean setToolStatus(Tool tool, ToolStatus updatedToolStatus)
    {
        for(Tool foundedTool:Stock)
        {
            if(foundedTool.equals(tool))
            {
                foundedTool.setToolStatus(updatedToolStatus);
                return true;
            }
        }
        logger.severe("Werkzeug nicht im Lager vorhanden");
        return false;
    }
}
