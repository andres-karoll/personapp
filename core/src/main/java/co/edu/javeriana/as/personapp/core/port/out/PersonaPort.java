package co.edu.javeriana.as.personapp.core.port.out;

import java.util.List;

import co.edu.javeriana.as.personapp.core.domain.Persona;

public interface PersonaPort {
	
	public Persona save(Persona persona);
	
	public Boolean delete(Integer cc);
	
	public List<Persona> findAll();
	
	public List<Persona> findByCC(Integer cc);
	
	public Integer count();

}
