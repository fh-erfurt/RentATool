package de.rat;

import java.util.ArrayList;

public class Warehouse {
    private ArrayList<Tool> Stock= new ArrayList<Tool>();

    public Warehouse() {
    }

    public ArrayList<Tool> getStock() {
        return Stock;
    }

    public void putToolInWarehouse(Tool tool){
        //TODO: Werkzeug einlagern
    }

    public void removeToolFromWarehouse(Tool tool){
        //TODO: Werkzeug aus Lager nehmen und übergeben
    }



}
