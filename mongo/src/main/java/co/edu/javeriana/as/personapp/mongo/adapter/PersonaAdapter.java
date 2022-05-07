package co.edu.javeriana.as.personapp.mongo.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.port.out.mongo.PersonaMongoDBPort;

@Component
public class PersonaAdapter implements PersonaMongoDBPort {

	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Integer cc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findByCC(Integer cc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

}
