package co.edu.javeriana.as.personapp.rest.mapper;

import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonaRestMapper {
    EstudioRestMapper estudioRestMapper;
    TelefonoRestMapper telefonoRestMapper;

    public List<Persona> deJSONArrayAListPersona(JSONArray jsonPersona){
        List<Persona> personas = new ArrayList<>();
        if(jsonPersona != null){
            for (int i=0; i<jsonPersona.length(); i++){
                personas.add(deJSONObjectAPersona(jsonPersona.getJSONObject(i)));
            }
        }
        return personas;
    }

    public Persona deJSONObjectAPersona(JSONObject jsonPersona){
        if(jsonPersona != null) {
            Persona person = new Persona(jsonPersona.getInt("cc"), jsonPersona.getString("nombre"), jsonPersona.getString("apellido"), jsonPersona.getEnum(Genero.class, "genero"), jsonPersona.getInt("edad"));
            person.setEstudios(estudioRestMapper.deJSONArrayAListEstudio(jsonPersona.getJSONArray("estudios")));
            person.setTelefonos(telefonoRestMapper.deJSONArrayAListTelefono(jsonPersona.getJSONArray("telefonos")));
            return person;
        }
        return null;
    }

    public JSONObject dePersonaAJSONObject(Persona persona){

        JSONObject objeto = new JSONObject();
        objeto.put("cc", persona.getCc());
        objeto.put("nombre", persona.getNombre());
        objeto.put("apellido", persona.getApellido());
        objeto.put("genero", persona.getGenero());
        objeto.put("edad", persona.getEdad());
        objeto.put("telefonos", persona.getTelefonos());
        objeto.put("estudios", persona.getEstudios());

        return objeto;
    }

}
