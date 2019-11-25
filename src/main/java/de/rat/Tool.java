package de.rat;

public class Tool {
    private short toolId;
    private short itemId;
    private short manufacturerId;
    private String description;
    private String category;
    private String stock;
    private String toolStatus;
    private double rentPrice;

    public Tool(short toolId, short itemId, short manufacturerId, String description,
                String category, String stock, String toolStatus, double rentPrice)
    {
        this.toolId = toolId;
        this.itemId = itemId;
        this.manufacturerId = manufacturerId;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.toolStatus = toolStatus;
        this.rentPrice = rentPrice;
    }


    public short getToolId() {
        return toolId;
    }

    public void setToolId(short toolId) {
        this.toolId = toolId;
    }

    public short getItemId() {
        return itemId;
    }

    public void setItemId(short itemId) {
        this.itemId = itemId;
    }

    public short getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(short manufacturerId) {
        this.manufacturerId = manufacturerId;
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

    public String getToolStatus() {
        return toolStatus;
    }

    public void setToolStatus(String toolStatus) {
        this.toolStatus = toolStatus;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }
}
