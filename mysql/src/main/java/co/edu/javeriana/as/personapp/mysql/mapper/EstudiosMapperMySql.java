package co.edu.javeriana.as.personapp.mysql.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.mysql.entity.EstudiosEntity;

public class EstudiosMapperMySql {
	@Autowired
	private ModelMapper mapper;
	
	public Estudio toEstudioEntity (EstudiosEntity ent)
	{
		return mapper.map(ent, Estudio.class);
	}
	public EstudiosEntity toEstudioEntity (Estudio est)
	{
		return mapper.map(est, EstudiosEntity.class);
	}

}
