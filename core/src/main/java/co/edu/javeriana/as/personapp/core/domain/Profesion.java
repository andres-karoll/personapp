package co.edu.javeriana.as.personapp.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Profesion {
    //Attributes
    private Integer id;
    private String nom;
    private String des;
    private List<Telefono> telefonos;

    //Constructors

    public Profesion() {
        this.id = 0;
        this.nom = "";
        this.des = "";
        this.telefonos = new ArrayList<Telefono>();
    }

    public Profesion(Integer id, String nom, String des) {
        this.id = id;
        this.nom = nom;
        this.des = des;
        this.telefonos = new ArrayList<Telefono>();
    }

    public Profesion(Integer id, String nom, String des, List<Telefono> telefonos) {
        this.id = id;
        this.nom = nom;
        this.des = des;
        this.telefonos = telefonos;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
}
