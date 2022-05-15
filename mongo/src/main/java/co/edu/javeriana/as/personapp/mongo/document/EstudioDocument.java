package co.edu.javeriana.as.personapp.mongo.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Profesion;
@Document("EstudioDocument")
public class EstudioDocument {
    @Id
    private Integer idProfesion;
    @Id
    private Integer ccPersona;
    private LocalDate fecha;
    private String universidad;
    private Profesion profesion;
    private Persona persona;
    public EstudioDocument(Integer idProfesion, Integer ccPersona, LocalDate fecha, String universidad,
            Profesion profesion, Persona persona) {
        this.idProfesion = idProfesion;
        this.ccPersona = ccPersona;
        this.fecha = fecha;
        this.universidad = universidad;
        this.profesion = profesion;
        this.persona = persona;
    }
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


    
}
