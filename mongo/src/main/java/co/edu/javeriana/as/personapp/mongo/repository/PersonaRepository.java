package co.edu.javeriana.as.personapp.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.javeriana.as.personapp.mongo.document.PersonaDocument;

public interface PersonaRepository extends MongoRepository<PersonaDocument	, String>{

	@Query("{id:'?0'}")
	PersonaDocument findItemByid(String id);
	
	
	
	public long count();
	
}
