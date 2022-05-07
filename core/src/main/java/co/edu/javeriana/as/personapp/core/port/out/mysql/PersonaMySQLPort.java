package co.edu.javeriana.as.personapp.core.port.out.mysql;

import java.util.List;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.port.out.PersonaPort;

public interface PersonaMySQLPort extends PersonaPort{
	
	public List<Persona> findByName(String name);

}
