package de.rat.model;

import javax.persistence.*;
import java.util.Date;

/**Represents a BaseModel which provides some basic attributes for all classes thad will be mapped to the database.
 * @author Danny Steinbrecher, Marco Petzold, Christian König
 */

@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @PrePersist
    void onCreate(){
        this.setCreated(new Date());
    }

    @PreUpdate
    void onUpdate(){
        this.setModified(new Date());
    }

    public void setCreated(Date created) {this.created = created;}
    public void setModified(Date modified) {this.modified = modified;}

    public Date getCreated() {return created;}
    public Date getModified() {return modified;}

    public int getId() {return id;}

    public void setId(int Id){
        this.id=Id;
    }

}
