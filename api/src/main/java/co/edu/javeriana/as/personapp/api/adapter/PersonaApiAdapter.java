package co.edu.javeriana.as.personapp.api.adapter;

import co.edu.javeriana.as.personapp.api.mapper.PersonaApiMapper;
import co.edu.javeriana.as.personapp.api.model.request.PersonaApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaApiResponse;
import co.edu.javeriana.as.personapp.api.port.in.PersonaApiPort;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.usecase.PersonaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonaApiAdapter implements PersonaApiPort {

	@Autowired
	private PersonaApiMapper personaApiMapper;
	@Autowired
	private PersonaUseCase personaUseCase;

	@Override
	public List<Persona> buscarPersonas() {
		List<Persona> personas = personaUseCase.buscarTodo();
		return personas;
	}

	@Override
	public Persona buscarPersonaPorId(int cc) {
		return personaUseCase.buscarPorId(cc);
	}

	@Override
	public int contarPersonas() {
		return personaUseCase.contar();
	}

	@Override
	public PersonaApiResponse crearPersona(PersonaApiRequest request) {
		Persona newPersona = personaUseCase.crear(personaApiMapper.dePersonaRequestAPersona(request));
		return personaApiMapper.dePersonaAPersonaResponse(newPersona);
	}

	@Override
	public boolean eliminarPersona(int cc) {
		return personaUseCase.eliminar(cc);
	}


}
