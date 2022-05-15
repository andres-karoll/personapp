package co.edu.javeriana.as.personapp.mongo.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
@Document("ProfesionDocument")
public class ProfesionDocument {
    
    @Id
    private Integer id;
    private String nom;
    private String des;
    private List<Estudio> estudios;
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


    
}
