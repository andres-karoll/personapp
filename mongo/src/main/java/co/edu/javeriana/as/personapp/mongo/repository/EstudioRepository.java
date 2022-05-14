package co.edu.javeriana.as.personapp.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.javeriana.as.personapp.mongo.document.EstudioDocument;

public interface EstudioRepository extends MongoRepository<EstudioDocument	, Integer>{



    @Query("{id:'?0'}")
	EstudioDocument findItemByid(Integer id);
	
	
	
	public long count();
}
