package co.edu.javeriana.as.personapp.core.usecase;

import java.util.List;

import co.edu.javeriana.as.personapp.core.domain.Persona;

public interface PersonaConsultaUseCase {
	
	public Persona buscarPorId(Integer cc);
	
	public List<Persona> buscarTodo();
	
	public Integer contar();
	

}
