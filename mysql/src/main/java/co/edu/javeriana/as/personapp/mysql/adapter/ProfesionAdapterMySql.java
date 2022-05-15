package co.edu.javeriana.as.personapp.mysql.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.port.out.mysql.ProfesionMySQLPort;
import co.edu.javeriana.as.personapp.mysql.entity.ProfesionEntity;
import co.edu.javeriana.as.personapp.mysql.mapper.ProfesionMapperMySql;
import co.edu.javeriana.as.personapp.mysql.repository.ProfesionRepositoryMySql;

public class ProfesionAdapterMySql implements ProfesionMySQLPort
{
	@Autowired
	ProfesionRepositoryMySql _repo;
	
	@Autowired
	ProfesionMapperMySql _mapper;

	@Override
	public Profesion save(Profesion profesion) {
		ProfesionEntity localProf = _mapper.toProfesionEntity(profesion);
		_repo.save(localProf);
		return profesion;
	}

	@Override
	public List<Profesion> findAll() {
		List<ProfesionEntity> listPEnt = _repo.findAll();
		List<Profesion> listProf = new ArrayList<Profesion>();
		for (ProfesionEntity ent : listPEnt)
		{
			listProf.add(_mapper.toProfesionEntity(ent));
		}
		return listProf;
	}

	@Override
	public Profesion findById(Integer id) {
		ProfesionEntity n1= _repo.findItemByid(id.toString());
		Profesion aux = _mapper.toProfesionEntity(n1);
		return aux;
	}


	@Override
	public Boolean delete(Integer id) {
		String id_string = id.toString();
		_repo.deleteById(id_string);
		return true;
	}

	@Override
	public Integer count() {
		return (int) _repo.count();
	}


}
