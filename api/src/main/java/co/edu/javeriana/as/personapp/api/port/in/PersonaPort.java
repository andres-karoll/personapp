package co.edu.javeriana.as.personapp.api.port.in;

import co.edu.javeriana.as.personapp.api.model.request.PersonaRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaResponse;
import co.edu.javeriana.as.personapp.core.domain.Persona;

import java.util.List;

public interface PersonaPort {
	
	public List<Persona> buscarPersonas();
	public Persona buscarPersonaPorId(int cc);
	public int contarPersonas();
	public PersonaResponse crearPersona(PersonaRequest request);
	public boolean eliminarPersona(int cc);

}
