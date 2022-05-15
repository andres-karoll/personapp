package co.edu.javeriana.as.personapp.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.javeriana.as.personapp.mysql.entity.ProfesionEntity;

public interface ProfesionRepositoryMySql extends JpaRepository<ProfesionEntity	, String>  {

	ProfesionEntity findItemByid(String id);
	public long count();
}
