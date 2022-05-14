package co.edu.javeriana.as.personapp.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument;

public interface ProfesionRepository extends MongoRepository<ProfesionDocument	, Integer> {
    @Query("{id:'?0'}")
	ProfesionDocument findItemByid(Integer id);
	
	
	
	public long count();
}
