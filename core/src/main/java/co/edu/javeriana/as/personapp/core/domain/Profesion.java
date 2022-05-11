package co.edu.javeriana.as.personapp.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profesion {
    //Attributes
    private Integer id;
    private String nom;
    private String des;
    private List<Estudio> estudios;

    //Constructors


    public Profesion() {
        this.id = 0;
        this.nom = "";
        this.des = "";
        this.estudios = new ArrayList<Estudio>();
    }

    public Profesion(Integer id) {
        this.id = id;
        this.nom = "";
        this.des = "";
        this.estudios = new ArrayList<Estudio>();
    }

    public Profesion(Integer id, String nom, String des) {
        this.id = id;
        this.nom = nom;
        this.des = des;
    }

    public Profesion(Integer id, String nom, String des, List<Estudio> estudios) {
        this.id = id;
        this.nom = nom;
        this.des = des;
        this.estudios = estudios;
    }

    //Getters and Setters

    //Hash and equals

    //To String

}
