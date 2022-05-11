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

    public List<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }

    //Hash and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesion profesion = (Profesion) o;
        return Objects.equals(id, profesion.id) && Objects.equals(nom, profesion.nom) && Objects.equals(des, profesion.des) && Objects.equals(estudios, profesion.estudios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, des, estudios);
    }

    //To String


    @Override
    public String toString() {
        return "Profesion{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", des='" + des + '\'' +
                ", estudios=" + estudios +
                '}';
    }
}
