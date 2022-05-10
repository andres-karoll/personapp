package co.edu.javeriana.as.personapp.core.service;

import java.util.List;

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

	@Override
	public Persona buscarPorId(Integer cc) {
		return personaMongoPort.findByCC(cc);
	}

	@Override
	public List<Persona> buscarTodo() {
		return personaMongoPort.findAll();
	}

	@Override
	public Integer contar() {
		return personaMongoPort.count();
	}

	@Override
	public Persona crear(Persona persona) {
		return personaMongoPort.update(persona);
	}

	@Override
	public Persona editar(Integer cc, Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer cc) {
		// TODO Auto-generated method stub
		return null;
	}

}
