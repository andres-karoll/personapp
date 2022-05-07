package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.model.request.CrearPersonaRequest;
import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Persona;

public class PersonaMapper {
	
	public Persona deCrearPersonaRequestAPersona(CrearPersonaRequest request){
		return new Persona(Integer.parseInt(request.getDni()),request.getFirstName(),request.getLastName(),Genero.MASCULINO,Integer.parseInt(request.getAge()));
	}

}
