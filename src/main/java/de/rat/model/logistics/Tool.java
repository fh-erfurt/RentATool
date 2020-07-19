package de.rat.model.logistics;

import de.rat.model.BaseModel;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**Represents a class tool.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */


/** Creates a tool .
 *  itemId this is a ID that comes from the manufacturer. Like this: A120-B20W
 *  manufacturer from the tool
 *  description
 *  category a enum with the entry ELECTRICALTOOL, ACCUTOOL, HANDTOOL, GARDENTOOL
 *  toolStatus a enum with the entry  AVAILABLE, ISRENTED, ISBROKEN, ISINREPAIR;
 *  rentPrice the several rent price for the tool
 *
 */
@Entity
public class Tool extends BaseModel {

    private String itemId;
    @ManyToOne
    private Manufacturer manufacturer;
    private String description;
    private Category category;
    private String stock;
    private ToolStatus toolStatus;
    private BigDecimal rentPrice;
    public Tool(){};

    /** constructor for a tool .
     *  @param itemId this is a ID that comes from the manufacturer. Like this: A120-B20W
     *  @param manufacturer from the tool
     *  @param description
     *  @param category a enum with the entry ELECTRICALTOOL, ACCUTOOL, HANDTOOL, GARDENTOOL
     *  @param stock this is the storageplace in the warehouse
     *  @param toolStatus a enum with the entry  AVAILABLE, ISRENTED, ISBROKEN, ISINREPAIR;
     *  @param rentPrice the several rent price for the tool
     *
     */
    public Tool(String itemId, Manufacturer manufacturer, String description,Category category,String stock, ToolStatus toolStatus, BigDecimal rentPrice) {
        this.itemId = itemId;
        this.manufacturer = manufacturer;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.toolStatus = toolStatus;
        this.rentPrice = rentPrice;
    }

    // TODO: delete???
    //erstmal nur Test
    public Tool(String itemId, String description,Category category,String stock, ToolStatus toolStatus, BigDecimal rentPrice) {
        this.itemId = itemId;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.toolStatus = toolStatus;
        this.rentPrice = rentPrice;
}

     /** get the manufacturer for a tool .
     *  @return  manufacturer this is a ID that comes from the manufacturer
     *
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }


    /** set the manufacturer for a tool .
     *  @param  manufacturer this is a ID that comes from the manufacturer
     *
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


    /** get the description for a tool .
     *  @return  description this is a the respective description
     *
     */
    public String getDescription() {
        return description;
    }


    /** set the description for a tool .
     *  @param  description this is a the respective description
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /** get the category for a tool .
     *  @return  category this is a the respective category
     *
     */
    public Category getCategory() {
        return category;
    }


    /** set the category for a tool .
     *  @param  category this is a the respective description
     *
     */
    public void setCategory(Category category) {
        this.category = category;
    }


    /** get the stock for a tool
     *  @return  stock this is a the respective stock
     *
     */
    public String getStock() {
        return stock;
    }


    /** get the tool status for a tool .
     *  @return  toolStatus this is a the respective tool status
     *  enum AVAILABLE, ISRENTED, ISBROKEN, ISINREPAIR;
     *
     */
    public ToolStatus getToolStatus() { return toolStatus;
    }


    /** set the tool status for a tool .
     *  @param  toolStatus this is a the respective tool status
     *  enum AVAILABLE, ISRENTED, ISBROKEN, ISINREPAIR;
     *
     */
    public void setToolStatus(ToolStatus toolStatus) {
        this.toolStatus = toolStatus;
    }


    /** get the rent prices for a tool .
     *  @return rentPrice this is a the respective rent price
     *
     */
    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }
}
