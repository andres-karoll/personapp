package co.edu.javeriana.as.personapp.mongo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.edu.javeriana.as.personapp.core.domain.Persona;

@Document("TelefonoDocument")
public class TelefonoDocument {
    @Id
    private String num;
    private String oper;
    private Persona duenio;
    public TelefonoDocument(String num, String oper, Persona duenio) {
        this.num = num;
        this.oper = oper;
        this.duenio = duenio;
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
    public Persona getDuenio() {
        return duenio;
    }
    public void setDuenio(Persona duenio) {
        this.duenio = duenio;
    }


    
}
