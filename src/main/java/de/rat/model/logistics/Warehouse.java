package de.rat.model.logistics;

import de.rat.model.BaseModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.*;

/**Represents a Warehouse.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */

/** Creates a Warehouse .
 *
 */

@Entity
public class Warehouse extends BaseModel {

    @Transient
    private static final Logger logger = Logger.getLogger("LOGGER");

    @OneToMany
    @JoinTable(name="warehouseTools",inverseJoinColumns=@JoinColumn(name="tool_id"))
    private List<Tool> Stock= new ArrayList<>();

    public Warehouse() { }

    /** get  the stock from the warehouse and print the size.
     *  @return  the stock
     *
     */
    public List<Tool> getStock() {
        return Stock;
    }

    /** put the respective tool in the warehouse.
     *
     */

    public void putToolInWarehouse(Tool tool) {
        if (tool != null) {
            this.Stock.add(tool);
            if (tool.getToolStatus() != ToolStatus.AVAILABLE) {
                tool.setToolStatus(ToolStatus.AVAILABLE);
            }
            logger.info("Das Tool ist im Warenhaus ");
        }
    }

    /** remove the respective tool from the warehouse.
     *  @return  the tool
     *  @return  null if there was no tool founded or a toll was not AVAILABLE
     *
     */
    public Tool removeToolFromWarehouse(Tool tool) {

        for (Tool foundedTool : Stock) {
            if (foundedTool.equals(tool)) {
                if (foundedTool.getToolStatus() == ToolStatus.AVAILABLE) {
                    Stock.remove(tool);
                    logger.info("Das Tool ist bereit zum Ausleihen");
                    tool.setToolStatus(ToolStatus.ISRENTED);
                    return tool;
                } else {
                    logger.severe("Das Tool ist nicht ausleihbereit");
                    return null;
                }
            }
        }

        logger.severe("Werkzeug nicht im Lager vorhanden");
        return null;
    }

    /** set the tool status for the tool.
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
