package de.rat.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import de.rat.model.common.Date;
import javax.persistence.*;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
public class Dummy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date created;

    protected Dummy(){}

    public Dummy(String name){
        this.name = name;
    };

    public String getName() {
        return name;
    }


    public String getCreated(){

        return  this.created.toString();

    }

    @Override
    public String toString() {
        return String.format(
                "Customer[firstName='%s']",
                this.created.getTime());
    }
}
