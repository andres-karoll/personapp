package co.edu.javeriana.as.personapp.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Persona {
	private Integer cc;
	private String nombre;
	private String apellido;
	private Genero genero;
	private Integer edad;
	private List<Telefono> telefonos;
	private List<Estudio> estudios;
	public Persona(Integer cc, String nombre, String apellido, Genero genero, Integer edad) {
		super();
		this.cc = cc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.telefonos = new ArrayList<Telefono>();
		this.estudios = new ArrayList<Estudio>();;
	}
	public Persona() {
		super();
		this.cc = 0;
		this.nombre = "";
		this.apellido = "";
		this.genero = genero.MASCULINO;
		this.edad = 0;
		this.telefonos = new ArrayList<Telefono>();
		this.estudios = new ArrayList<Estudio>();;
	}
	public Persona(Integer cc, String nombre, String apellido, Genero genero, Integer edad, List<Telefono> telefonos,
			List<Estudio> estudios) {
		super();
		this.cc = cc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.telefonos = telefonos;
		this.estudios = estudios;
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
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public List<Estudio> getEstudios() {
		return estudios;
	}
	public void setEstudios(List<Estudio> estudios) {
		this.estudios = estudios;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, cc, edad, estudios, genero, nombre, telefonos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(cc, other.cc)
				&& Objects.equals(edad, other.edad) && Objects.equals(estudios, other.estudios)
				&& genero == other.genero && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefonos, other.telefonos);
	}
	@Override
	public String toString() {
		return "Persona [cc=" + cc + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", edad="
				+ edad + ", telefonos=" + telefonos + ", estudios=" + estudios + "]";
	}
	
	

}
