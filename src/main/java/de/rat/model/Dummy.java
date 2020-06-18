package de.rat.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import de.rat.model.common.DateRat;

import javax.persistence.*;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
public class Dummy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;



    protected Dummy(){}

    public Dummy(String name){
        this.name = name;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[firstName='%s']",
                this.created.getTime());
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Date getCreated(){return  this.created;}

    @PrePersist
    void onCreate() { this.setCreated( new DateRat() ); }
}
