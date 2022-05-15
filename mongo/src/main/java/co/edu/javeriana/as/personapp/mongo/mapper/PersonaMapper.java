package co.edu.javeriana.as.personapp.mongo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.mongo.document.PersonaDocument;

public class PersonaMapper {
	@Autowired
    private ModelMapper mapper;
	
	
	
	public Persona toPersonaDocu(PersonaDocument dto) {
		return mapper.map(dto, Persona.class);
	}
	public PersonaDocument toPersonaDocu(Persona res) {
		return mapper.map(res, PersonaDocument.class);
	}
}
