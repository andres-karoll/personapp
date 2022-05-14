package co.edu.javeriana.as.personapp.rest.mapper;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EstudioRestMapper {

    private PersonaRestMapper personaRestMapper;

    public List<Estudio> deJSONArrayAListEstudio(JSONArray jsonEstudio){
        List<Estudio> estudios = new ArrayList<>();
        if(jsonEstudio != null){
            for (int i=0; i<jsonEstudio.length(); i++){
                estudios.add(deJSONObjectAEstudio(jsonEstudio.getJSONObject(i)));
            }
        }
        return estudios;
    }

    public Estudio deJSONObjectAEstudio(JSONObject jsonEstudio){
        if(jsonEstudio != null) {
            Estudio estudio = new Estudio();
            estudio.setCcPersona(jsonEstudio.getInt("ccPersona"));
            estudio.setIdProfesion(jsonEstudio.getInt("idProfesion"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(jsonEstudio.getString("fecha"), formatter);
            estudio.setFecha(date);
            estudio.setUniversidad(jsonEstudio.getString("universidad"));
            return estudio;
        }
        return null;
    }

    public JSONObject deEstudioAJSONObject(Estudio estudio){

        JSONObject objeto = new JSONObject();
        objeto.put("idProfesion" , estudio.getIdProfesion());
        objeto.put("ccPersona", estudio.getCcPersona());
        objeto.put("fecha", estudio.getFecha().toString());
        objeto.put("universidad", estudio.getUniversidad());
        return objeto;
    }
}
