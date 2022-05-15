package co.edu.javeriana.as.personapp.mysql.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Table(name = "persona")
@Entity
@XmlRootElement
public class PersonaEntity {
	
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Column(nullable = false)
	    private Integer cc;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(nullable = false, length = 45)
	    private String nombre;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(nullable = false, length = 45)
	    private String apellido;
	    @Basic(optional = false)
	    @NotNull
	    @Column(nullable = false)
	    private Character genero;
	    private Integer edad;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duenio")
	    private List<TelefonoEntity> telefonoList;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	    private List<EstudiosEntity> estudiosList;

	    public PersonaEntity() {
	    }

	    public PersonaEntity(Integer cc) {
	        this.cc = cc;
	    }

	    public PersonaEntity(Integer cc, String nombre, String apellido, Character genero) {
	        this.cc = cc;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.genero = genero;
	    }

	    public Integer getCc() {
	        return cc;
	    }

	    public void setCc(Integer cc) {
	        this.cc = cc;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public Character getGenero() {
	        return genero;
	    }

	    public void setGenero(Character genero) {
	        this.genero = genero;
	    }

	    public Integer getEdad() {
	        return edad;
	    }

	    public void setEdad(Integer edad) {
	        this.edad = edad;
	    }

	    @XmlTransient
	    public List<TelefonoEntity> getTelefonoList() {
	        return telefonoList;
	    }

	    public void setTelefonoList(List<TelefonoEntity> telefonoList) {
	        this.telefonoList = telefonoList;
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
	        hash += (cc != null ? cc.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof PersonaEntity)) {
	            return false;
	        }
	        PersonaEntity other = (PersonaEntity) object;
	        if ((this.cc == null && other.cc != null) || (this.cc != null && !this.cc.equals(other.cc))) {
	            return false;
	        }
	        return true;
	    }

}
