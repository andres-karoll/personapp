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


	//Constructors


	public Persona() {
		this.cc = 0;
		this.nombre = "";
		this.apellido = "";
		this.genero = Genero.MASCULINO;
		this.edad = 0;
		this.telefonos = new ArrayList<Telefono>();
		this.estudios = new ArrayList<Estudio>();
	}

	public Persona(Integer cc) {
		this.cc = cc;
		this.nombre = "";
		this.apellido = "";
		this.genero = Genero.MASCULINO;
		this.edad = 0;
		this.telefonos = new ArrayList<Telefono>();
		this.estudios = new ArrayList<Estudio>();
	}

	public Persona(Integer cc, String nombre, String apellido, Genero genero, Integer edad) {
		this.cc = cc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
	}

	public Persona(Integer cc, String nombre, String apellido, Genero genero, Integer edad, List<Telefono> telefonos, List<Estudio> estudios) {
		this.cc = cc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.telefonos = telefonos;
		this.estudios = estudios;
	}

	//Getters and Setters
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

	//Hash and equals
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Persona persona = (Persona) o;
		return Objects.equals(cc, persona.cc) && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && genero == persona.genero && Objects.equals(edad, persona.edad) && Objects.equals(telefonos, persona.telefonos) && Objects.equals(estudios, persona.estudios);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cc, nombre, apellido, genero, edad, telefonos, estudios);
	}

	//To String


	@Override
	public String toString() {
		return "Persona{" +
				"cc=" + cc +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", genero=" + genero +
				", edad=" + edad +
				", telefonos=" + telefonos +
				", estudios=" + estudios +
				'}';
	}
}
