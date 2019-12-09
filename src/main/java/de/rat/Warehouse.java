package de.rat;

import java.util.ArrayList;

public class Warehouse {
    private ArrayList<Tool> Stock= new ArrayList<Tool>();

    public Warehouse() {
    }

    public ArrayList<Tool> getStock() {
        return Stock;
    }

    public boolean putToolInWarehouse(Tool tool){
        return true;
    }

    public boolean removeToolFromWarehouse(Tool tool){
        return true;
    }



}
