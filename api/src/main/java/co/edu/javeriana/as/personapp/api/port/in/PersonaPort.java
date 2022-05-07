package co.edu.javeriana.as.personapp.api.port.in;

import co.edu.javeriana.as.personapp.api.model.request.CrearPersonaRequest;
import co.edu.javeriana.as.personapp.api.model.response.CrearPersonaResponse;

public interface PersonaPort {
	
	public CrearPersonaResponse create(CrearPersonaRequest request);

}
