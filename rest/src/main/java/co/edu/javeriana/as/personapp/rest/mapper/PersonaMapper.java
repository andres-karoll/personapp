package co.edu.javeriana.as.personapp.rest.mapper;

import co.edu.javeriana.as.personapp.core.*;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PersonaMapper {
    public List<Persona> deJSONArrayAListPersona(JSONArray jsonPersona){
        List<Persona> personas = new ArrayList<>();
        if(jsonPersona != null){
            for (int i=0; i<jsonPersona.length(); i++){

            }
        }
        return null;
    }

    public Persona deJSONObjectAPersona(JSONObject jsonPersona){

        return null;
    }
}
