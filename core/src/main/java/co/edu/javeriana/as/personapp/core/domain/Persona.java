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

	//Hash and equals

	//To String
	
	

}
