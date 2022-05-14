package co.edu.javeriana.as.personapp.rest.adapter;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.port.out.EstudioPort;
import co.edu.javeriana.as.personapp.rest.client.EstudioClient;
import co.edu.javeriana.as.personapp.rest.mapper.EstudioMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudioAdapter implements EstudioPort {
    @Autowired
    private EstudioMapper estudioMapper;
    @Autowired
    private EstudioClient estudioClient;


    @Override
    public Estudio save(Estudio estudio) {
        JSONObject estud = estudioMapper.deEstudioAJSONObject(estudio);
        return estudioMapper.deJSONObjectAEstudio(estud);
    }

    @Override
    public Boolean delete(Integer idProfesion, Integer ccPersona) {
        return estudioClient.delete(idProfesion, ccPersona);
    }

    @Override
    public List<Estudio> findAll() {
        return estudioMapper.deJSONArrayAListEstudio(estudioClient.getEstudios());
    }

    @Override
    public Estudio findByIdProfCcPer(Integer idProfesion, Integer ccPersona) {
        return estudioMapper.deJSONObjectAEstudio(estudioClient.byID(idProfesion, ccPersona));
    }

    @Override
    public Integer count() {
        return estudioClient.count();
    }
}
