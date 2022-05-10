package co.edu.javeriana.as.personapp.core.domain;

import java.util.ArrayList;
import java.util.Date;

public class Estudio {
    //Attributes
    private Integer id;
    private Integer ccPer;
    private Date fecha;
    private String univer;

    //Constructors
    public Estudio() {
        super();
        this.id = 0;
        this.ccPer = 0;
        this.fecha = new Date();
        this.univer = "";
    }

    public Estudio(Integer id, Integer ccPer, Date fecha, String univer) {
        super();
        this.id = id;
        this.ccPer = ccPer;
        this.fecha = fecha;
        this.univer = univer;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCcPer() {
        return ccPer;
    }

    public void setCcPer(Integer ccPer) {
        this.ccPer = ccPer;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUniver() {
        return univer;
    }

    public void setUniver(String univer) {
        this.univer = univer;
    }


}
