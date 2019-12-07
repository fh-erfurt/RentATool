package de.rat;

import java.util.ArrayList;

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

    public boolean addToolToBox(Tool tool) {

        int ToolCounter = boxesOfTools.size();
        boxesOfTools.add(tool);

            if(boxesOfTools.size() > ToolCounter){
                return true;
            }
            else{
                return false;
            }
        }



}
