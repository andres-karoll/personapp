package co.edu.javeriana.as.personapp.mongo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.mongo.document.EstudioDocument;

public class EstudioMapper {
    @Autowired
    private ModelMapper mapper;
	
	
	
	public Estudio toPersonaDocu(EstudioDocument dto) {
		return mapper.map(dto, Estudio.class);
	}
	public EstudioDocument toPersonaDocu(Estudio res) {
		return mapper.map(res, EstudioDocument.class);
	}
}
