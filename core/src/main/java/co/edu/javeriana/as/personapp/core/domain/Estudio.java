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
    public Integer getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }

    public Integer getCcPersona() {
        return ccPersona;
    }

    public void setCcPersona(Integer ccPersona) {
        this.ccPersona = ccPersona;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    //Hash and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudio estudio = (Estudio) o;
        return Objects.equals(idProfesion, estudio.idProfesion) && Objects.equals(ccPersona, estudio.ccPersona) && Objects.equals(fecha, estudio.fecha) && Objects.equals(universidad, estudio.universidad) && Objects.equals(profesion, estudio.profesion) && Objects.equals(persona, estudio.persona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfesion, ccPersona, fecha, universidad, profesion, persona);
    }

    //To String

    @Override
    public String toString() {
        return "Estudio{" +
                "idProfesion=" + idProfesion +
                ", ccPersona=" + ccPersona +
                ", fecha=" + fecha +
                ", universidad='" + universidad + '\'' +
                ", profesion=" + profesion +
                ", persona=" + persona +
                '}';
    }
}
