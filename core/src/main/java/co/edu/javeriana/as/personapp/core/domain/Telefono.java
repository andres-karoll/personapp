package co.edu.javeriana.as.personapp.core.domain;

import java.util.Objects;

public class Telefono {
    private String num;
    private String oper;
    private Persona duenio;

    //Constructors

    public Telefono() {
        this.num = num;
        this.oper = "";
        this.duenio = new Persona();
    }

    public Telefono(String num) {
        this.num = num;
        this.oper = "";
        this.duenio = new Persona();
    }

    public Telefono(String num, String oper) {
        this.num = num;
        this.oper = oper;
    }

    public Telefono(String num, String oper, Persona duenio) {
        this.num = num;
        this.oper = oper;
        this.duenio = duenio;
    }

    //Getters and Setters
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

    //Hash and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(num, telefono.num) && Objects.equals(oper, telefono.oper) && Objects.equals(duenio, telefono.duenio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, oper, duenio);
    }


    //To String

    @Override
    public String toString() {
        return "Telefono{" +
                "num='" + num + '\'' +
                ", oper='" + oper + '\'' +
                ", duenio=" + duenio +
                '}';
    }
}
