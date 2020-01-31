package de.rat.logistics;

import de.rat.common.Address;

import java.util.ArrayList;
import java.util.logging.Logger;

/** Creates station .
 *  @param description this is the discription from the station
 *  @param numberOfBoxes max size of boxes
 *  @param address where the station is installed
 *  @param boxesOfTools a array list of boxes and the array size is equal to the number of boxes
 *
 */
public class Station {
    private static final Logger logger = Logger.getLogger("LOGGER");
    private String description;
    private int numberOfBoxes;
    private Address address;
    /* tool management */
    private ArrayList<Tool> boxesOfTools= new ArrayList<Tool>();


    /** Creates station .
     *  @param description this is the discription from the station
     *  @param numberOfBoxes max size of boxes
     *  @param address where the station is installed
     *
     */
    public Station(String description, int numberOfBoxes, Address address) {
        this.description = description;
        this.numberOfBoxes = numberOfBoxes;
        this.address = address;
    }



    /** get the description
     * @return description  from the station
     *
     */
    public String getDescription() {
        return description;
    }

    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }

    public Address getAddress() {
        return address;
    }

    /*Setter*/
    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberOfBoxes(int numberOfBoxes) {
        this.numberOfBoxes = numberOfBoxes;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /*methods*/
    public int getNumberOfTools() {
        return this.boxesOfTools.size();
    }

    /** add the respective tool in the boxes of tools
     * checkStationLevel check is there one empty box
     * @return false if the tool is already in the box
     * @return true if the tool was added to the box
     *
     */
    public boolean addToolToBox(Tool tool)
    {
        if(tool == null) { return false; };

        if(!this.checkStationLevel()){return false;}

        /* checks whether the tool is already in the box */
        if(boxesOfTools.contains(tool)) {
            logger.severe("Das Werkzeug ist bereits in der Station!");
            return false;
        }

        boxesOfTools.add(tool);
        logger.info("Das Werkzeug wurde in die Box gelegt");
        return true;
    }


    /** remove the respective tool in the boxes of tools
     * @return foundedTool if the tool to remove was founded
     * @return null if the tool is not in the box
     *
     */
    public Tool removeToolFromBox(Tool wantedTool)
        {


        /*check that the right tool is in on of the boxes */
        for (Tool foundedTool : boxesOfTools)
            {
                if (foundedTool.equals(wantedTool))
                {
                    boxesOfTools.remove(foundedTool);
                    logger.info("Werkzeug wurde in Station gefunden und entfernt");
                    return foundedTool;
                }
            }
            logger.severe("Werkzeug nicht in der Station vorhanden");
            return null;
        }



    /** check that is enough space in a station
     * @return false if the station is full
     * @return true if the station has a empty box
     *
     */
        public boolean checkStationLevel() {
            if (numberOfBoxes <= boxesOfTools.size()) {
                logger.severe("Die Station ist voll!");
                return false;
            } else {
                logger.info("In der Station ist noch Platz!");
                return true;
            }
        }

}
