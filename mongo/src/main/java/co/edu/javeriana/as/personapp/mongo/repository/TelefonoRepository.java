package co.edu.javeriana.as.personapp.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.javeriana.as.personapp.mongo.document.TelefonoDocument;

public interface TelefonoRepository extends MongoRepository<TelefonoDocument	, Integer> {
    @Query("{id:'?0'}")
	TelefonoDocument findItemByid(Integer id);
	
	
	
	public long count();
}
