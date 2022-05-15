package co.edu.javeriana.as.personapp.mysql.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByNum", query = "SELECT t FROM Telefono t WHERE t.num = :num"),
    @NamedQuery(name = "Telefono.findByOper", query = "SELECT t FROM Telefono t WHERE t.oper = :oper")})

public class TelefonoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String num;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String oper;
    @JoinColumn(name = "duenio", referencedColumnName = "cc", nullable = false)
    @ManyToOne(optional = false)
    private PersonaEntity duenio;

    public TelefonoEntity() {
    }

    public TelefonoEntity(String num) {
        this.num = num;
    }

    public TelefonoEntity(String num, String oper) {
        this.num = num;
        this.oper = oper;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public PersonaEntity getDuenio() {
        return duenio;
    }

    public void setDuenio(PersonaEntity duenio) {
        this.duenio = duenio;
    }


}
