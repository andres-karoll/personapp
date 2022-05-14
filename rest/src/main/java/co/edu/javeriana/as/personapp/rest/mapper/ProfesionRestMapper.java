package co.edu.javeriana.as.personapp.rest.mapper;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProfesionRestMapper {
    EstudioRestMapper estudioRestMapper;

    public List<Profesion> deJSONArrayAListProfesiones(JSONArray jsonProfesion){
        List<Profesion> profesiones = new ArrayList<>();
        if(jsonProfesion != null){
            for (int i=0; i<jsonProfesion.length(); i++){
                profesiones.add(deJSONObjectAProfesion(jsonProfesion.getJSONObject(i)));
            }
        }
        return profesiones;
    }

    public Profesion deJSONObjectAProfesion(JSONObject jsonProfesion){
        if(jsonProfesion != null) {
            Profesion profesion = new Profesion(jsonProfesion.getInt("id"), jsonProfesion.getString("nom"), jsonProfesion.getString("des"));
            profesion.setEstudios(estudioRestMapper.deJSONArrayAListEstudio(jsonProfesion.getJSONArray("estudios")));
            return profesion;
        }
        return null;
    }

    public JSONObject deProfesionAJSONObject(Profesion profesion){

        JSONObject objeto = new JSONObject();
        objeto.put("id", profesion.getId());
        objeto.put("nom", profesion.getNom());
        objeto.put("des", profesion.getDes());
        objeto.put("estudios", profesion.getEstudios());
        return objeto;
    }
}
