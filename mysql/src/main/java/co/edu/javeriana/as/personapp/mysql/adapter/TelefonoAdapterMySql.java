package co.edu.javeriana.as.personapp.mysql.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.core.port.out.mysql.TelefonoMySQLPort;
import co.edu.javeriana.as.personapp.mysql.entity.TelefonoEntity;
import co.edu.javeriana.as.personapp.mysql.mapper.TelefonoMapperMySql;
import co.edu.javeriana.as.personapp.mysql.repository.TelefonoRepositoryMySql;

public class TelefonoAdapterMySql implements TelefonoMySQLPort
{
	@Autowired
	TelefonoRepositoryMySql _repo;
	
	@Autowired
	TelefonoMapperMySql _mapper;

	@Override
	public Telefono save(Telefono telefono) {
		TelefonoEntity localPer = _mapper.toTelefonoEntity(telefono);
		_repo.save(localPer);
		return telefono;
	}

	@Override
	public List<Telefono> findAll() {
		List<TelefonoEntity> listTEnt = _repo.findAll();
		List<Telefono> listTel = new ArrayList<Telefono>();
		for (TelefonoEntity ent : listTEnt)
		{
			listTel.add(_mapper.toTelefonoEntity(ent));
		}
		return listTel;
	}

	@Override
	public Telefono findByNum(Integer cc) {
		TelefonoEntity n1= _repo.findItemByNum(cc.toString());
		Telefono aux = _mapper.toTelefonoEntity(n1);
		return aux;
	}


	@Override
	public Boolean delete(Integer num) {
		String num_string = num.toString();
		_repo.deleteById(num_string);
		return true;
	}

	@Override
	public Integer count() {
		return (int) _repo.count();
	}


}
