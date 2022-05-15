package co.edu.javeriana.as.personapp.mongo.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.port.out.mongo.PersonaMongoDBPort;
import co.edu.javeriana.as.personapp.mongo.document.PersonaDocument;
import co.edu.javeriana.as.personapp.mongo.mapper.PersonaMapper;
import co.edu.javeriana.as.personapp.mongo.repository.PersonaRepository;

@Component
public class PersonaAdapter implements PersonaMongoDBPort {

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	PersonaMapper personaMapper;

	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		PersonaDocument aux = personaMapper.toPersonaDocu(persona);
		personaRepository.save(aux);
		return persona;
	}

	@Override
	public Boolean delete(Integer cc) {
		String aux = cc.toString();
		personaRepository.deleteById(aux);
		return null;
	}

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		List<PersonaDocument> PER = personaRepository.findAll();
		List<Persona> aux = new ArrayList<Persona>();
		for (PersonaDocument not : PER) {
			aux.add(personaMapper.toPersonaDocu(not));
		}

		return aux;
	}

	@Override
	public Persona findByCC(Integer cc) {
		PersonaDocument n1 = personaRepository.findItemByid(cc.toString());

		return personaMapper.toPersonaDocu(n1);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		long x;
		x = personaRepository.count();
		int retorno = (int) x;
		return retorno;

	}

	@Override
	public Persona update(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

}
