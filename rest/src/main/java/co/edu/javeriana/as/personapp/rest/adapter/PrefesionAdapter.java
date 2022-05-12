package co.edu.javeriana.as.personapp.rest.adapter;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.port.out.ProfesionPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrefesionAdapter implements ProfesionPort {
    @Override
    public Profesion save(Profesion profesion) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public List<Profesion> findAll() {
        return null;
    }

    @Override
    public Profesion findById(Integer id) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }
}
