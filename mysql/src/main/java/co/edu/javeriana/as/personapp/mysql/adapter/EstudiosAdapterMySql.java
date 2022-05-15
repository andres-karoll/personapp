package co.edu.javeriana.as.personapp.mysql.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.port.out.mysql.EstudioMySQLPort;
import co.edu.javeriana.as.personapp.mysql.entity.EstudiosEntity;
import co.edu.javeriana.as.personapp.mysql.mapper.EstudiosMapperMySql;
import co.edu.javeriana.as.personapp.mysql.repository.EstudiosRepositoryMySql;

public class EstudiosAdapterMySql implements EstudioMySQLPort
{
	@Autowired
	EstudiosRepositoryMySql _repo;
	
	@Autowired
	EstudiosMapperMySql _mapper;

	@Override
	public Estudio save(Estudio estudio) {
		EstudiosEntity localPer = _mapper.toEstudioEntity(estudio);
		_repo.save(localPer);
		return estudio;
	}

	@Override
	public List<Estudio> findAll() {
		List<EstudiosEntity> listEsEnt = _repo.findAll();
		List<Estudio> listEs = new ArrayList<Estudio>();
		for (EstudiosEntity ent : listEsEnt)
		{
			listEs.add(_mapper.toEstudioEntity(ent));
		}
		return listEs;
	}

	@Override
	public Estudio findByIdProfCcPer(Integer idProfesion, Integer ccPersona) 
	{
		EstudiosEntity n1= _repo.findItemByIdProfCcPer(idProfesion.toString(), ccPersona.toString());
		Estudio aux = _mapper.toEstudioEntity(n1);
		return aux;
	}


	@Override
	public Boolean delete(Integer idProfesion, Integer ccPersona) {
		_repo.delete(idProfesion.toString(), ccPersona.toString());
		return true;
	}

	@Override
	public Integer count() {
		return (int) _repo.count();
	}


}
