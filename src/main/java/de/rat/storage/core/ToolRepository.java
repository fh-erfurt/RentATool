package de.rat.storage.core;
import de.rat.model.logistics.Manufacturer;
import de.rat.model.logistics.Tool;



public abstract class ToolRepository extends Repository<Tool> {
    @Override
    protected void updateOperation(Tool model, String description) {
        model.setDescription(description);

    }

}
