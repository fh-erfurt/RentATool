package de.rat.logistics;

import java.util.ArrayList;

public class Warehouse {
    private ArrayList<Tool> Stock= new ArrayList<Tool>();

    public Warehouse() {
    }

    public ArrayList<Tool> getStock() {
        return Stock;
    }

    public boolean putToolInWarehouse(Tool tool){

        if(tool !=null)
        {
            this.Stock.add(tool);
            return true;
        }
        return false;
    }

    public Tool removeToolFromWarehouse(Tool tool){

        for (Tool foundedTool : Stock)
        {
            if(foundedTool.equals(tool))
            {
                if(foundedTool.getToolStatus() == ToolStatus.AVAILABLE) {
                    Stock.remove(tool);
                    return tool;
                }
            }
        }
        System.out.println("Werkzeug nicht im Lager vorhanden");
        return null;

    }


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
        System.out.println("Werkzeug nicht im Lager vorhanden");
        return false;
    }





}
