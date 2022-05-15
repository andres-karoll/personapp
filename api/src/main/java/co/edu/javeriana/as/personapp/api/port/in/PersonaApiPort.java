package co.edu.javeriana.as.personapp.api.port.in;

import co.edu.javeriana.as.personapp.api.model.request.PersonaApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Persona;

import java.util.List;

public interface PersonaApiPort {
	
	public List<Persona> buscarPersonas();
	public Persona buscarPersonaPorId(int cc);
	public int contarPersonas();
	public PersonaApiResponse crearPersona(PersonaApiRequest request);
	public boolean eliminarPersona(int cc);

}
