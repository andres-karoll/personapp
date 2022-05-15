package co.edu.javeriana.as.personapp.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.javeriana.as.personapp.mysql.entity.PersonaEntity;

public interface PersonaRepositoryMySql extends JpaRepository<PersonaEntity	, String>  {

	PersonaEntity findItemBycc(String id);
	public long count();
}
