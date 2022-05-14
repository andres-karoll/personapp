package co.edu.javeriana.as.personapp.mongo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.mongo.document.TelefonoDocument;

public class TelefonoMapper {
    @Autowired
    private ModelMapper mapper;
	
	
	
	public Telefono toPersonaDocu(TelefonoDocument dto) {
		return mapper.map(dto, Telefono.class);
	}
	public TelefonoDocument toPersonaDocu(Telefono res) {
		return mapper.map(res, TelefonoDocument.class);
	}
}
