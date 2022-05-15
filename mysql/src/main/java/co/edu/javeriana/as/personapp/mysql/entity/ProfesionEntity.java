package co.edu.javeriana.as.personapp.mysql.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Table(name = "profesion")
@Entity
@XmlRootElement
public class ProfesionEntity {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(nullable = false, length = 90)
    private String nom;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String des;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesion")
    private List<EstudiosEntity> estudiosList;

    public ProfesionEntity() {
    }

    public ProfesionEntity(Integer id) {
        this.id = id;
    }

    public ProfesionEntity(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
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

    @XmlTransient
    public List<EstudiosEntity> getEstudiosList() {
        return estudiosList;
    }

    public void setEstudiosList(List<EstudiosEntity> estudiosList) {
        this.estudiosList = estudiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesionEntity)) {
            return false;
        }
        ProfesionEntity other = (ProfesionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
	

}
