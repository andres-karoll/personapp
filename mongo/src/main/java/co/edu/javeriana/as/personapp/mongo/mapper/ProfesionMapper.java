package co.edu.javeriana.as.personapp.mongo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument;

public class ProfesionMapper {
    @Autowired
    private ModelMapper mapper;
	
	
	
	public Profesion toPersonaDocu(ProfesionDocument dto) {
		return mapper.map(dto, Profesion.class);
	}
	public ProfesionDocument toPersonaDocu(Profesion res) {
		return mapper.map(res, ProfesionDocument.class);
	}
}
