package co.edu.javeriana.as.personapp.rest.adapter;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.port.out.ProfesionPort;
import co.edu.javeriana.as.personapp.rest.client.ProfesionRestClient;
import co.edu.javeriana.as.personapp.rest.mapper.ProfesionRestMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfesionRestAdapter implements ProfesionPort {
    @Autowired
    ProfesionRestMapper profesionRestMapper;
    @Autowired
    ProfesionRestClient profesionRestClient;

    @Override
    public Profesion save(Profesion profesion) {
        JSONObject prof = profesionRestMapper.deProfesionAJSONObject(profesion);
        return profesionRestMapper.deJSONObjectAProfesion(prof);
    }

    @Override
    public Boolean delete(Integer id) {
        return profesionRestClient.delete(id);
    }

    @Override
    public List<Profesion> findAll() {
        return profesionRestMapper.deJSONArrayAListProfesiones(profesionRestClient.get());
    }

    @Override
    public Profesion findById(Integer id) {
        return profesionRestMapper.deJSONObjectAProfesion(profesionRestClient.byID(id));
    }

    @Override
    public Integer count() {
        return profesionRestClient.count();
    }
}
