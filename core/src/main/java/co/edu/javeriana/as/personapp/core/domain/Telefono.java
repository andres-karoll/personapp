package co.edu.javeriana.as.personapp.core.domain;

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

    //Hash and equals

    //To String
}
