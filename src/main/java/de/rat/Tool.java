package de.rat;

public class Tool {
    private String itemId; // this is a ID that comes from the manufacturer. Like this: A120-B20W
    private Manufacturer manufacturer;
    private String description;
    private String category;    // TODO: enum(elctro, akku, gas, manual)
    private String stock;   // delete
    private ToolStatus toolStatus;     // TODO: Enum (available, isRented, isBroken, isInRepair)
    private double rentPrice;

    public Tool(String itemId, Manufacturer manufacturer, String description, String category, String stock, ToolStatus toolStatus, double rentPrice) {
        this.itemId = itemId;
        this.manufacturer = manufacturer;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.toolStatus = toolStatus;
        this.rentPrice = rentPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public ToolStatus getToolStatus() { return toolStatus;
    }

    public void setToolStatus(ToolStatus toolStatus) {
        this.toolStatus = toolStatus;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }


    // Methods ---

}
