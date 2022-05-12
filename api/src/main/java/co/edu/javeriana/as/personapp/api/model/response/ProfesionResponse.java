package co.edu.javeriana.as.personapp.api.model.response;

import co.edu.javeriana.as.personapp.api.model.request.ProfesionRequest;

public class ProfesionResponse extends ProfesionRequest {

    private String status;

    public ProfesionResponse(Integer id, String nom, String des, String status) {
        super(id, nom, des);
        this.status = status;
    }

    public ProfesionResponse() {
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
