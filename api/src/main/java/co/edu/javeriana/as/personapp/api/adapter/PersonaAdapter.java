package co.edu.javeriana.as.personapp.api.adapter;

import co.edu.javeriana.as.personapp.api.mapper.PersonaMapper;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.usecase.PersonaModificacionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.api.model.request.PersonaRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaResponse;
import co.edu.javeriana.as.personapp.api.port.in.PersonaPort;
import co.edu.javeriana.as.personapp.core.usecase.PersonaConsultaUseCase;

import java.util.List;

@Component
public class PersonaAdapter implements PersonaPort{

	@Autowired
	private PersonaMapper personaMapper;
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
	public PersonaResponse crearPersona(PersonaRequest request) {
		Persona newPersona = personaModificacionUseCase.crear(personaMapper.dePersonaRequestAPersona(request));
		return personaMapper.dePersonaAPersonaResponse(newPersona);
	}

	@Override
	public boolean eliminarPersona(int cc) {
		return personaModificacionUseCase.eliminar(cc);
	}


}
