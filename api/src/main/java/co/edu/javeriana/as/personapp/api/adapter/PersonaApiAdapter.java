package co.edu.javeriana.as.personapp.api.adapter;

import co.edu.javeriana.as.personapp.api.mapper.PersonaApiMapper;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.usecase.PersonaModificacionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.api.model.request.PersonaApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaApiResponse;
import co.edu.javeriana.as.personapp.api.port.in.PersonaApiPort;
import co.edu.javeriana.as.personapp.core.usecase.PersonaConsultaUseCase;

import java.util.List;

@Component
public class PersonaApiAdapter implements PersonaApiPort {

	@Autowired
	private PersonaApiMapper personaApiMapper;
	@Autowired
	private PersonaConsultaUseCase personaConsultaUseCase;
	@Autowired
	private PersonaModificacionUseCase personaModificacionUseCase;


	@Override
	public List<Persona> buscarPersonas() {
		List<Persona> personas = personaConsultaUseCase.buscarTodo();
		return personas;
	}

	@Override
	public Persona buscarPersonaPorId(int cc) {
		return personaConsultaUseCase.buscarPorId(cc);
	}

	@Override
	public int contarPersonas() {
		return personaConsultaUseCase.contar();
	}

	@Override
	public PersonaApiResponse crearPersona(PersonaApiRequest request) {
		Persona newPersona = personaModificacionUseCase.crear(personaApiMapper.dePersonaRequestAPersona(request));
		return personaApiMapper.dePersonaAPersonaResponse(newPersona);
	}

	@Override
	public boolean eliminarPersona(int cc) {
		return personaModificacionUseCase.eliminar(cc);
	}


}
