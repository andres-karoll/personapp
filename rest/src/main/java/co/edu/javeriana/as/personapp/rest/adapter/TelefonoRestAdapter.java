package co.edu.javeriana.as.personapp.rest.adapter;

import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.core.port.out.TelefonoPort;
import co.edu.javeriana.as.personapp.rest.client.TelefonoRestClient;
import co.edu.javeriana.as.personapp.rest.mapper.TelefonoRestMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelefonoRestAdapter implements TelefonoPort {
    @Autowired
    TelefonoRestClient telefonoRestClient;
    @Autowired
    TelefonoRestMapper telefonoRestMapper;

    @Override
    public Telefono save(Telefono telefono) {
        JSONObject tel = telefonoRestMapper.deTelefonoAJSONObject(telefono);
        return telefonoRestMapper.deJSONObjectATelefono(telefonoRestClient.create(tel));
    }

    @Override
    public Boolean delete(Integer num) {
        return telefonoRestClient.delete(num);
    }

    @Override
    public List<Telefono> findAll() {
        return telefonoRestMapper.deJSONArrayAListTelefono(telefonoRestClient.get());
    }

    @Override
    public Telefono findByNum(Integer num) {
        return telefonoRestMapper.deJSONObjectATelefono(telefonoRestClient.byID(num));
    }

    @Override
    public Integer count() {
        return telefonoRestClient.count();
    }
}
