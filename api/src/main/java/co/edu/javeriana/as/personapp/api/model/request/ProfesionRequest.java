package co.edu.javeriana.as.personapp.api.model.request;

public class ProfesionRequest{
    private Integer id;
    private String nom;
    private String des;

    public ProfesionRequest(){}

    public ProfesionRequest(Integer id, String nom, String des) {
        this.id = id;
        this.nom = nom;
        this.des = des;
    }

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
}
