package co.edu.javeriana.as.personapp.rest.adapter;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.port.out.EstudioPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudioAdapter implements EstudioPort {
    @Override
    public Estudio save(Estudio estudio) {
        return null;
    }

    @Override
    public Boolean delete(Integer idProfesion, Integer ccPersona) {
        return null;
    }

    @Override
    public List<Estudio> findAll() {
        return null;
    }

    @Override
    public Estudio findByIdProfCcPer(Integer idProfesion, Integer ccPersona) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }
}
