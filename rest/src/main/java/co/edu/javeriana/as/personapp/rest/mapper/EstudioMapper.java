package co.edu.javeriana.as.personapp.rest.mapper;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EstudioMapper {

    private PersonaMapper personaMapper;

    public List<Estudio> deJSONArrayAListEstudio(JSONArray jsonEstudio){
        List<Estudio> personas = new ArrayList<>();
        if(jsonEstudio != null){
            for (int i=0; i<jsonEstudio.length(); i++){
                personas.add(deJSONObjectAEstudio(jsonEstudio.getJSONObject(i)));
            }
        }
        return personas;
    }

    public Estudio deJSONObjectAEstudio(JSONObject jsonEstudio){
        if(jsonEstudio != null) {
            Estudio estudio = new Estudio();
            estudio.setCcPersona(jsonEstudio.getInt("ccPersona"));
            estudio.setIdProfesion(jsonEstudio.getInt("idProfesion"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
            LocalDate date = LocalDate.parse(jsonEstudio.getString("fecha"), formatter);
            estudio.setFecha(date);
            estudio.setUniversidad(jsonEstudio.getString("universidad"));
            Persona persona = personaMapper.deJSONObjectAPersona(jsonEstudio.getJSONObject("persona"));
            estudio.setPersona(persona);
            //estudio.setProfesion(jsonEstudio.getJSONObject("profesion"));
            return estudio;
        }
        return null;
    }

    public JSONObject deEstudioAJSONObject(Estudio estudio){

        JSONObject objeto = new JSONObject();
        objeto.put("idProfesion" , estudio.getIdProfesion());
        objeto.put("ccPersona", estudio.getCcPersona());
        objeto.put("fecha", estudio.getFecha());
        objeto.put("universidad", estudio.getUniversidad());
        JSONObject person = new JSONObject(estudio.getPersona());
        objeto.put("persona", person);
        return objeto;
    }
}
