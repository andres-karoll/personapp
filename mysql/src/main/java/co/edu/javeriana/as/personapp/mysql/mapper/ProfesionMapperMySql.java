package co.edu.javeriana.as.personapp.mysql.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.mysql.entity.ProfesionEntity;

public class ProfesionMapperMySql {
	@Autowired
	private ModelMapper mapper;
	
	public Profesion toProfesionEntity (ProfesionEntity ent)
	{
		return mapper.map(ent, Profesion.class);
	}
	public ProfesionEntity toProfesionEntity (Profesion prof)
	{
		return mapper.map(prof, ProfesionEntity.class);
	}

}
