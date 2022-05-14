package co.edu.javeriana.as.personapp.api.model.response;

import co.edu.javeriana.as.personapp.api.model.request.TelefonoApiRequest;

public class TelefonoApiResponse extends TelefonoApiRequest {
    private String status;

    public TelefonoApiResponse(String num, String oper, int ccDuenio, String status) {
        super(num, oper, ccDuenio);
        this.status = status;
    }

    public TelefonoApiResponse() {
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
