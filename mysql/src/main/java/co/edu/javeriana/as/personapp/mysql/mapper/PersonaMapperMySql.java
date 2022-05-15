package co.edu.javeriana.as.personapp.mysql.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.mysql.entity.PersonaEntity;

public class PersonaMapperMySql {
	@Autowired
	private ModelMapper mapper;
	
	public Persona toPersonaEntity (PersonaEntity ent)
	{
		return mapper.map(ent, Persona.class);
	}
	public PersonaEntity toPersonaEntity (Persona per)
	{
		return mapper.map(per, PersonaEntity.class);
	}

}
