package co.edu.javeriana.as.personapp.api.model.response;

import co.edu.javeriana.as.personapp.api.model.request.EstudioRequest;

import java.time.LocalDate;

public class EstudioResponse extends EstudioRequest {

    private String status;

    public EstudioResponse(Integer idProfesion, Integer ccPersona, String fecha, String universidad, String profesion, String status) {
        super(idProfesion, ccPersona, fecha, universidad, profesion);
        this.status = status;
    }

    public EstudioResponse() {
        super();
        this.status = "";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
