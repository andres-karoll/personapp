package co.edu.javeriana.as.personapp.core.port.out;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Telefono;

import java.util.List;

public interface TelefonoPort {
    public Telefono save(Telefono telefono);

    public Boolean delete(Integer num);

    public List<Telefono> findAll();

    public Telefono findByNum(Integer num);

    public Integer count();
}
