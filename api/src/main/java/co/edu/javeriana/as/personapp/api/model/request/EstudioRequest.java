package co.edu.javeriana.as.personapp.api.model.request;

import java.time.LocalDate;

public class EstudioRequest {
    private Integer idProfesion;
    private Integer ccPersona;
    private String fecha;
    private String universidad;

    public EstudioRequest() {
    }
    public EstudioRequest(Integer idProfesion, Integer ccPersona, String fecha, String universidad, String profesion) {
        this.idProfesion = idProfesion;
        this.ccPersona = ccPersona;
        this.fecha = fecha;
        this.universidad = universidad;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

}
