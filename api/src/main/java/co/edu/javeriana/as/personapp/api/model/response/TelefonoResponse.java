package co.edu.javeriana.as.personapp.api.model.response;

import co.edu.javeriana.as.personapp.api.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.core.domain.Telefono;

public class TelefonoResponse extends TelefonoRequest {
    private String status;

    public TelefonoResponse(String num, String oper, int ccDuenio, String status) {
        super(num, oper, ccDuenio);
        this.status = status;
    }

    public TelefonoResponse() {
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
