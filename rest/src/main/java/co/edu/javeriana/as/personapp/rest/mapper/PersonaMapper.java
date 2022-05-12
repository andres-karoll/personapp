package co.edu.javeriana.as.personapp.rest.mapper;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonaMapper {
    public List<Persona> deJSONArrayAListPersona(JSONArray jsonPersona){
        List<Persona> personas = new ArrayList<>();
        if(jsonPersona != null){
            for (int i=0; i<jsonPersona.length(); i++){
                Persona persona = new Persona();
                persona.setNombre(jsonPersona.getJSONObject(i).getString("nombre"));
                persona.setApellido(jsonPersona.getJSONObject(i).getString("apellido"));
                personas.add(persona);
            }
        }
        return null;
    }

    public Persona deJSONObjectAPersona(JSONObject jsonPersona){
        Persona person = new Persona();
        return person;
    }

    public Integer deJSONObjectANumber(JSONObject jsonNumber){
        Integer number = 0;
        return number;
    }
}
