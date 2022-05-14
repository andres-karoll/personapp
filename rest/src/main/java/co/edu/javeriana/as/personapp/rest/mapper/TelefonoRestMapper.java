package co.edu.javeriana.as.personapp.rest.mapper;

import co.edu.javeriana.as.personapp.core.domain.Telefono;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TelefonoRestMapper {

    public List<Telefono> deJSONArrayAListTelefono(JSONArray jsonTelefono){
        List<Telefono> telefonos = new ArrayList<>();
        if(jsonTelefono != null){
            for (int i=0; i<jsonTelefono.length(); i++){
                telefonos.add(deJSONObjectATelefono(jsonTelefono.getJSONObject(i)));
            }
        }
        return telefonos;
    }

    public Telefono deJSONObjectATelefono(JSONObject jsonTelefono){
        if(jsonTelefono != null) {
            Telefono telefono = new Telefono(jsonTelefono.getString("num"), jsonTelefono.getString("oper"));
            return telefono;
        }
        return null;
    }

    public JSONObject deTelefonoAJSONObject(Telefono telefono){
        JSONObject objeto = new JSONObject();
        objeto.put("num", telefono.getNum());
        objeto.put("oper", telefono.getOper());
        return objeto;
    }
}
