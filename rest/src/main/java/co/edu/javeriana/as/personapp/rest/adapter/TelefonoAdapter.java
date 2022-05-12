package co.edu.javeriana.as.personapp.rest.adapter;

import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.core.port.out.TelefonoPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelefonoAdapter implements TelefonoPort {
    @Override
    public Telefono save(Telefono telefono) {
        return null;
    }

    @Override
    public Boolean delete(Integer num) {
        return null;
    }

    @Override
    public List<Telefono> findAll() {
        return null;
    }

    @Override
    public Telefono findByNum(Integer num) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }
}
