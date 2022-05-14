package co.edu.javeriana.as.personapp.core.port.out.mongo;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.port.out.PersonaPort;

import java.util.List;

public interface PersonaMongoDBPort extends PersonaPort{
    public Persona save(Persona persona);
    public List<Persona> findAll();
    public Persona findByCC(Integer cc);
    public Persona update(Persona persona);
    public Boolean delete(Persona persona);
    public Integer count(Persona persona);
}
