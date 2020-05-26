package de.rat.model;

import de.rat.model.common.Date;
import javax.persistence.*;

/**Represents a BaseModel which provides some basic attributes for all classes thad will be mapped.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */

public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @PrePersist
    void onCreate(){
        this.setCreated(new Date());
    }

    @PreUpdate
    void onUpdate(){
        this.setModified(new Date());
    }

}
