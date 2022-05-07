package co.edu.javeriana.as.personapp.core.usecase;

import java.util.List;

import co.edu.javeriana.as.personapp.core.domain.Persona;

public interface PersonaModificacionUseCase {
	
	public Persona crear(Persona persona);
	
	public Persona editar(Integer cc, Persona persona);
	
	public Boolean eliminar(Integer cc);
	

}
