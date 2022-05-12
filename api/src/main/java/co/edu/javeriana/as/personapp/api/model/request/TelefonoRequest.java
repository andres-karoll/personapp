package co.edu.javeriana.as.personapp.api.model.request;

public class TelefonoRequest {
    private String num;
    private String oper;
    private int ccDuenio;

    public TelefonoRequest() {
    }

    public TelefonoRequest(String num, String oper, int ccDuenio) {
        this.num = num;
        this.oper = oper;
        this.ccDuenio = ccDuenio;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public int getCcDuenio() {
        return ccDuenio;
    }

    public void setCcDuenio(int ccDuenio) {
        this.ccDuenio = ccDuenio;
    }
}

