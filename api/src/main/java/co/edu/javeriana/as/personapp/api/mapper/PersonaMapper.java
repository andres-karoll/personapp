package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.model.request.PersonaRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaResponse;
import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Persona;

public class PersonaMapper {
	
	public PersonaResponse dePersonaAPersonaResponse(Persona request){
		return new PersonaResponse(request.getCc().toString(),request.getNombre(),request.getApellido(), request.getEdad().toString(), request.getGenero().toString(), "OK");
	}
	public Persona dePersonaRequestAPersona(PersonaRequest request){
		return new Persona(Integer.parseInt(request.getDni()),request.getFirstName(),request.getLastName(),Genero.MASCULINO,Integer.parseInt(request.getAge()));
	}

}
