package co.edu.javeriana.as.personapp.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.port.out.mongo.PersonaMongoDBPort;
import co.edu.javeriana.as.personapp.core.port.out.mysql.PersonaMySQLPort;
import co.edu.javeriana.as.personapp.core.usecase.PersonaConsultaUseCase;
import co.edu.javeriana.as.personapp.core.usecase.PersonaModificacionUseCase;

@Service
public class PersonaService implements PersonaModificacionUseCase, PersonaConsultaUseCase{
	
	@Autowired
	private PersonaMongoDBPort personaMongoPort;
	
	@Autowired
	private PersonaMySQLPort personaMySQLPort;

	@Override
	public Persona buscarPorId(Integer cc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> buscarTodo() {
		return personaMongoPort.findAll();
	}

	@Override
	public Integer contar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona crear(Persona persona) {
		// TODO Auto-generated method stub
		return null;
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
