package co.edu.javeriana.as.personapp.api.model.response;

import co.edu.javeriana.as.personapp.api.model.request.ProfesionApiRequest;

public class ProfesionApiResponse extends ProfesionApiRequest {

    private String status;

    public ProfesionApiResponse(Integer id, String nom, String des, String status) {
        super(id, nom, des);
        this.status = status;
    }

    public ProfesionApiResponse() {
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
