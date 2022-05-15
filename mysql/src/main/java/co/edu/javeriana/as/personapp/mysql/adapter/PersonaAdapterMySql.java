package co.edu.javeriana.as.personapp.mysql.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.port.out.mysql.PersonaMySQLPort;
import co.edu.javeriana.as.personapp.mysql.entity.PersonaEntity;
import co.edu.javeriana.as.personapp.mysql.mapper.PersonaMapperMySql;
import co.edu.javeriana.as.personapp.mysql.repository.PersonaRepositoryMySql;

public class PersonaAdapterMySql implements PersonaMySQLPort
{
	@Autowired
	PersonaRepositoryMySql _repo;
	
	@Autowired
	PersonaMapperMySql _mapper;

	@Override
	public Persona save(Persona persona) {
		PersonaEntity localPer = _mapper.toPersonaEntity(persona);
		_repo.save(localPer);
		return persona;
	}

	@Override
	public List<Persona> findAll() {
		List<PersonaEntity> listPEnt = _repo.findAll();
		List<Persona> listPer = new ArrayList<Persona>();
		for (PersonaEntity ent : listPEnt)
		{
			listPer.add(_mapper.toPersonaEntity(ent));
		}
		return listPer;
	}

	@Override
	public Persona findByCC(Integer cc) {
		PersonaEntity n1= _repo.findItemBycc(cc.toString());
		Persona aux = _mapper.toPersonaEntity(n1);
		return aux;
	}


	@Override
	public Boolean delete(Integer cc) {
		String cc_string = cc.toString();
		_repo.deleteById(cc_string);
		return true;
	}

	@Override
	public Integer count() {
		return (int) _repo.count();
	}


}
