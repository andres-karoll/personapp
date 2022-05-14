package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.model.request.PersonaApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Persona;

public class PersonaApiMapper {
	
	public PersonaApiResponse dePersonaAPersonaResponse(Persona request){
		return new PersonaApiResponse(request.getCc().toString(),request.getNombre(),request.getApellido(), request.getEdad().toString(), request.getGenero().toString(), "OK");
	}
	public Persona dePersonaRequestAPersona(PersonaApiRequest request){
		return new Persona(Integer.parseInt(request.getDni()),request.getFirstName(),request.getLastName(),Genero.MASCULINO,Integer.parseInt(request.getAge()));
	}

}
