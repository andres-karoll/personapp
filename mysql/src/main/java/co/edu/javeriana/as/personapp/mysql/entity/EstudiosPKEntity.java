package co.edu.javeriana.as.personapp.mysql.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class EstudiosPKEntity {
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_prof", nullable = false)
    private int idProf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cc_per", nullable = false)
    private int ccPer;

    public EstudiosPKEntity() {
    }

    public EstudiosPKEntity(int idProf, int ccPer) {
        this.idProf = idProf;
        this.ccPer = ccPer;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getCcPer() {
        return ccPer;
    }

    public void setCcPer(int ccPer) {
        this.ccPer = ccPer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProf;
        hash += (int) ccPer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EstudiosPKEntity)) {
            return false;
        }
        EstudiosPKEntity other = (EstudiosPKEntity) object;
        if (this.idProf != other.idProf) {
            return false;
        }
        if (this.ccPer != other.ccPer) {
            return false;
        }
        return true;
    }


}
