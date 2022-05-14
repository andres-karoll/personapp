package co.edu.javeriana.as.personapp.api.model.response;

import co.edu.javeriana.as.personapp.api.model.request.EstudioApiRequest;

public class EstudioApiResponse extends EstudioApiRequest {

    private String status;

    public EstudioApiResponse(Integer idProfesion, Integer ccPersona, String fecha, String universidad, String profesion, String status) {
        super(idProfesion, ccPersona, fecha, universidad, profesion);
        this.status = status;
    }

    public EstudioApiResponse() {
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
