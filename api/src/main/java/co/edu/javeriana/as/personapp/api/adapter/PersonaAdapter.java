package co.edu.javeriana.as.personapp.api.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.api.model.request.CrearPersonaRequest;
import co.edu.javeriana.as.personapp.api.model.response.CrearPersonaResponse;
import co.edu.javeriana.as.personapp.api.port.in.PersonaPort;
import co.edu.javeriana.as.personapp.core.usecase.PersonaConsultaUseCase;

@Component
public class PersonaAdapter implements PersonaPort{
	
	@Autowired
	private PersonaConsultaUseCase personaService;

	@Override
	public CrearPersonaResponse create(CrearPersonaRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
