package co.edu.javeriana.as.personapp.core.port.out;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Profesion;

import java.util.List;

public interface ProfesionPort {
    public Profesion save(Profesion profesion);

    public Boolean delete(Integer id);

    public List<Profesion> findAll();

    public Profesion findByCC(Integer id);

    public Integer count();
}
