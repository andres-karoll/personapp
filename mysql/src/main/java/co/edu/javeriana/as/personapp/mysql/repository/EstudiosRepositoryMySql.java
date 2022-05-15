package co.edu.javeriana.as.personapp.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.javeriana.as.personapp.mysql.entity.EstudiosEntity;

public interface EstudiosRepositoryMySql extends JpaRepository<EstudiosEntity	, String>  {

    @Query( value = "SELECT e FROM Estudios e WHERE e.estudiosPK.ccPer = :ccPer AND e.estudiosPK.idProf = :idProf")
	EstudiosEntity findItemByIdProfCcPer(String ccPer, String idProf);
    @Query( value = "DELETE e FROM Estudios e WHERE e.estudiosPK.ccPer = :ccPer AND e.estudiosPK.idProf = :idProf")
    Boolean delete (String idProfesion,String ccPersona);
	public long count();
}
