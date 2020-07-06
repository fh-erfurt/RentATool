package de.rat.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class Dummy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    private BigDecimal bigDecimalPrice;

    public Dummy(){}

    public Dummy(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[firstName='%s']",
                this.birthday);
    }


    private Date created;

    public Date getCreated(){return  this.created;}

    @PrePersist
    void onCreate() { this.setCreated( new Date() ); }

    private LocalDate birthday;

}
