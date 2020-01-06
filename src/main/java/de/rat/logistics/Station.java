package de.rat.logistics;

import de.rat.common.Address;

import java.util.ArrayList;

public class Station {

    private String description;
    private int numberOfBoxes;
    private Address address;
    /* tool management */
    private ArrayList<Tool> boxesOfTools= new ArrayList<Tool>();


    public Station(String description, int numberOfBoxes, Address address) {
        this.description = description;
        this.numberOfBoxes = numberOfBoxes;
        this.address = address;
    }

    /*Getter*/
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

    public boolean addToolToBox(Tool tool)
        {
            /* checks whether the tool is already in the list */
            if(boxesOfTools.contains(tool)) {
                System.out.println("Das Werkzeug ist bereits in der Liste vorhanden!");
                return false;
            }else {

                int ToolCounter = boxesOfTools.size();
                /* check that is enough space in a station */
                /*
                if (numberOfBoxes <= boxesOfTools.size()) {
                    System.out.println("Alle Boxen sind bereits in Benutzung");
                    return false;

                 */
                if (checkStationLevel()!=true) {
                    return false;
                } else {
                    boxesOfTools.add(tool);
                    return true;
                }

            }
        }

    public Tool removeToolFromBox(Tool wantedTool)
        {


        /*check that the right tool is in on of the boxes */
        for (Tool foundedTool : boxesOfTools)
            {
                if (foundedTool.equals(wantedTool))
                {
                    boxesOfTools.remove(foundedTool);
                    return foundedTool;
                }
            }
            System.out.println("Werkzeug nicht in der Station vorhanden");
            return null;
        }

    /* check that is enough space in a station */
        public boolean checkStationLevel() {
            if (numberOfBoxes <= boxesOfTools.size()) {
                System.out.println("Die Station ist voll!");
                return false;
            } else {
                System.out.println("In der Station ist noch Platz!");
                return true;
            }
        }

}
