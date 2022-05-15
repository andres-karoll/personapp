package co.edu.javeriana.as.personapp.mysql.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.mysql.entity.TelefonoEntity;

public class TelefonoMapperMySql {
	@Autowired
	private ModelMapper mapper;
	
	public Telefono toTelefonoEntity (TelefonoEntity ent)
	{
		return mapper.map(ent, Telefono.class);
	}
	public TelefonoEntity toTelefonoEntity (Telefono est)
	{
		return mapper.map(est, TelefonoEntity.class);
	}

}
