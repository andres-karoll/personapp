package co.edu.javeriana.as.personapp.mysql.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "estudios")
@Entity
@XmlRootElement
public class EstudiosEntity {
	
	    @EmbeddedId
	    protected EstudiosPKEntity estudiosPK;
	    @Temporal(TemporalType.DATE)
	    private Date fecha;
	    @Size(max = 50)
	    @Column(length = 50)
	    private String univer;
	    @JoinColumn(name = "cc_per", referencedColumnName = "cc", nullable = false, insertable = false, updatable = false)
	    @ManyToOne(optional = false)
	    private PersonaEntity persona;
	    @JoinColumn(name = "id_prof", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	    @ManyToOne(optional = false)
	    private ProfesionEntity profesion;

	    public EstudiosEntity() {
	    }

	    public EstudiosEntity(EstudiosPKEntity estudiosPK) {
	        this.estudiosPK = estudiosPK;
	    }

	    public EstudiosEntity(int idProf, int ccPer) {
	        this.estudiosPK = new EstudiosPKEntity(idProf, ccPer);
	    }

	    public EstudiosPKEntity getEstudiosPK() {
	        return estudiosPK;
	    }

	    public void setEstudiosPK(EstudiosPKEntity estudiosPK) {
	        this.estudiosPK = estudiosPK;
	    }

	    public Date getFecha() {
	        return fecha;
	    }

	    public void setFecha(Date fecha) {
	        this.fecha = fecha;
	    }

	    public String getUniver() {
	        return univer;
	    }

	    public void setUniver(String univer) {
	        this.univer = univer;
	    }

	    public PersonaEntity getPersona() {
	        return persona;
	    }

	    public void setPersona(PersonaEntity persona) {
	        this.persona = persona;
	    }

	    public ProfesionEntity getProfesion() {
	        return profesion;
	    }

	    public void setProfesion(ProfesionEntity profesion) {
	        this.profesion = profesion;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (estudiosPK != null ? estudiosPK.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof EstudiosEntity)) {
	            return false;
	        }
	        EstudiosEntity other = (EstudiosEntity) object;
	        if ((this.estudiosPK == null && other.estudiosPK != null) || (this.estudiosPK != null && !this.estudiosPK.equals(other.estudiosPK))) {
	            return false;
	        }
	        return true;
	    }


}
