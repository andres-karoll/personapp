package co.edu.javeriana.as.personapp.core.domain;

import java.util.ArrayList;
import java.util.Date;

public class Estudio {
    private Integer id;
    private Integer ccPer;
    private Date fecha;
    private String univer;

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
}
