package co.edu.javeriana.as.personapp.rest.adapter;
import co.edu.javeriana.as.personapp.core.port.out.rest.PersonaRestPort;
import co.edu.javeriana.as.personapp.rest.client.PersonaRestClient;
import co.edu.javeriana.as.personapp.rest.mapper.PersonaRestMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.edu.javeriana.as.personapp.core.domain.Persona;

import java.util.List;

@Component
public class PersonaRestAdapter implements PersonaRestPort {
    @Autowired
    private PersonaRestMapper personaRestMapper;
    @Autowired
    private PersonaRestClient personaRestClient;

    @Override
    public Persona save(Persona persona) {
        //De persona a JSONObject - Llamado a cliente - de JSONObject a persona
        JSONObject obj = personaRestMapper.dePersonaAJSONObject(persona);
        JSONObject ob = personaRestClient.create(obj);
        Persona per = personaRestMapper.deJSONObjectAPersona(ob);
        return per;
    }

    @Override
    public Boolean delete(Integer cc) {
        return personaRestClient.delete(cc);
    }

    @Override
    public List<Persona> findAll() {
        return personaRestMapper.deJSONArrayAListPersona(personaRestClient.get());
    }

    @Override
    public Persona findByCC(Integer cc) {
        return personaRestMapper.deJSONObjectAPersona(personaRestClient.byID(cc));
    }

    @Override
    public Integer count() {
        return personaRestClient.count();
    }
}
