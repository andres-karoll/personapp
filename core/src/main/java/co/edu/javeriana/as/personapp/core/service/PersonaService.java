package co.edu.javeriana.as.personapp.core.service;

import java.util.List;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.port.out.rest.PersonaRestPort;
import co.edu.javeriana.as.personapp.core.usecase.PersonaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.port.out.mongo.PersonaMongoDBPort;
import co.edu.javeriana.as.personapp.core.port.out.mysql.PersonaMySQLPort;

@Service
public class PersonaService implements PersonaUseCase {
	
	@Autowired
	private PersonaMongoDBPort personaMongoPort;
	
	@Autowired
	private PersonaMySQLPort personaMySQLPort;

	@Autowired
	private PersonaRestPort personaRestPort;

	@Override
	public Persona buscarPorId(Integer cc) {
		Persona mongo = personaMongoPort.findByCC(cc);
		Persona mySQL = personaMySQLPort.findByCC(cc);
		Persona rest = personaRestPort.findByCC(cc);

		if(mongo.equals(rest) && mongo.equals(mySQL))
			return mongo;

		return null;
	}

	@Override
	public List<Persona> buscarTodo() {
		List<Persona> mongo = personaMongoPort.findAll();
		List<Persona> mySQL = personaMySQLPort.findAll();
		List<Persona> rest = personaRestPort.findAll();

		if(
				(mongo.size() == mySQL.size() && rest.size() == mySQL.size())
						&& (mongo.equals(mySQL) && mongo.equals(rest))
		) {
			return mongo;
		}

		return null;
	}

	@Override
	public Integer contar() {
		Integer mongo = personaMongoPort.count();
		Integer mySQL = personaMySQLPort.count();
		Integer rest = personaRestPort.count();

		if(mongo == mySQL && mongo == rest)
			return rest;

		return null;
	}

	@Override
	public Persona crear(Persona persona) {
		Persona mongo = personaMongoPort.save(persona);
		Persona mySQL = personaMySQLPort.save(persona);
		Persona rest = personaRestPort.save(persona);

		if(mongo != null && mySQL != null && rest != null)
			return mongo;

		return null;
	}

	@Override
	public Persona editar(Integer cc, Persona persona) {
		Persona mongo = personaMongoPort.save(persona);
		Persona mySQL = personaMySQLPort.save(persona);
		Persona rest = personaRestPort.save(persona);

		if(mongo != null && mySQL != null && rest != null)
			return mongo;

		return null;
	}

	@Override
	public Boolean eliminar(Integer cc) {
		Boolean mongo = personaMongoPort.delete(cc);
		Boolean mySQL = personaMySQLPort.delete(cc);
		Boolean rest = personaRestPort.delete(cc);

		if(mongo && mySQL && rest)
			return mongo;

		return false;
	}

}
