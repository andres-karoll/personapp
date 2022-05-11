package co.edu.javeriana.as.personapp.core.port.out;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.domain.Persona;

import java.util.List;

public interface EstudioPort {
    public Estudio save(Estudio estudio);

    public Boolean delete(Integer idProfesion,Integer ccPersona);

    public List<Estudio> findAll();

    public Estudio findByCC(Integer idProfesion,Integer ccPersona);

    public Integer count();

}
