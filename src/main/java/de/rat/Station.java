package de.rat;

import java.util.ArrayList;
import java.util.Iterator;

public class Station {

    private String description;
    private int numberOfBoxes;
    private Address address;
    private ArrayList<Tool> boxesOfTools= new ArrayList<Tool>();


    public Station(String description, int numberOfBoxes, Address address) {
        this.description = description;
        this.numberOfBoxes = numberOfBoxes;
        this.address = address;


    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }

    public Address getAddress() {
        return address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberOfBoxes(int numberOfBoxes) {
        this.numberOfBoxes = numberOfBoxes;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getNumberOfTools() {
        return this.boxesOfTools.size();
    }

    public boolean addToolToBox(Tool tool) {

        int ToolCounter = boxesOfTools.size();
        if (numberOfBoxes <= boxesOfTools.size()) {
            System.out.println("Boxen sind voll");
            return false;
        }
        else {
            boxesOfTools.add(tool);

            if (boxesOfTools.size() > ToolCounter) {
                return true;
                } else {
                return false;
                }
            }
        }

        public Tool removeToolFromBox(Tool wantedTool) {

         for (Tool foundedTool : boxesOfTools) {
                if (foundedTool.equals(wantedTool)) {

                    boxesOfTools.remove(foundedTool);
                    return foundedTool;
                }
            }       return null;
        }
}
