package co.edu.javeriana.as.personapp.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.javeriana.as.personapp.mysql.entity.TelefonoEntity;

public interface TelefonoRepositoryMySql extends JpaRepository<TelefonoEntity	, String>  {

	TelefonoEntity findItemByNum(String id);
	public long count();
}
