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

    public Tool removeToolFromWarehouse(Tool tool){
        //TODO: Werkzeug aus Lager nehmen und übergeben
        // TODO: Wird ein Werkzeug vom Lager in die Station gebracht, darf es nicht mehr im Lager liegen -> TEST (gehört zur Company)
        return tool;
    }

    // TODO: Method aus der Company hier eingefügt - muss angepasst werden
    public Tool findToolInStockOfCompany( Tool tool){
        for (Tool foundedTool : this.getStock()) {
            if (foundedTool.equals(tool)) {
                if(foundedTool.getToolStatus() == ToolStatus.AVAILABLE) {
                    return foundedTool;
                }
            }
        }
        return null;
    }





}
