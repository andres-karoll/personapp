package co.edu.javeriana.as.personapp.rest.adapter;
import co.edu.javeriana.as.personapp.core.port.out.rest.PersonaRestPort;
import co.edu.javeriana.as.personapp.rest.client.PersonaClient;
import co.edu.javeriana.as.personapp.rest.mapper.PersonaMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.edu.javeriana.as.personapp.core.domain.Persona;

import java.util.List;

//en core debe haber un paquete que se llame reste ese se consume
@Component
public class PersonaAdapter implements PersonaRestPort {
    @Autowired
    private PersonaMapper personaMapper;
    @Autowired
    private PersonaClient personaClient;

    @Override
    public Persona save(Persona persona) {
        //De persona a JSONObject - Llamado a cliente - de JSONObject a persona
        JSONObject obj = personaMapper.dePersonaAJSONObject(persona);
        JSONObject ob = personaClient.create(obj);
        Persona per = personaMapper.deJSONObjectAPersona(ob);
        return per;
    }

    @Override
    public Boolean delete(Integer cc) {
        return personaClient.delete(cc);
    }

    @Override
    public List<Persona> findAll() {
        return personaMapper.deJSONArrayAListPersona(personaClient.get());
    }

    @Override
    public Persona findByCC(Integer cc) {
        return personaMapper.deJSONObjectAPersona(personaClient.byID(cc));
    }

    @Override
    public Integer count() {
        return null;
    }
}
