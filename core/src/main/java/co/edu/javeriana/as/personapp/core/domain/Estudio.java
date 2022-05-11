package co.edu.javeriana.as.personapp.core.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Estudio {
    //Attributes
    private Integer idProfesion;
    private Integer ccPersona;
    private LocalDate fecha;
    private String universidad;
    private Profesion profesion;
    private Persona persona;


    //Constructors

    public Estudio() {
        this.idProfesion = 0;
        this.ccPersona = 0;
        this.fecha = LocalDate.now();
        this.universidad = "";
        this.profesion = new Profesion();
        this.persona = new Persona();
    }

    public Estudio(Integer idProfesion, Integer ccPersona) {
        this.idProfesion = idProfesion;
        this.ccPersona = ccPersona;
        this.fecha = LocalDate.now();
        this.universidad = " ";
        this.profesion = new Profesion();
        this.persona = new Persona();
    }

    public Estudio(Integer idProfesion, Integer ccPersona, LocalDate fecha, String universidad) {
        this.idProfesion = idProfesion;
        this.ccPersona = ccPersona;
        this.fecha = fecha;
        this.universidad = universidad;
    }

    public Estudio(Integer idProfesion, Integer ccPersona, LocalDate fecha, String universidad, Profesion profesion, Persona persona) {
        this.idProfesion = idProfesion;
        this.ccPersona = ccPersona;
        this.fecha = fecha;
        this.universidad = universidad;
        this.profesion = profesion;
        this.persona = persona;
    }

    //Getters and Setters

    //Hash and equals

    //To String
}
