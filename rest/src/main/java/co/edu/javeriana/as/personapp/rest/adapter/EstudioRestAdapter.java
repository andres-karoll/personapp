package co.edu.javeriana.as.personapp.rest.adapter;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.port.out.EstudioPort;
import co.edu.javeriana.as.personapp.rest.client.EstudioRestClient;
import co.edu.javeriana.as.personapp.rest.mapper.EstudioRestMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudioRestAdapter implements EstudioPort {
    @Autowired
    private EstudioRestMapper estudioRestMapper;
    @Autowired
    private EstudioRestClient estudioRestClient;


    @Override
    public Estudio save(Estudio estudio) {
        JSONObject estud = estudioRestMapper.deEstudioAJSONObject(estudio);
        return estudioRestMapper.deJSONObjectAEstudio(estud);
    }

    @Override
    public Boolean delete(Integer idProfesion, Integer ccPersona) {
        return estudioRestClient.delete(idProfesion, ccPersona);
    }

    @Override
    public List<Estudio> findAll() {
        return estudioRestMapper.deJSONArrayAListEstudio(estudioRestClient.getEstudios());
    }

    @Override
    public Estudio findByIdProfCcPer(Integer idProfesion, Integer ccPersona) {
        return estudioRestMapper.deJSONObjectAEstudio(estudioRestClient.byID(idProfesion, ccPersona));
    }

    @Override
    public Integer count() {
        return estudioRestClient.count();
    }
}
